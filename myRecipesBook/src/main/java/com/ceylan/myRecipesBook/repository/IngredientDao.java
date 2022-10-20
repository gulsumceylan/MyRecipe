package com.ceylan.myRecipesBook.repository;

import com.ceylan.myRecipesBook.entity.concrete.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> getByRecipe_RecipeId(int recipeId);
}
