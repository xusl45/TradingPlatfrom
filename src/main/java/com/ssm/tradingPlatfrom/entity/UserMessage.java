package com.ssm.tradingPlatfrom.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserMessage {
    private int id;
    private String email;//邮箱
    private String nickName;
    private String sex;//性别
    private String introduce;//简介
    private String sellNum;//出售数量
    private String buyNum;//购买数量
    private String img;//头像
    private String age;//居住地

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date bornTime;//注册时间

    public UserMessage()
    {
    }

    public UserMessage(int id, String email, String nickName, String sex, String introduce, String img, String age) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.sex = sex;
        this.introduce = introduce;
        this.img = img;
        this.age = age;
    }

    public UserMessage(int id, String email, String nickName, String sex, String introduce, String sellNum, String buyNum, String img, String age) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.sex = sex;
        this.introduce = introduce;
        this.sellNum = sellNum;
        this.buyNum = buyNum;
        this.img = img;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", introduce='" + introduce + '\'' +
                ", sellNum='" + sellNum + '\'' +
                ", buyNum='" + buyNum + '\'' +
                ", img='" + img + '\'' +
                ", age='" + age + '\'' +
                ", bornTime=" + bornTime +
                '}';
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getSellNum() {
        return sellNum;
    }

    public void setSellNum(String sellNum) {
        this.sellNum = sellNum;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public Date getBornTime() {
        return bornTime;
    }

    public void setBornTime(Date bornTime) {
        this.bornTime = bornTime;
    }
}

