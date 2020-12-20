package com.hzq.ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzq.pojo.Message;
import com.hzq.utils.MessageUtils;
import com.hzq.pojo.Message;
import com.hzq.utils.MessageUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

@ServerEndpoint(
        value = "/chat",
        configurator = GetHttpSessionConfigurator.class
)
@Component
public class ChatEndpoint {
    private static Map<String, ChatEndpoint> onlineUser = new ConcurrentHashMap();
    private Session session;
    private HttpSession httpSession;

    public ChatEndpoint() {
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;
        HttpSession httpSession = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;
        String username = (String)httpSession.getAttribute("user");
        onlineUser.put(username, this);
        String message = MessageUtils.getMessage(true, (String)null, this.getNames());
        this.broadcastAllUsers(message);
    }

    private void broadcastAllUsers(String message) {
        try {
            Set<String> names = onlineUser.keySet();
            Iterator var3 = names.iterator();

            while(var3.hasNext()) {
                String name = (String)var3.next();
                ChatEndpoint chatEndpoint = (ChatEndpoint)onlineUser.get(name);
                chatEndpoint.session.getBasicRemote().sendText(message);
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    private Set<String> getNames() {
        return onlineUser.keySet();
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message mess = (Message)mapper.readValue(message, Message.class);
            String toName = mess.getToName();
            String data = mess.getMessage();
            String username = (String)this.httpSession.getAttribute("user");
            String resultMessage = MessageUtils.getMessage(false, username, data);
            ((ChatEndpoint)onlineUser.get(toName)).session.getBasicRemote().sendText(resultMessage);
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    @OnClose
    public void onClose(Session session) {
        String username = (String)this.httpSession.getAttribute("user");
        onlineUser.remove(username);
        String message = MessageUtils.getMessage(true, (String)null, this.getNames());
        this.broadcastAllUsers(message);
    }
}
