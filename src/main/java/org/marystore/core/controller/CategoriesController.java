package org.marystore.core.controller;

import org.marystore.core.domain.Category;
import org.marystore.core.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class CategoriesController {

    @Autowired
    private CategoriesService service;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public Iterable<Category> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/categories/add", method = RequestMethod.POST)
    public void add(@RequestParam String name, @RequestParam String description, @RequestParam String image) {
        service.create(name, description, image);
    }

}
