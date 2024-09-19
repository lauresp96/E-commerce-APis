package org.mihailivadaru.ecommerce.APIControllers;

import org.mihailivadaru.ecommerce.models.Category;
import org.mihailivadaru.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        if (categoryService.readCategory(category.getCategoryName()) != null) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{categoryID}", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> updateCategory(
            @PathVariable("categoryID") Integer categoryID,
            @RequestBody Category category) {

        // Check if the category exists.
        if (categoryService.readCategory(categoryID) != null) {
            // If the category exists, update it.
            categoryService.updateCategory(categoryID, category);
            return new ResponseEntity<>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
        }

        // If the category doesn't exist, return a response indicating failure.
        return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
    }
}
