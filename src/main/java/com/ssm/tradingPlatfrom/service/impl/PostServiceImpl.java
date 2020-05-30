package com.ssm.tradingPlatfrom.service.impl;


import com.ssm.tradingPlatfrom.dao.PostDao;
import com.ssm.tradingPlatfrom.entity.Post;
import com.ssm.tradingPlatfrom.entity.PostSort;
import com.ssm.tradingPlatfrom.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<PostSort> findPostSort() {
        List<PostSort> postSorts = postDao.findPostSort();
        return postSorts;
    }

    @Override
    public List<Post> findPostBySortID(int id) {
        List<Post> posts =postDao.findPostBySortID(id);
        return posts;
    }

    @Override
    public Boolean insertPost(Post post) {
        postDao.insetPost(post);
        return true;
    }

    @Override
    public Boolean UpdatePostGood(int id) {
        Post post = postDao.findPostByID(id);
        Post post1 = new Post(id,post.getNice()+1,post.getReplyNum());
        postDao.UpdatePostGood(post1);
        return true;
    }

    @Override
    public Post findPostByID(int parseInt) {
        Post post =postDao.findPostByID(parseInt);
        return post;
    }

    @Override
    public List<Post> findALLPost() {
        List<Post> posts =postDao.findALLPost();
        return posts;
    }

    @Override
    public Boolean stopPost(int id) {
        postDao.stopPost(id);
        return true;
    }

    @Override
    public Boolean openPost(int id) {
        postDao.openPost(id);
        return true;
    }

    @Override
    public List<Post> findPostByUid(int id) {
        List<Post> posts =postDao.findPostByUid(id);
        return posts;
    }
}
