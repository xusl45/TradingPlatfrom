package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.Reply;
import com.ssm.tradingPlatfrom.entity.showEntity.ReplyReturn;
import com.ssm.tradingPlatfrom.service.ReplyService;
import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//帖子回帖控制层
@Controller
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @RequestMapping("/findReplyByTopicID")//得到所有评论通过帖子id
    @ResponseBody
    private ServerResponse findReplyByTopicID(String id) {
        List<ReplyReturn> replyReturns =  replyService.findReplyByTopicID(Integer.parseInt(id));
        if (replyReturns!= null) {
            return  ServerResponse.createBySuccess("全部回帖",replyReturns);
        }else {
            return  ServerResponse.createByError("获取全部回帖失败");
        }

    }

    @RequestMapping("/findALLReply")//得到所有评论通过帖子id
    @ResponseBody
    private ServerResponse findALLReply() {
        List<ReplyReturn> replyReturns =  replyService.findALLReply();
        if (replyReturns!= null) {
            return  ServerResponse.createBySuccess("全部回帖",replyReturns);
        }else {
            return  ServerResponse.createByError("获取全部回帖失败");
        }

    }

    @RequestMapping("/insertReply")//得到所有帖子分类列表
    @ResponseBody
    private ServerResponse insertReply(String uid, String toUid, String content, String topicID) {
        Reply reply = new Reply(content,Integer.parseInt(uid),Integer.parseInt(toUid),Integer.parseInt(topicID));
       Boolean replyReturns =  replyService.insertReply(reply);
        if (replyReturns!= null) {
            return  ServerResponse.createBySuccess("增加回帖",replyReturns);
        }else {
            return  ServerResponse.createByError("获取增加回帖失败");
        }

    }

}
