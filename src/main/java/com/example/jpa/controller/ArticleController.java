package com.example.jpa.controller;

import com.example.jpa.payload.article.ArticleRequest;
import com.example.jpa.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/article/")
@RequiredArgsConstructor
public class ArticleController extends AbstractRestController {
private final ArticleService articleService;
        @PostMapping("add")
    public ResponseEntity<?> createArticle(@RequestBody ArticleRequest articleRequest){
        articleService.createArticle(articleRequest);
        return ok();
        }

}
