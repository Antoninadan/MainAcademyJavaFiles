package com.mainacad.model;

import java.io.Serializable;

public class ConnectionInfo implements Serializable {
    private String ip;
    private Integer sessionId;
    private Long connectionTime;

    public ConnectionInfo(String ip, Integer sessionId, Long connectionTime) {
        this.ip = ip;
        this.sessionId = sessionId;
        this.connectionTime = connectionTime;
    }

    public ConnectionInfo() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Long getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(Long connectionTime) {
        this.connectionTime = connectionTime;
    }

    @Override
    public String toString() {
        return sessionId + " " + connectionTime + " " + ip;
    }
}
