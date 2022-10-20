package com.ceylan.myRecipesBook.entity.request.update;

import lombok.Data;

@Data
public class UpdateIngredientRequest {

    private int ingredientId;
    private String name;
    private String measurement;
}
