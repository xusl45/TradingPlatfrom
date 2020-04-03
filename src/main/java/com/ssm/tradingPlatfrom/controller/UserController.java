package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.service.UserService;
import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/GetAll")
    @ResponseBody
    private ServerResponse getAllUser() {
        List<User> user =  userService.getAllUser();
//        Map<String, Object> map = ReturnMap.ReturnMapS(user);
        return ServerResponse.createBySuccess("查询成功",user);
    }

    @RequestMapping("/login")
    @ResponseBody
    private ServerResponse login(String userName,String password) {
        System.out.println(userName+ password+"许舒隆");
        User user= userService.login(userName ,password);
        if (user != null) {
            return  ServerResponse.createBySuccess("登录成功",user);
        }else {
            return  ServerResponse.createByError("登录失败");
        }
    }

    @RequestMapping("/apply")
    @ResponseBody
    private ServerResponse apply(String userName,String password) {
        Boolean apply = userService.applyUser(userName,password);
        if (apply) {
            return  ServerResponse.createBySuccess("注册成功",apply);
        }else {
            return  ServerResponse.createByError("注册失败");
        }
    }


}
