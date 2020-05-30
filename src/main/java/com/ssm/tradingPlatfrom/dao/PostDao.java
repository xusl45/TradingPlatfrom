package com.ssm.tradingPlatfrom.dao;

import com.ssm.tradingPlatfrom.entity.Post;
import com.ssm.tradingPlatfrom.entity.PostSort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao {
    //返回所有帖子总类
    List<PostSort> findPostSort();

    //返回某个列别所有的帖子
    List<Post> findPostBySortID(int id);
    //发帖
    void insetPost(Post post);
    //帖子点赞
    void UpdatePostGood(Post post);
    //根据id查询帖子
    Post findPostByID(int id);

    //查找所有帖子
    List<Post> findALLPost();

    //展示帖子 停用
    void openPost(int id);
    //体制展示帖子 变为展示
    void stopPost(int id);

    //查看某个人的发帖情况
    List<Post> findPostByUid(int id);
}
