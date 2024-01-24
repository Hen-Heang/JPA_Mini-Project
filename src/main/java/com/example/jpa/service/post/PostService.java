package com.example.jpa.service.post;

import com.example.jpa.payload.post.PostRequest;

public interface PostService {

    void createPost(PostRequest postRequest);

    Object getPost();

    Object getPostById(Long id);

    void updatePost(Long id, PostRequest postRequest);
}
