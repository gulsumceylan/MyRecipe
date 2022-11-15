package com.ceylan.myRecipesBook.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListDto {
    private int shoppingId;
    private String name;
    private String amount;
    private Integer userId;
}
