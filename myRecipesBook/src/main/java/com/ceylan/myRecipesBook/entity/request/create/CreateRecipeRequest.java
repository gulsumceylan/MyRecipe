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
public class CreateRecipeRequest {
    @JsonIgnore
    private int recipeId;
    private String name;
    private int categoryId;
    private String description;
    private String imagePath;
    private int userId;
}
