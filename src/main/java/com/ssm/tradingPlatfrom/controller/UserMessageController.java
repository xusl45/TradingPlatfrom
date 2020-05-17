package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserAddress;
import com.ssm.tradingPlatfrom.entity.UserMessage;
import com.ssm.tradingPlatfrom.service.UserMessageService;
import com.ssm.tradingPlatfrom.service.UserService;
import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserMessageController {

    @Autowired
    private UserMessageService userMessageService;
    @Autowired
    private UserService userService;


    @RequestMapping("/findUserMessage")//得到用户所有个人信息
    @ResponseBody
    private ServerResponse findUserMessage(String userName) {
        User user = userMessageService.findUserMessage(userName);
        if (user!= null) {
            return  ServerResponse.createBySuccess("用户全部个人信息",user);
        }else {
            return  ServerResponse.createByError("获取用户全部个人信息失败");
        }

    }
    @RequestMapping("/findAdminMessage")//得到管理员所有个人信息
    @ResponseBody
    private ServerResponse findAdminMessage(String userName) {
        User user = userMessageService.findAdminMessage(userName);
        if (user!= null) {
            return  ServerResponse.createBySuccess("用户全部个人信息",user);
        }else {
            return  ServerResponse.createByError("获取用户全部个人信息失败");
        }

    }
    @RequestMapping("/findALLUserMessage")//得到所有用户的个人信息
    @ResponseBody
    private ServerResponse findALLUserMessage() {
        List<User> users = userMessageService.findALLUserMessage();
        for (User user: users
             ) {
            System.out.println(user.getUserMessages().toString());
        }
        if (users!= null) {
            return  ServerResponse.createBySuccess("所有用户全部个人信息",users);
        }else {
            return  ServerResponse.createByError("获取所有用户全部个人信息失败");
        }

    }


    @RequestMapping("/setUserMessage")//修改用户个人信息
    @ResponseBody
    private ServerResponse setUserMessage(String uid, String email, String sex, String img, String introduce , String nickName, String age) {
        UserMessage userMessage = new UserMessage(Integer.parseInt(uid),email,nickName,sex,introduce,img,age);
        boolean user = userMessageService.setUserMessage(userMessage);
        if (user) {
            return  ServerResponse.createBySuccess("用户全部个人信息",user);
        }else {
            return  ServerResponse.createByError("获取用户全部个人信息失败");
        }

    }

    @RequestMapping("/findALLUserAddress")//得到用户的所有地址
    @ResponseBody
    private ServerResponse findALLUserAddress(int uid) {
        List<UserAddress> userAddresses = userMessageService.findALLUserAddress(uid);
        if (userAddresses != null) {
            return  ServerResponse.createBySuccess("用户全部个人地址",userAddresses);
        }else {
            return  ServerResponse.createByError("获取用户全部个人地址失败");
        }

    }


    @RequestMapping("/insertUserAddress")//插入用户地址
    @ResponseBody
    private ServerResponse insertUserAddress(int uid, String phone , String address, String zipCode, String name) {
        UserAddress userAddress =  new UserAddress(uid,name,phone,zipCode,address);
        Boolean userAddresses = userMessageService.insertUserAddress(userAddress);
        if (userAddresses != null) {
            return  ServerResponse.createBySuccess("增加用户个人地址",userAddresses);
        }else {
            return  ServerResponse.createByError("增加用户个人地址失败");
        }

    }

    @RequestMapping("/updateUserAddress")//更新用户收货地址
    @ResponseBody
    private ServerResponse updateUserAddress(int id, int uid, String phone , String address, String zipCode, String name) {
        UserAddress userAddress =  new UserAddress(id,uid,name,phone,zipCode,address);
        Boolean userAddresses = userMessageService.updateUserAddress(userAddress);
        if (userAddresses != null) {
            return  ServerResponse.createBySuccess("增加用户个人地址",userAddresses);
        }else {
            return  ServerResponse.createByError("增加用户个人地址失败");
        }

    }

    @RequestMapping("/deleteUserAddress")//删除用户地址
    @ResponseBody
    private ServerResponse deleteUserAddress(int id) {
        Boolean userAddresses = userMessageService.deleteUserAddress(id);
        if (userAddresses != null) {
            return  ServerResponse.createBySuccess("增加用户个人地址",userAddresses);
        }else {
            return  ServerResponse.createByError("增加用户个人地址失败");
        }

    }

    @RequestMapping("/findUserAddressByID")//通过id查询用户地址
    @ResponseBody
    private ServerResponse findUserAddressByID(String id) {
        UserAddress userAddresses = userMessageService.findUserAddressByID(Integer.parseInt(id));
        if (userAddresses != null) {
            return  ServerResponse.createBySuccess("通过id查询用户个人地址",userAddresses);
        }else {
            return  ServerResponse.createByError("通过id查询用户个人地址失败");
        }

    }



}
