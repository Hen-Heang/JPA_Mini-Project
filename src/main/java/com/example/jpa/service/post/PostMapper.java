package com.example.jpa.service.post;

import com.example.jpa.domain.post.Post;
import com.example.jpa.domain.post.PostRepository;
import com.example.jpa.payload.post.PostRequest;
import com.example.jpa.payload.post.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostMapper(PostRepository postRepository) {
    }

    public Post mapPostToEntity(PostRequest postRequest) {
        return Post.builder()
                .title(postRequest.title())
                .description(postRequest.description())
                .build();
    }

    public PostResponse mapPostResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .build();
    }

}
