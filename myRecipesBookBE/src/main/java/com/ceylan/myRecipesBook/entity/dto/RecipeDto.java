package com.ceylan.myRecipesBook.entity.dto;

import com.ceylan.myRecipesBook.entity.concrete.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private String name;
    private String description;
    private Category category;
    private String userName;
}
