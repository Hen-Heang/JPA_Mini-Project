package com.example.jpa.controller;

import com.example.jpa.payload.article.ArticleRequest;
import com.example.jpa.payload.comment.CommentRequest;
import com.example.jpa.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/article")
@RequiredArgsConstructor
public class ArticleController extends AbstractRestController {
private final ArticleService articleService;
    @PostMapping("/add")
    public ResponseEntity<?> createArticle(@RequestBody ArticleRequest articleRequest){
        articleService.createArticle(articleRequest);
        return ok();
        }
    @GetMapping("/all")
    public Object getAllArticle(
            @RequestParam(name = "page_number", defaultValue = "0", required = false)Integer pageNumber,
            @RequestParam(name = "page_size", defaultValue = "10", required = false)Integer sizeNumber) {
        Pageable pageable = PageRequest.of(pageNumber,sizeNumber);
        return ok(articleService.getAllArticle(pageable));
    }

    @GetMapping("/{id}")
    public Object getArticleById(@PathVariable("id") Long id){
        return ok(articleService.getArticleById(id));
}


@GetMapping("/title/{title}")
    public Object getArticleByTitle(@PathVariable String title){
        return ok(articleService.getArticleByTitle(title));
}

@PutMapping("/{id}")
    public Object updateArticle(@PathVariable("id")Long id, @RequestBody ArticleRequest articleRequest ){
        articleService.updateArticle(id,articleRequest);
        return ok();
}

@DeleteMapping("/{id}")
    public Object deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
        return ok();
}

@PostMapping("/comment")
    public Object postComment(@RequestBody CommentRequest commentRequest){
    articleService.postComment(commentRequest);
        return ok();
}

@GetMapping("/comment/{id}")
    public Object getCommentByArticleById(@PathVariable("id") Long articleId){
        return ok(articleService.getCommentByArticleId(articleId));
}

@GetMapping("/isPublished")
    public Object getArticleIsPublished(
       @RequestParam(name = "page_number", defaultValue = "0", required = false)Integer pageNumber,
       @RequestParam(name = "page_size", defaultValue = "10", required = false)Integer sizeNumber
){
        Pageable pageable = PageRequest.of(pageNumber,sizeNumber);
        return ok(articleService.getArticleIsPublished(pageable));
}
}
