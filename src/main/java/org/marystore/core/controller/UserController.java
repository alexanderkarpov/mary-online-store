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

    @RequestMapping(value = "/user/product/all", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productService.getAll();
    }

    @RequestMapping(value = "/user/category/{categoryId}/large.jpg", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getLargeImage(@PathVariable long categoryId) throws IOException {

        String imgFile = Optional.ofNullable(categoryService.get(categoryId))
                .map(Category::getImage)
                .orElse(DEFAULT_IMG);

        InputStream in = new FileInputStream(imgFile);
        return IOUtils.toByteArray(in);
    }

}
