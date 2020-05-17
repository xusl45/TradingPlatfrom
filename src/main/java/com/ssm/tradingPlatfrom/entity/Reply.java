package com.ssm.tradingPlatfrom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Reply {
    private  int id;
    private String content;
    private  int formUid;
    private int toUid;
    private  int topicID;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;//时间

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", formUid=" + formUid +
                ", toUid=" + toUid +
                ", topicID=" + topicID +
                ", time=" + time +
                '}';
    }

    public Reply() {
    }

    public Reply(String content, int formUid, int toUid, int topicID) {
        this.content = content;
        this.formUid = formUid;
        this.toUid = toUid;
        this.topicID = topicID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFormUid() {
        return formUid;
    }

    public void setFormUid(int formUid) {
        this.formUid = formUid;
    }

    public int getToUid() {
        return toUid;
    }

    public void setToUid(int toUid) {
        this.toUid = toUid;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
