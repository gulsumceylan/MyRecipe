package com.ceylan.myRecipesBook.repository;

import com.ceylan.myRecipesBook.entity.concrete.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeDao extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByUserId(int userId);

    List<Recipe> getByCategory_Id(int categoryId);
}
