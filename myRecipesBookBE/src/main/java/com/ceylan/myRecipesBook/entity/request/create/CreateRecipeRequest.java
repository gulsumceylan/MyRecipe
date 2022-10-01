package com.ceylan.myRecipesBook.entity.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRecipeRequest {

    private String name;
    private int categoryId;
    private String description;
    private String imagePath;
    private int userId;
}
