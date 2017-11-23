package org.marystore.core.controller;

import org.marystore.core.domain.Category;
import org.marystore.core.domain.Product;
import org.marystore.core.dto.CategoryJson;
import org.marystore.core.dto.ProductJson;
import org.marystore.core.exceptions.ServerErrorException;
import org.marystore.core.service.CategoryService;
import org.marystore.core.service.ProductService;
import org.marystore.core.transformer.CategoryTransformer;
import org.marystore.core.transformer.ProductTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class AdminController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryTransformer categoryTransformer;

    @Autowired
    private ProductTransformer productTransformer;

    @RequestMapping(value = "/admin/category/all", method = RequestMethod.GET)
    public Iterable<CategoryJson> getAllCategories() {
        return StreamSupport.stream(categoryService.getAll().spliterator(), false)
                .map(categoryTransformer::transform)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/admin/category/create", method = RequestMethod.POST)
    public void addCategory(@RequestPart("metadata") Category category,
                            @RequestPart("file") MultipartFile file) {
        try {
            categoryService.create(category.getName(), category.getDescription(), file);
        } catch (IOException ex) {
            throw new ServerErrorException("Can't create category", ex);
        }
    }

    @RequestMapping(value = "/admin/category/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable long id) {
        categoryService.delete(id);
    }

    @RequestMapping("/admin/product/create")
    public void create(@RequestPart("metadata") Product product,
                       @RequestPart("file") MultipartFile file) {
        try {
            productService.create(
                    Optional.ofNullable(product.getCategory().getId())
                            .orElseThrow(() -> new IllegalArgumentException("category should be set")),
                    product.getCode(),
                    product.getTitle(), product.getShortDescription(),
                    product.getDescription(), product.getPrice(), product.getRate(),
                    file);

        } catch (IOException ex) {
            throw new ServerErrorException("Can't create category", ex);
        }
    }

    @RequestMapping(value = "/admin/product/get", method = RequestMethod.GET)
    public Iterable<ProductJson> getProducts(@RequestParam Long categoryId) {
        LOGGER.info("Load products by category {}", categoryId);
        Iterable<Product> products = Optional.ofNullable(categoryId)
                .map(productService::getByCategoryId)
                .orElse(productService.getAll());

        return StreamSupport.stream(products.spliterator(), false)
                .map(productTransformer::transform)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/admin/product/getall", method = RequestMethod.GET)
    public Iterable<ProductJson> getAllProducts() {
        LOGGER.info("Load all products");
        return StreamSupport.stream(productService.getAll().spliterator(), false)
                .map(productTransformer::transform)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/admin/product/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable long id) {
        productService.delete(id);
    }

}
