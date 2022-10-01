package com.ceylan.myRecipesBook.repository;

import com.ceylan.myRecipesBook.entity.concrete.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient, Integer> {
}
