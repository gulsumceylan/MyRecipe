package com.ceylan.myRecipesBook.service;

import com.ceylan.myRecipesBook.entity.concrete.Category;
import com.ceylan.myRecipesBook.entity.concrete.Recipe;
import com.ceylan.myRecipesBook.entity.concrete.User;
import com.ceylan.myRecipesBook.entity.dto.RecipeDto;
import com.ceylan.myRecipesBook.entity.request.create.CreateRecipeRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteRecipeRequest;
import com.ceylan.myRecipesBook.entity.request.update.UpdateRecipeRequest;
import com.ceylan.myRecipesBook.repository.RecipeDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeManager {

    private final RecipeDao recipeDao;
    private ModelMapper modelMapper;

    public RecipeManager(RecipeDao recipeDao, ModelMapper modelMapper) {
        this.recipeDao = recipeDao;
        this.modelMapper = modelMapper;
    }

    public List<RecipeDto> getRecipes() {
        List<Recipe> recipes = this.recipeDao.findAll();
        List<RecipeDto> recipeDtos = recipes.stream().map(recipe -> modelMapper.map(recipe, RecipeDto.class)).collect(Collectors.toList());

        return recipeDtos;
    }

    public RecipeDto getRecipeById(int id) {
        Recipe recipe = this.recipeDao.getById(id);
        RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);

        return recipeDto;
    }

    public List<RecipeDto> getRecipesByUserId(int userId) {
        List<Recipe> recipes = this.recipeDao.getByUser_UserId(userId);
        List<RecipeDto> recipeDtos = recipes.stream().map(recipe -> modelMapper.map(recipe, RecipeDto.class)).collect(Collectors.toList());

        return recipeDtos;
    }

    public List<RecipeDto> getRecipesByCategoryId(int categoryId) {
        List<Recipe> recipes = this.recipeDao.getByCategory_CategoryId(categoryId);
        List<RecipeDto> recipeDtos = recipes.stream().map(recipe -> modelMapper.map(recipe, RecipeDto.class)).collect(Collectors.toList());

        return recipeDtos;
    }

    public Recipe createRecipe(CreateRecipeRequest createRecipeRequest) {
        Recipe recipe = modelMapper.map(createRecipeRequest, Recipe.class);
        this.recipeDao.save(recipe);
        return recipe;
    }

    public Recipe deleteRecice(DeleteRecipeRequest deleteRecipeRequest) {
        Recipe recipe = modelMapper.map(deleteRecipeRequest, Recipe.class);
        this.recipeDao.delete(recipe);
        return recipe;
    }

    public Recipe updateRecipe(UpdateRecipeRequest updateRecipeRequest) {
        Category category = modelMapper.map(updateRecipeRequest, Category.class);
        User user = modelMapper.map(updateRecipeRequest, User.class);
        Recipe recipe = modelMapper.map(updateRecipeRequest, Recipe.class);
        recipe.setCategory(category);
        recipe.setUser(user);
        this.recipeDao.save(recipe);
        return recipe;
    }
}
