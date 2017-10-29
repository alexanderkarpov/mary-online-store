package org.marystore.core.service;

import org.marystore.core.domain.Category;
import org.marystore.core.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

//    @PostConstruct
//    public void init() {
//        create("Category 1", "Category 1 description", "http://placehold.it/700x400");
//        create("Category 2", "Category 2 description", "http://placehold.it/700x400");
//        create("Category 3", "Category 3 description", "http://placehold.it/700x400");
//    }

    @Override
    public Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category get(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void create(String name, String description, MultipartFile file) throws IOException {

        String fileName = file.getName();
        byte[] fileBytes = file.getBytes();
        File imageFile = new File(fileName);

        try (FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            bufferedOutputStream.write(fileBytes);
            bufferedOutputStream.flush();
        }

        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setImage(imageFile.getPath());

        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

}
