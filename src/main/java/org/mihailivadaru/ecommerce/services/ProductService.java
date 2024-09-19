package org.mihailivadaru.ecommerce.services;

import org.mihailivadaru.ecommerce.DTO.ProductDTO;
import org.mihailivadaru.ecommerce.models.Category;
import org.mihailivadaru.ecommerce.models.Product;
import org.mihailivadaru.ecommerce.repositories.ProductRepository;
import org.mihailivadaru.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void addProduct(ProductDTO productDTO, Integer categoryId) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setImageURL(productDTO.getImageURL());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());

        // Retrieve the category from the database
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }
}
