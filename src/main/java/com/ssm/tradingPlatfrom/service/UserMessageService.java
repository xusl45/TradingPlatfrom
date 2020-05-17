package com.ssm.tradingPlatfrom.service;


import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserAddress;
import com.ssm.tradingPlatfrom.entity.UserMessage;

import java.util.List;

public interface UserMessageService {

    //查找某人全部信息
    User findUserMessage(String userName);
    //查找管理员全部个人信息
    User findAdminMessage(String userName);
    //查找所有用户全部信息
    List<User> findALLUserMessage();
    //设置个人信息
    boolean setUserMessage(UserMessage userMessage);
    boolean setimg(int id, String adress);
    //插入个人信息
    void insertUserMessage(UserMessage userMessage);

    //查找某个用户的所有快递地址
    List<UserAddress> findALLUserAddress(int uid);
    //插入地址
    Boolean insertUserAddress(UserAddress userAddress);
    //删除地址
    Boolean deleteUserAddress(int id);
    //更新地址
    Boolean updateUserAddress(UserAddress userAddress);
    //查询某个id的用户地址
    UserAddress findUserAddressByID(int id);

}
