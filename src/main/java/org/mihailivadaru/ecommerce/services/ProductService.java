package org.mihailivadaru.ecommerce.services;

import org.mihailivadaru.ecommerce.DTO.ProductDTO;
import org.mihailivadaru.ecommerce.models.Category;
import org.mihailivadaru.ecommerce.models.Product;
import org.mihailivadaru.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setImageURL(productDTO.getImageURL());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);

        productRepository.save(product);
    }
}
