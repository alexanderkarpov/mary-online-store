package org.marystore.core.service;

import org.marystore.core.domain.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CategoriesServiceImpl implements CategoriesService {

    private static List<Category> SAMPLE = Collections.unmodifiableList(
            Arrays.asList(
                    Category.newBuilder().setId(1).setName("Category 1").setDescription("description 1").build(),
                    Category.newBuilder().setId(2).setName("Category 2").setDescription("description 2").build(),
                    Category.newBuilder().setId(3).setName("Category 3").setDescription("description 3").build()
            )

    );

    @Override
    public List<Category> getAll() {
        return SAMPLE;
    }

    @Override
    public Category get(long id) {
        return null;
    }

    @Override
    public Category create(String name, String description) {
        return null;
    }

    @Override
    public void updateName(long id, String name) {

    }

    @Override
    public void updateDescription(long id, String description) {

    }
}
