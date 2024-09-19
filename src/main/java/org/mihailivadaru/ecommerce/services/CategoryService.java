package org.mihailivadaru.ecommerce.services;

import org.mihailivadaru.ecommerce.models.Category;
import org.mihailivadaru.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

   public Category readCategory(String categoryName){
        return categoryRepository.findByCategoryName(categoryName);
   }

   public Optional<Category> readCategory(Integer categoryId){
        return categoryRepository.findById(categoryId);
   }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void updateCategory(Integer categoryID, Category newCategory) {
        Category category = categoryRepository.findById(categoryID).get();
        category.setCategoryName(newCategory.getCategoryName());
        category.setDescription(newCategory.getDescription());
        category.setImageUrl(newCategory.getImageUrl());
        categoryRepository.save(category);
    }

}
