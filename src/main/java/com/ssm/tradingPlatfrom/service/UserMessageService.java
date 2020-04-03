package com.ssm.tradingPlatfrom.service;


import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserMessage;

import java.util.List;

public interface UserMessageService {

    //查找某人全部信息
    User findUserMessage(String userName);
    //查找所有用户全部信息
    List<User> findALLUserMessage();

    boolean setUserMessage(UserMessage userMessage);
    boolean setimg(int id, String adress);
    //插入个人信息
    void insertUserMessage(UserMessage userMessage);
}
