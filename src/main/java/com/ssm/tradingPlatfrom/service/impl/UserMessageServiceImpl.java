package com.ssm.tradingPlatfrom.service.impl;


import com.ssm.tradingPlatfrom.dao.UserDao;
import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserMessage;
import com.ssm.tradingPlatfrom.service.UserMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userMessageService")
public class UserMessageServiceImpl implements UserMessageService {

    @Resource
    private UserDao userDao;

    @Override
    public User findUserMessage(String userName) {
        User user = userDao.findUserMessage(userName);
        return user;
    }

    @Override
    public List<User> findALLUserMessage() {
        List<User> users = userDao.findALLUserMessage();
        return users;
    }

    @Override
    public boolean setUserMessage(UserMessage userMessage) {
//        User user = userDao.findUserMessage(userMessage.getId());
//        if (user==null)
//        {
//            userDao.insertUserMessage(userMessage);
//        }else {
//
//            userDao.updataUserMessage(userMessage);
//        }
//
//        return true;
        return  false;
    }


    @Override
    public boolean setimg(int id, String adress) {
//        User user = userDao.findUserMessage(id);
//        if (user != null) {
//            UserMessage userMessage = new UserMessage();
//            userMessage.setId(id);
//            userMessage.setImg(adress);
//            userDao.setimg(userMessage);
//            return true;
//        }else {
//            return false;
//        }

        return  false;
    }

    @Override
    public void insertUserMessage(UserMessage userMessage) {
        userDao.insertUserMessage(userMessage);
    }
}
