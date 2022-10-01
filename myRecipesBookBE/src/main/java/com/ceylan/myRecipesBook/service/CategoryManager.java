package com.ceylan.myRecipesBook.service;

import com.ceylan.myRecipesBook.entity.concrete.Category;
import com.ceylan.myRecipesBook.entity.dto.CategoryDto;
import com.ceylan.myRecipesBook.entity.request.create.CreateCategoryRequest;
import com.ceylan.myRecipesBook.entity.request.delete.DeleteCategoryRequest;
import com.ceylan.myRecipesBook.entity.request.update.UpdateCategoryRequest;
import com.ceylan.myRecipesBook.repository.CategoryDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager {

    private CategoryDao categoryDao;
    private ModelMapper modelMapper;

    public CategoryManager(CategoryDao categoryDao, ModelMapper modelMapper) {
        this.categoryDao = categoryDao;
        this.modelMapper = modelMapper;
    }

    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryDao.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());

        return categoryDtos;
    }

    public CategoryDto getCategoryById(int id) {
        Category category = this.categoryDao.getById(id);
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);

        return categoryDto;
    }

    public Category createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = modelMapper.map(createCategoryRequest, Category.class);
        this.categoryDao.save(category);
        return category;
    }

    public Category deleteCategory(DeleteCategoryRequest deleteCategoryRequest) {
        Category category = modelMapper.map(deleteCategoryRequest, Category.class);
        this.categoryDao.delete(category);
        return category;
    }

    public Category updateCategory(UpdateCategoryRequest updateCategoryRequest) {
        Category category = modelMapper.map(updateCategoryRequest, Category.class);
        this.categoryDao.save(category);
        return category;
    }

}
