package org.marystore.core.service;

import org.marystore.core.domain.Category;
import org.marystore.core.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void init() {
        create("Category 1", "Category 1 description", "http://placehold.it/700x400");
        create("Category 2", "Category 2 description", "http://placehold.it/700x400");
        create("Category 3", "Category 3 description", "http://placehold.it/700x400");
    }

    @Override
    public Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category get(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void create(String name, String description, String image) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setImage(image);
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

}
