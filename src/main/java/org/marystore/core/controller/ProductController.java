package org.marystore.core.controller;

import org.marystore.core.domain.Product;
import org.marystore.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/product/all")
    public Iterable<Product> getRandomProducts() {
        return service.getAll();
    }

    @RequestMapping("/product/create")
    public void create(Product product) {
        service.create(
                Optional.ofNullable(product.getCategory().getId())
                        .orElseThrow(() -> new IllegalArgumentException("category should be set")),
                product.getTitle(), product.getShortDescription(),
                product.getDescription(), product.getPrice(), product.getRate(),
                product.getImage());
    }

}
