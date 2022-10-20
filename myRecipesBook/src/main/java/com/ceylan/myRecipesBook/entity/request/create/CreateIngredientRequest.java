package com.ceylan.myRecipesBook.entity.request.create;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateIngredientRequest {
    @JsonIgnore
    private int ingredientId;
    private String name;
    private String measurement;
    private int recipeId;
}
