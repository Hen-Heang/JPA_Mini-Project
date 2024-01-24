package com.example.jpa.controller;

import com.example.jpa.payload.post.PostRequest;
import com.example.jpa.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/post/")
@RequiredArgsConstructor
public class PostController extends AbstractRestController{
    private final PostService postService;

    @PostMapping("create")
    public Object createPost(@RequestBody PostRequest postRequest){
        postService.createPost(postRequest);
        return ok();
    }

    @GetMapping("all")
    public Object getPosts(){
        return ok(postService.getPost());
    }

    @GetMapping("{id}")
    public Object getPostById(@PathVariable("id") Long id ){
        return ok(postService.getPostById(id));
    }

    @PutMapping("{id}")
    public Object updatePost(@PathVariable("id") Long id,  @RequestBody PostRequest postRequest){
        postService.updatePost(id,postRequest);

        return ok();
    }
}
