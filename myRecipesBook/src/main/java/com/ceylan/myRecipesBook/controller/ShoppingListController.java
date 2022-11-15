package com.ceylan.myRecipesBook.controller;

import com.ceylan.myRecipesBook.entity.concrete.ShoppingList;
import com.ceylan.myRecipesBook.entity.dto.ShoppingListDto;
import com.ceylan.myRecipesBook.entity.request.create.CreateShoppingListRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteShoppingListRequest;
import com.ceylan.myRecipesBook.entity.request.update.UpdateShoppingListRequest;
import com.ceylan.myRecipesBook.service.ShoppingListManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingLists")
public class ShoppingListController {

    private ShoppingListManager shoppingListManager;

    public ShoppingListController(ShoppingListManager shoppingListManager) {
        this.shoppingListManager = shoppingListManager;
    }

    @GetMapping("/getShoppingListByUserId")
    public ResponseEntity<List<ShoppingListDto>> getShoppingListByUserId(int userId) {
        return new ResponseEntity<>(shoppingListManager.getShoppingListByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ShoppingList> createShoppingList(@RequestBody CreateShoppingListRequest createShoppingListRequest) {
        return new ResponseEntity<>(shoppingListManager.createShoppingList(createShoppingListRequest), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody UpdateShoppingListRequest request) {
        return new ResponseEntity(this.shoppingListManager.updateShoppingList(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody DeleteShoppingListRequest request) {
        return new ResponseEntity(this.shoppingListManager.deleteShoppingList(request), HttpStatus.OK);
    }
}

