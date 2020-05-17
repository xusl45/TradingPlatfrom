package com.ssm.tradingPlatfrom.service;

import com.ssm.tradingPlatfrom.entity.Reply;
import com.ssm.tradingPlatfrom.entity.showEntity.ReplyReturn;

import java.util.List;

public interface ReplyService {
    List<ReplyReturn> findReplyByTopicID(int id);

    Boolean insertReply(Reply reply);

    List<ReplyReturn> findALLReply();
}
