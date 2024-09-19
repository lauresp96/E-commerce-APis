package org.mihailivadaru.ecommerce.webControllers;

import org.mihailivadaru.ecommerce.DTO.ProductDTO;
import org.mihailivadaru.ecommerce.models.Category;
import org.mihailivadaru.ecommerce.models.Product;
import org.mihailivadaru.ecommerce.services.ProductService;
import org.mihailivadaru.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
                             @RequestParam("categoryId") Integer categoryId) {
        productService.addProduct(productDTO, categoryId);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
