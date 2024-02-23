package com.example.jpa.domain.category;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);



    @Query("SELECT c FROM Category c WHERE LOWER(c.name) = LOWER(:categoryName)")
    Page<Category> findCategoriesByName(@Param("categoryName") String categoryName, Pageable pageable);



}
