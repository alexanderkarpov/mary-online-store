package org.marystore.core.controller;

import org.marystore.core.domain.Category;
import org.marystore.core.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping(value = "/category/all", method = RequestMethod.GET)
    public Iterable<Category> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    public void add(@RequestParam String name, @RequestParam String description, @RequestParam String image) {
        service.create(name, description, image);
    }

}
