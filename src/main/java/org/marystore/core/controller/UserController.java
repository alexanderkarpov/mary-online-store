package org.marystore.core.controller;

import org.apache.commons.io.IOUtils;
import org.marystore.core.domain.Category;
import org.marystore.core.domain.Product;
import org.marystore.core.service.CategoryService;
import org.marystore.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@RestController
public class UserController {

    private final static String DEFAULT_IMG = "noimage.jpg";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/user/category/all", method = RequestMethod.GET)
    public Iterable<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @RequestMapping(value = "/user/category/get", method = RequestMethod.GET)
    public Category getSingleCategory(@RequestParam long categoryId) {
        return categoryService.get(categoryId);
    }

    @RequestMapping(value = "/user/product/all", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productService.getAll();
    }

    @RequestMapping(value = "/user/product/get-by-category", method = RequestMethod.GET)
    public Iterable<Product> getProductsByCategoryId(long categoryId) {
        return productService.getByCategoryId(categoryId);
    }

    @RequestMapping(value = "/user/category/{categoryId}/large.jpg", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getLargeCategoryImage(@PathVariable long categoryId) throws IOException {

        String imgFile = Optional.ofNullable(categoryService.get(categoryId))
                .map(Category::getImage)
                .orElse(DEFAULT_IMG);

        InputStream in = new FileInputStream(imgFile);
        return IOUtils.toByteArray(in);
    }

    @RequestMapping(value = "/user/product/{productId}/large.jpg", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getLargeProductImage(@PathVariable long productId) throws IOException {

        String imgFile = Optional.ofNullable(productService.get(productId))
                .map(Product::getImage)
                .orElse(DEFAULT_IMG);

        InputStream in = new FileInputStream(imgFile);
        return IOUtils.toByteArray(in);
    }

}
