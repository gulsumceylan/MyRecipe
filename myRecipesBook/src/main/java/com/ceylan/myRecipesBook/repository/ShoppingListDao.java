package com.ceylan.myRecipesBook.repository;

import com.ceylan.myRecipesBook.entity.concrete.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListDao extends JpaRepository<ShoppingList, Integer> {
    List<ShoppingList> getByUser_UserId(int userId);
}