package com.ssm.tradingPlatfrom.utils;

/**
 * 定义响应的状态码
 */
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(201,"ERROR"),
    NEED_LOG(1,"NEED_LOG");
    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
