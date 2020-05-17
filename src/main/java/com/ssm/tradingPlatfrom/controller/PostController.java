package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.Post;
import com.ssm.tradingPlatfrom.entity.PostSort;
import com.ssm.tradingPlatfrom.service.PostService;
import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//帖子发帖控制层
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/findPostSort")//得到所有帖子分类列表
    @ResponseBody
    private ServerResponse findPostSort() {
        List<PostSort> postSorts =  postService.findPostSort();
        if (postSorts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",postSorts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }

    @RequestMapping("/UpdatePostGood")//帖子中点赞
    @ResponseBody
    private ServerResponse UpdatePostGood(String id) {
        Boolean postSorts =  postService.UpdatePostGood(Integer.parseInt(id));
        if (postSorts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",postSorts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }
    @RequestMapping("/findPostByID")//得到帖子的所有信息
    @ResponseBody
    private ServerResponse findPostByID(String id) {
        Post  posts =  postService.findPostByID(Integer.parseInt(id));
        if (posts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",posts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }


    @RequestMapping("/findPostBySortID")//得到所有帖子分类列表
    @ResponseBody
    private ServerResponse findPostBySortID(String id) {
        List<Post> posts =  postService.findPostBySortID(Integer.parseInt(id));
        if (posts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",posts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }

    @RequestMapping("/findALLPost")//得到所有帖子分类列表
    @ResponseBody
    private ServerResponse findALLPost() {
        List<Post> posts =  postService.findALLPost();
        if (posts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",posts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }


    @RequestMapping("/insertPost")//发布帖子
    @ResponseBody
    private ServerResponse insertPost(String uid, String commodityID, String sortID, String title, String content, String mainImages) {
        Post post;

        if (mainImages.equals("noimages")==true&&commodityID.equals("nocommodity")==true){
            post = new Post(Integer.parseInt(uid),Integer.parseInt(sortID),title,content);
        }else if (commodityID.equals("nocommodity")==true) {
            post = new Post(Integer.parseInt(uid),Integer.parseInt(sortID),title,content,mainImages);
        }else if (mainImages.equals("noimages")==true) {
            post = new Post(Integer.parseInt(uid),Integer.parseInt(commodityID),Integer.parseInt(sortID),title,content);
        }else {
            post = new Post(Integer.parseInt(uid),Integer.parseInt(commodityID),Integer.parseInt(sortID),title,content,mainImages);
        }
        Boolean posts = postService.insertPost(post);
        if (posts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",posts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }
    }


}
