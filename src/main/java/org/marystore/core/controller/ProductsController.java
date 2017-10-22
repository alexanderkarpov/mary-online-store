package org.marystore.core.controller;

import org.marystore.core.domain.Product;
import org.marystore.core.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService service;

    @RequestMapping("/products")
    public List<Product> getRandomProducts() {
        return service.getAll();
    }

}
