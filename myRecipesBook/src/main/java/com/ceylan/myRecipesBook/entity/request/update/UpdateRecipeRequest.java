package com.ceylan.myRecipesBook.entity.request.update;

import lombok.Data;

@Data
public class UpdateRecipeRequest {

    private int recipeId;
    private String name;
    private Integer categoryId;
    private String description;
    private String imagePath;
    private Integer userId;
}
