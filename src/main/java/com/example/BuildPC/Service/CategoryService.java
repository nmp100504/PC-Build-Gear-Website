package com.example.BuildPC.Service;


import com.example.BuildPC.dto.CategoryDto;
import com.example.BuildPC.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void save(CategoryDto categoryDto);
    Category findCategoryById(int id);
    void upadteCategory(Category category);
    void deleteCategoryById(int id);
}
