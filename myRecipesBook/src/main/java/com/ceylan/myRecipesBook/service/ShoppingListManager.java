package com.ceylan.myRecipesBook.service;

import com.ceylan.myRecipesBook.entity.concrete.ShoppingList;
import com.ceylan.myRecipesBook.entity.concrete.User;
import com.ceylan.myRecipesBook.entity.dto.ShoppingListDto;
import com.ceylan.myRecipesBook.entity.request.create.CreateShoppingListRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteShoppingListRequest;
import com.ceylan.myRecipesBook.entity.request.update.UpdateShoppingListRequest;
import com.ceylan.myRecipesBook.repository.ShoppingListDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingListManager {

    private final ShoppingListDao shoppingListDao;
    private ModelMapper modelMapper;

    public ShoppingListManager(ShoppingListDao shoppingListDao, ModelMapper modelMapper) {
        this.shoppingListDao = shoppingListDao;
        this.modelMapper = modelMapper;
    }

    public List<ShoppingListDto> getShoppingListByUserId(int userId) {
        List<ShoppingList> shoppingLists = this.shoppingListDao.getByUser_UserId(userId);
        List<ShoppingListDto> shoppingListDtos = shoppingLists.stream().map(shoppingList -> modelMapper.map(shoppingList, ShoppingListDto.class)).collect(Collectors.toList());
        return shoppingListDtos;
    }

    public ShoppingList createShoppingList(CreateShoppingListRequest createShoppingListRequest) {
        ShoppingList shoppingList = modelMapper.map(createShoppingListRequest, ShoppingList.class);
        this.shoppingListDao.save(shoppingList);
        return shoppingList;
    }

    public ShoppingList deleteShoppingList(DeleteShoppingListRequest deleteShoppingListRequest) {
        ShoppingList shoppingList = modelMapper.map(deleteShoppingListRequest, ShoppingList.class);
        this.shoppingListDao.delete(shoppingList);
        return shoppingList;
    }

    public ShoppingList updateShoppingList(UpdateShoppingListRequest updateShoppingListRequest) {
        User user = modelMapper.map(updateShoppingListRequest, User.class);
        ShoppingList shoppingList = modelMapper.map(updateShoppingListRequest, ShoppingList.class);
        shoppingList.setUser(user);
        this.shoppingListDao.save(shoppingList);
        return shoppingList;
    }
}