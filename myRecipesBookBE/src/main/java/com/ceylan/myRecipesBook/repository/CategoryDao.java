package com.ceylan.myRecipesBook.repository;

import com.ceylan.myRecipesBook.entity.concrete.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
