package com.ssm.tradingPlatfrom.dao;

import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserAddress;
import com.ssm.tradingPlatfrom.entity.UserMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //取所有用户
    List<User> getAllUser();
    //用户登录
    User loginUser(String username);
    //管理员登陆
    User adminLogin(String username);
    //注册账户
    void insertUser(User applyuser);


// //用户信息
    //查找个用户的信息
    User findUserMessage(String username);
    //查找个用户的信息
    User findAdminMessage(String username);
    User findUserMessageByID(int id);
//查找所有用户的信息
    List<User> findALLUserMessage();
    //插入用户信息
    void insertUserMessage(UserMessage userMessage);
    //更新余额
    void updateRemainingSum(UserMessage userMessage);
    //更新用户个人信息
    void setUserMessage(UserMessage userMessage);

//收货地址
    //查找用户所有地址
    List<UserAddress> findALLUserAddress(int uid);
    //插入用户地址
    void insertUserAddress(UserAddress userAddress);

    //删除用户地址（假删除）
    void deleteUserAddress(int id);
    //更新用户地址信息
    void updateUserAddress(UserAddress userAddress);
    //查找id下的用户收货地址
    UserAddress findUserAddressByID(int id);

}
