package com.example.jpa.domain.article;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Long> {

    @EntityGraph(attributePaths = {"categories"})
    @Override
    List<Article> findAll();
}
