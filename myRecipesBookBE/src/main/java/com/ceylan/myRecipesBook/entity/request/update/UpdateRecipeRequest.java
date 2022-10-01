package com.ceylan.myRecipesBook.entity.request.update;

import com.ceylan.myRecipesBook.entity.dto.IngredientDto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateRecipeRequest {

    private int id;
    private String name;
    private String size;
    private String description;
    private int categoryId;
    private List<IngredientDto> ingredientDtoList;
}
