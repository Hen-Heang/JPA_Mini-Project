//package com.example.jpa.domain.article;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//import java.util.Optional;
//
//
//public interface ArticleRepository extends JpaRepository<Article, Long> {
//
//    @EntityGraph(attributePaths = {"categories"})
//    Optional<Article> findById(Long id);
//
//    @Query("SELECT a FROM Article a WHERE LOWER(a.title) = LOWER(:articleName)")
//    Optional<Article>findByTitle(@Param("articleName")String string);
//    @Override
//    List<Article> findAll();
//
//    Page<Article>findArticleByPublished(Pageable pageable, boolean isPublished );
//}
