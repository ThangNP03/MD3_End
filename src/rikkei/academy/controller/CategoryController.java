package rikkei.academy.controller;

import rikkei.academy.model.Category;
import rikkei.academy.model.Product;
import rikkei.academy.service.category.CategoryServiceIMPL;
import rikkei.academy.service.category.ICategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    List<Category> categoryList = new ArrayList<>();
    public ICategoryService categoryService = new CategoryServiceIMPL();
    public List<Category> getListCategory(){
        return categoryService.findAll();
    }
    public void createCategoryToDB(Category category){
        categoryService.save(category);
    }
    public void updateCategory(Category category){
        categoryService.save(category);
    }
    public Category detailCategory(int id){
      return categoryService.findById(id);
    }
    public List<Category> searchCategoryByName(String name){
        return categoryService.searchCategoryByName(name);
    }
}
