package org.marystore.core.service;

import org.marystore.core.domain.Category;
import org.marystore.core.persistence.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ImageNameService imageNameService;

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

        String fileName = imageNameService.getNextName(file.getOriginalFilename());
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

    @Override
    public void delete(long id) {
        Category category = categoryRepository.findOne(id);
        if(category != null) {
            File file = new File(category.getImage());
            boolean deleted = file.delete();
            if(!deleted) {
                LOGGER.warn("file {} was't deleted", file.getAbsoluteFile().getPath());
            }
            categoryRepository.delete(id);
        }

    }

}
