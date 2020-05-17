package com.ssm.tradingPlatfrom.dao;

import com.ssm.tradingPlatfrom.entity.Reply;
import com.ssm.tradingPlatfrom.entity.showEntity.ReplyReturn;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {
    //查找所有回帖
    List<ReplyReturn> findReplyByTopicID(int id);
//插入回帖
    void insertReply(Reply reply);
    //查找所有回帖内容
    List<ReplyReturn> findALLReply();
}
