package com.blackface.seckill.domain;

import java.util.Date;

public class SystemMessage {
    private Long id;

    private Long messageInfoId;

    private Long senderId;

    private String senderNick;

    private String msgType;

    private String sendType;

    private Long sucNum;

    private String expireFlag;

    private Date expireTime;

    private Date pushTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessageInfoId() {
        return messageInfoId;
    }

    public void setMessageInfoId(Long messageInfoId) {
        this.messageInfoId = messageInfoId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getSenderNick() {
        return senderNick;
    }

    public void setSenderNick(String senderNick) {
        this.senderNick = senderNick == null ? null : senderNick.trim();
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType == null ? null : sendType.trim();
    }

    public Long getSucNum() {
        return sucNum;
    }

    public void setSucNum(Long sucNum) {
        this.sucNum = sucNum;
    }

    public String getExpireFlag() {
        return expireFlag;
    }

    public void setExpireFlag(String expireFlag) {
        this.expireFlag = expireFlag == null ? null : expireFlag.trim();
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}