package com.ceylan.myRecipesBook.entity.request.update;


import lombok.Data;

@Data
public class UpdateCategoryRequest {

    private int categoryId;
    private String name;
    private String imagePath;
}
