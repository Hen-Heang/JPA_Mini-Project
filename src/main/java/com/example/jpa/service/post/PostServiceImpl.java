package com.example.jpa.service.post;

import com.example.jpa.domain.post.PostRepository;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.payload.post.PostMainRes;
import com.example.jpa.payload.post.PostRequest;
import com.example.jpa.payload.post.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Override
    public void createPost(PostRequest postRequest) {
        var post = postMapper.mapPostToEntity(postRequest);
        postRepository.save(post);

    }

    @Override
    public Object getPost() {
        var postResponses = postRepository.findAll();
        List<PostResponse> postResponseList = postResponses.stream()
                .map(postMapper::mapPostResponse).toList();
        return new PostMainRes(postResponseList);
    }

    @Override
    public Object getPostById(Long id) {
        return postRepository.findById(id)
                .map(postMapper::mapPostResponse)
                .orElseThrow(() -> new CusNotFoundException("Post Not Found!"));

    }

    @Override
    public void updatePost(Long id, PostRequest postRequest) {

    }
}
