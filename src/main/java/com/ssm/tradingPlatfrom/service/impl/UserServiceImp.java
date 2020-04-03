package com.ssm.tradingPlatfrom.service.impl;

import com.ssm.tradingPlatfrom.dao.UserDao;
import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserMessage;

import com.ssm.tradingPlatfrom.service.UserMessageService;
import com.ssm.tradingPlatfrom.service.UserService;
import com.ssm.tradingPlatfrom.utils.Md5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserMessageService userMessageService;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User  login(String username, String password) {
        User loginUser = userDao.loginUser(username);
//        System.out.println(loginuser.toString());
        if (loginUser == null) {
            return null;
        } else {
            if (Md5.JM(loginUser.getPassword()).equals(password)) {
                loginUser.setPassword("");
                return loginUser;
            } else {
                return null;
            }
        }
    }

    @Override
    public Boolean applyUser(String userName, String password) {
        String psw = Md5.KL(password);
        User user = userDao.loginUser(userName);
        if (user!=null)
        {
            return false;
        }else {
            User applyuser = new User();
            applyuser.setPassword(psw);
            applyuser.setUsername(userName);
            userDao.insertUser(applyuser);

            //设置个人信息
            User users = userDao.loginUser(userName);
            String nickName = "第"+users.getId()+"位用户";
            UserMessage userMessage = new UserMessage(users.getId(),null,nickName,"男","这个人很懒，啥也没留下","0","0",null,null,null);
            userMessageService.insertUserMessage(userMessage);

            return true;
        }
    }
}
