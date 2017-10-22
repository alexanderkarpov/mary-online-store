package org.marystore.core.service;

import org.marystore.core.domain.Category;

import java.util.List;

public interface CategoriesService {

    List<Category> getAll();

    Category get(long id);

    Category create(String name, String description);

    void updateName(long id, String name);

    void updateDescription(long id, String description);

}
