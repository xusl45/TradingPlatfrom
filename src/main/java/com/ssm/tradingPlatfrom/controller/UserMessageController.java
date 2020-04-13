package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserMessage;
import com.ssm.tradingPlatfrom.service.UserMessageService;
import com.ssm.tradingPlatfrom.service.UserService;
import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    private ServerResponse setUserMessage(String uid,String email,String sex,String img,String introduce ,String nickName,String age) {
        UserMessage userMessage = new UserMessage(Integer.parseInt(uid),email,nickName,sex,img,introduce,age);
        boolean user = userMessageService.setUserMessage(userMessage);
        if (user) {
            return  ServerResponse.createBySuccess("用户全部个人信息",user);
        }else {
            return  ServerResponse.createByError("获取用户全部个人信息失败");
        }

    }

}
