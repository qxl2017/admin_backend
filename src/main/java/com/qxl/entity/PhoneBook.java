package com.qxl.entity;

public class PhoneBook {
    private Integer id;

    private String nickname;

    private String mobile;

    private String mainDataId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getMainDataId() {
        return mainDataId;
    }

    public void setMainDataId(String mainDataId) {
        this.mainDataId = mainDataId == null ? null : mainDataId.trim();
    }
}