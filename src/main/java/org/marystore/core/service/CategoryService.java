package org.marystore.core.service;

import org.marystore.core.domain.Category;

public interface CategoryService {

    Iterable<Category> getAll();

    Category get(long id);

    void create(String name, String description, String image);

    void update(Category category);

}
