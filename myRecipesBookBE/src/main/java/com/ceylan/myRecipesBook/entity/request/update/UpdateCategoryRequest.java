package com.ceylan.myRecipesBook.entity.request.update;


import lombok.Data;

@Data
public class UpdateCategoryRequest {

    private int id;
    private String name;
    private String imagePath;
}
