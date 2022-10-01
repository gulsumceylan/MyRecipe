package com.ceylan.myRecipesBook.controller;

import com.ceylan.myRecipesBook.entity.concrete.Recipe;
import com.ceylan.myRecipesBook.entity.dto.RecipeDto;
import com.ceylan.myRecipesBook.entity.request.create.CreateRecipeRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteRecipeRequest;
import com.ceylan.myRecipesBook.entity.request.update.UpdateRecipeRequest;
import com.ceylan.myRecipesBook.service.RecipeManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeManager recipeManager;

    public RecipeController(RecipeManager recipeManager) {
        this.recipeManager = recipeManager;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RecipeDto>> getRecipes() {
        return new ResponseEntity<>(recipeManager.getRecipes(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<RecipeDto> getById(int id) {
        return new ResponseEntity(this.recipeManager.getRecipeById(id), HttpStatus.OK);
    }

    @GetMapping("/getRecipesByUserId")
    public ResponseEntity<List<RecipeDto>> getRecipesByUserId(int userId) {
        return new ResponseEntity<>(recipeManager.getRecipesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/getRecipesByCategoryId")
    public ResponseEntity<List<RecipeDto>> getRecipesByCategoryId(int categoryId) {
        return new ResponseEntity<>(recipeManager.getRecipesByCategoryId(categoryId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> createRecipe(@RequestBody CreateRecipeRequest createRecipeRequest) {
        return new ResponseEntity<>(recipeManager.createRecipe(createRecipeRequest), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody UpdateRecipeRequest request) {
        return new ResponseEntity(this.recipeManager.updateRecipe(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody DeleteRecipeRequest request) {
        return new ResponseEntity(this.recipeManager.deleteRecice(request), HttpStatus.OK);
    }
}

