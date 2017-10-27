package org.marystore.core.controller;

import org.marystore.core.domain.Category;
import org.marystore.core.domain.Product;
import org.marystore.core.service.CategoryService;
import org.marystore.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/admin/category/all", method = RequestMethod.GET)
    public Iterable<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @RequestMapping(value = "/admin/product/all", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productService.getAll();
    }

    @RequestMapping(value = "/admin/category/create", method = RequestMethod.POST)
    public void addCategory(@RequestParam String name, @RequestParam String description, @RequestParam String image) {
        categoryService.create(name, description, image);
    }

    @RequestMapping("/admin/product/create")
    public void create(Product product) {
        productService.create(
                Optional.ofNullable(product.getCategory().getId())
                        .orElseThrow(() -> new IllegalArgumentException("category should be set")),
                product.getTitle(), product.getShortDescription(),
                product.getDescription(), product.getPrice(), product.getRate(),
                product.getImage());
    }
}
