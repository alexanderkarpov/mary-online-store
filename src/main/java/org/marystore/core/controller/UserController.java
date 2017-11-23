package org.marystore.core.controller;

import org.apache.commons.io.IOUtils;
import org.marystore.core.domain.Category;
import org.marystore.core.domain.Product;
import org.marystore.core.dto.CategoryJson;
import org.marystore.core.dto.ProductJson;
import org.marystore.core.service.CategoryService;
import org.marystore.core.service.ProductService;
import org.marystore.core.transformer.CategoryTransformer;
import org.marystore.core.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class UserController {

    private final static String DEFAULT_IMG = "noimage.jpg";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryTransformer categoryTransformer;

    @Autowired
    private ProductTransformer productTransformer;

    @RequestMapping(value = "/user/category/all", method = RequestMethod.GET)
    public Iterable<CategoryJson> getAllCategories() {
        return StreamSupport.stream(categoryService.getAll().spliterator(), false)
                .map(categoryTransformer::transform)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/user/category/get", method = RequestMethod.GET)
    public CategoryJson getSingleCategory(@RequestParam long categoryId) {
        return categoryTransformer.transform(categoryService.get(categoryId));
    }

    @RequestMapping(value = "/user/product/all", method = RequestMethod.GET)
    public Iterable<ProductJson> getAllProducts() {
        return StreamSupport.stream(productService.getAll().spliterator(), false)
                .map(productTransformer::transform)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/user/product/get-by-category", method = RequestMethod.GET)
    public Iterable<ProductJson> getProductsByCategoryId(long categoryId) {
        return StreamSupport.stream(productService.getByCategoryId(categoryId).spliterator(), false)
                .map(productTransformer::transform)
                .collect(Collectors.toList());
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
