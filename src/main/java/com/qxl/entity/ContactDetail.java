package com.qxl.entity;

public class ContactDetail {
    private Integer id;

    private String contactMobile;

    private String contactArea;

    private Integer callCount6month;

    private String mainDataId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile == null ? null : contactMobile.trim();
    }

    public String getContactArea() {
        return contactArea;
    }

    public void setContactArea(String contactArea) {
        this.contactArea = contactArea == null ? null : contactArea.trim();
    }

    public Integer getCallCount6month() {
        return callCount6month;
    }

    public void setCallCount6month(Integer callCount6month) {
        this.callCount6month = callCount6month;
    }

    public String getMainDataId() {
        return mainDataId;
    }

    public void setMainDataId(String mainDataId) {
        this.mainDataId = mainDataId == null ? null : mainDataId.trim();
    }
}