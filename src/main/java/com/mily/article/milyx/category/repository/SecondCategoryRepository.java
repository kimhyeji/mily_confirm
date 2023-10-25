package com.mily.article.milyx.category.repository;

import com.mily.article.milyx.category.entity.SecondCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SecondCategoryRepository extends JpaRepository<SecondCategory, Integer> {
    Optional<SecondCategory> findByTitle(String title);

    @Query(value = "SELECT * FROM `second_category` WHERE first_category_id = :firstCategoryId", nativeQuery = true)
    List<SecondCategory> findByFirstCategoryId(@Param("firstCategoryId") int firstCategoryId);

}