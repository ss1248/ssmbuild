package com.hzq.pojo;


public class ResultMessage {
    private boolean isSystem;
    private String fromName;
    private Object message;

    public ResultMessage() {
    }

    public boolean getIsSystem() {
        return this.isSystem;
    }

    public void setISSystem(boolean isSystem) {
        this.isSystem = isSystem;
    }

    public String getFromName() {
        return this.fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Object getMessage() {
        return this.message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
