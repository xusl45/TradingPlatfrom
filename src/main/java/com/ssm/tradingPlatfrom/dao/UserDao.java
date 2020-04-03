package com.ssm.tradingPlatfrom.dao;

import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //取所有用户
    public List<User> getAllUser();
    //用户登录
    User loginUser(String username);
    //管理员登陆
    User loginadmin(String username);
    //注册账户
    void insertUser(User applyuser);


// //用户信息
    //查找个用户的信息
    User findUserMessage(String username);
//查找所有用户的信息
    List<User> findALLUserMessage();
//
//    //设置头像
//    void setimg(UserMessage userMessage);
    //插入用户信息
    void insertUserMessage(UserMessage userMessage);

//    //更新用户信息
//    void updataUserMessage(UserMessage userMessage);
}
