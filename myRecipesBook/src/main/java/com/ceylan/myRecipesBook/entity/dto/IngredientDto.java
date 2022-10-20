package com.ceylan.myRecipesBook.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {

    private int ingredientId;
    private String name;
    private String measurement;
}
