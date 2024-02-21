package com.example.jpa.domain.article;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends JpaRepository<Article, Long> {

    @EntityGraph(attributePaths = {"categories"})
    Optional<Article> findById(Long id);
    Optional<Article>findByTitle(String string);
    @Override
    List<Article> findAll();
}
