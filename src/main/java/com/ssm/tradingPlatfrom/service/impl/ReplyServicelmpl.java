package com.ssm.tradingPlatfrom.service.impl;

import com.ssm.tradingPlatfrom.dao.PostDao;
import com.ssm.tradingPlatfrom.dao.ReplyDao;
import com.ssm.tradingPlatfrom.entity.Post;
import com.ssm.tradingPlatfrom.entity.Reply;
import com.ssm.tradingPlatfrom.entity.showEntity.ReplyReturn;
import com.ssm.tradingPlatfrom.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "replyService")
public class ReplyServicelmpl  implements ReplyService {


    @Autowired
    private PostDao postDao;
    @Autowired
    private ReplyDao replyDao;


    @Override
    public List<ReplyReturn> findReplyByTopicID(int id) {
        List<ReplyReturn> replyReturns =  replyDao.findReplyByTopicID(id);
        return replyReturns;

    }

    @Override
    public Boolean insertReply(Reply reply) {
        replyDao.insertReply(reply);
        Post post = postDao.findPostByID(reply.getTopicID());
        Post post1 = new Post(reply.getTopicID(),post.getNice(),post.getReplyNum()+1);
        postDao.UpdatePostGood(post1);
        return true;
    }

    @Override
    public List<ReplyReturn> findALLReply() {
        List<ReplyReturn> replyReturns =  replyDao.findALLReply();
        return replyReturns;
    }
}
