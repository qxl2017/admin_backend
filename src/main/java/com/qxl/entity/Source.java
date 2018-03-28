package com.qxl.entity;

public class Source {
    private Integer id;

    private String realSourceName;

    private String nickSourceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealSourceName() {
        return realSourceName;
    }

    public void setRealSourceName(String realSourceName) {
        this.realSourceName = realSourceName == null ? null : realSourceName.trim();
    }

    public String getNickSourceName() {
        return nickSourceName;
    }

    public void setNickSourceName(String nickSourceName) {
        this.nickSourceName = nickSourceName == null ? null : nickSourceName.trim();
    }
}