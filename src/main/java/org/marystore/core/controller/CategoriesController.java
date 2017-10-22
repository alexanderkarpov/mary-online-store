package org.marystore.core.controller;

import org.marystore.core.domain.Category;
import org.marystore.core.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    private CategoriesService service;

    @RequestMapping("/categories")
    public List<Category> getAllCategories() {
        return service.getAll();
    }

}
