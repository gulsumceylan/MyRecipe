package com.ceylan.myRecipesBook.controller;

import com.ceylan.myRecipesBook.entity.concrete.Ingredient;
import com.ceylan.myRecipesBook.entity.dto.IngredientDto;
import com.ceylan.myRecipesBook.entity.request.create.CreateIngredientRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteIngredientRequest;
import com.ceylan.myRecipesBook.entity.request.update.UpdateIngredientRequest;
import com.ceylan.myRecipesBook.service.IngredientManager;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private IngredientManager ingredientManager;

    public IngredientController(IngredientManager ingredientManager) {
        this.ingredientManager = ingredientManager;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<IngredientDto>> getRecipes() {
        return new ResponseEntity<>(ingredientManager.getIngredients(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<List<IngredientDto>> getIngredientById(int id) {
        return new ResponseEntity<>(ingredientManager.getIngredientById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody CreateIngredientRequest createIngredientRequest) {
        return new ResponseEntity<>(ingredientManager.createIngredient(createIngredientRequest), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@Valid @RequestBody UpdateIngredientRequest request) {
        Ingredient ingredient = this.ingredientManager.updateRecipe(request);

        Gson gson = new Gson();
        String jsonResp = gson.toJson(ingredient);

        return ResponseEntity.ok(jsonResp);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody DeleteIngredientRequest request) {
        return new ResponseEntity(this.ingredientManager.deleteIngredient(request), HttpStatus.OK);
    }

}
