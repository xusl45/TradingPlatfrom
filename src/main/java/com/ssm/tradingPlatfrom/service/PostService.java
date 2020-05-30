package com.ssm.tradingPlatfrom.service;

import com.ssm.tradingPlatfrom.entity.Post;
import com.ssm.tradingPlatfrom.entity.PostSort;

import java.util.List;

public interface PostService {
    List<PostSort> findPostSort();

    List<Post> findPostBySortID(int id);

    Boolean insertPost(Post post);

    Boolean UpdatePostGood(int id);

    Post findPostByID(int parseInt);

    List<Post> findALLPost();

    Boolean stopPost(int id);

    Boolean openPost(int id);

    List<Post> findPostByUid(int id);
}
