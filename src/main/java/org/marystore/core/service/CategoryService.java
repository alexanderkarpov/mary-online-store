package org.marystore.core.service;

import org.marystore.core.domain.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CategoryService {

    Iterable<Category> getAll();

    Category get(long id);

    void create(String name, String description, MultipartFile file) throws IOException;

    void update(Category category);

    void delete(long id);
}
