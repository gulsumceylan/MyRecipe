package com.ceylan.myRecipesBook.entity.request.update;

import lombok.Data;

@Data
public class UpdateShoppingListRequest {
    private int shoppingId;
    private String name;
    private String amount;
    private int userId;
}
