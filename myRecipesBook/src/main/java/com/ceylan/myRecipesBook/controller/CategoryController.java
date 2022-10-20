package com.ceylan.myRecipesBook.controller;

import com.ceylan.myRecipesBook.entity.dto.CategoryDto;
import com.ceylan.myRecipesBook.entity.request.create.CreateCategoryRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteCategoryRequest;
import com.ceylan.myRecipesBook.entity.request.update.UpdateCategoryRequest;
import com.ceylan.myRecipesBook.service.CategoryManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryManager categoryManager;

    public CategoryController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getRecipes() {
        return new ResponseEntity<>(categoryManager.getCategories(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<CategoryDto> getById(int id) {
        return new ResponseEntity(this.categoryManager.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity update(@RequestBody CreateCategoryRequest request) {
        return new ResponseEntity(this.categoryManager.createCategory(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody UpdateCategoryRequest request) {
        return new ResponseEntity(this.categoryManager.updateCategory(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody DeleteCategoryRequest request) {
        return new ResponseEntity(this.categoryManager.deleteCategory(request), HttpStatus.OK);
    }

}
