package com.ssm.tradingPlatfrom.service;

import com.ssm.tradingPlatfrom.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User login(String username, String password);


    Boolean applyUser(String userName, String password);

    User adminLogin(String userName, String password);

    Boolean changePassword(String id, String password);

    Boolean stopAccount(int id);

    Boolean openAccount(int id);
}