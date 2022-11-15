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
public class CreateShoppingListRequest {
    @JsonIgnore
    private int shoppingId;
    private String name;
    private String amount;
    private int userId;
}