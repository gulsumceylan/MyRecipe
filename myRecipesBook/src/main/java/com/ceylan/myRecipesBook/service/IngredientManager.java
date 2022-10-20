package com.ceylan.myRecipesBook.service;

import com.ceylan.myRecipesBook.entity.concrete.Ingredient;
import com.ceylan.myRecipesBook.entity.concrete.Recipe;
import com.ceylan.myRecipesBook.entity.dto.IngredientDto;
import com.ceylan.myRecipesBook.entity.request.create.CreateIngredientRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteIngredientRequest;
import com.ceylan.myRecipesBook.entity.request.update.UpdateIngredientRequest;
import com.ceylan.myRecipesBook.repository.IngredientDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientManager {

    private IngredientDao ingredientDao;
    private ModelMapper modelMapper;

    public IngredientManager(IngredientDao ingredientDao, ModelMapper modelMapper) {
        this.ingredientDao = ingredientDao;
        this.modelMapper = modelMapper;
    }

    public List<IngredientDto> getIngredients() {
        List<Ingredient> ingredients = this.ingredientDao.findAll();
        List<IngredientDto> ingredientDtos = ingredients.stream().map(ingredient -> modelMapper.map(ingredient, IngredientDto.class)).collect(Collectors.toList());

        return ingredientDtos;
    }

    public List<IngredientDto> getIngredientById(int id) {
        List<Ingredient> ingredients = (List<Ingredient>) this.ingredientDao.getById(id);
        List<IngredientDto> ingredientDtos = ingredients.stream().map(ingredient -> modelMapper.map(ingredient, IngredientDto.class)).collect(Collectors.toList());

        return ingredientDtos;
    }

    public List<IngredientDto> getIngredientsByRecipeId(int recipeId) {
        List<Ingredient> ingredients = this.ingredientDao.getByRecipe_RecipeId(recipeId);
        List<IngredientDto> ingredientDtos = ingredients.stream().map(ingredient -> modelMapper.map(ingredient, IngredientDto.class)).collect(Collectors.toList());

        return ingredientDtos;
    }

    public Ingredient createIngredient(CreateIngredientRequest createIngredientRequest) {
        Ingredient ingredient = modelMapper.map(createIngredientRequest, Ingredient.class);
        this.ingredientDao.save(ingredient);
        return ingredient;
    }

    public Ingredient deleteIngredient(DeleteIngredientRequest deleteIngredientRequest) {
        Ingredient ingredient = modelMapper.map(deleteIngredientRequest, Ingredient.class);
        this.ingredientDao.delete(ingredient);
        return ingredient;
    }

    public Ingredient updateRecipe(UpdateIngredientRequest updateIngredientRequest) {
        Recipe recipe = modelMapper.map(updateIngredientRequest, Recipe.class);

        Ingredient ingredient = modelMapper.map(updateIngredientRequest, Ingredient.class);
        ingredient.setRecipe(recipe);
        this.ingredientDao.save(ingredient);
        return ingredient;
    }
}
