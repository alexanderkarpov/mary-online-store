package org.marystore.core.service;

import org.marystore.core.domain.Category;
import org.marystore.core.domain.Product;
import org.marystore.core.persistence.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ProductServiceImpl implements ProductService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageNameService imageNameService;

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<Product> getByCategoryId(long categoryId) {
        //TODO: optimize this shit using Criteria
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .filter(p -> p.getCategory().getId() == categoryId)
                .collect(Collectors.toList());
//        return productRepository.findAll();
    }

    @Override
    public Product get(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public void create(long categoryId, String title, String shortDescription, String description, double price,
                       int rate, MultipartFile file) throws IOException {
        Category category = Optional.ofNullable(categoryService.get(categoryId))
                .orElseThrow(() -> new IllegalArgumentException("Category " + categoryId + " not found"));

        String fileName = imageNameService.getNextName(file.getOriginalFilename());
        byte[] fileBytes = file.getBytes();
        File imageFile = new File(fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            bufferedOutputStream.write(fileBytes);
            bufferedOutputStream.flush();
        }

        Product product = new Product();
        product.setCategory(category);
        product.setTitle(title);
        product.setShortDescription(shortDescription);
        product.setDescription(description);
        product.setPrice(price);
        product.setRate(rate);
        product.setImage(imageFile.getPath());
        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        Optional.ofNullable(product.getCategory())
                .map(c -> categoryService.get(c.getId()))
                .orElseThrow(() -> new IllegalArgumentException("Category " + product.getCategory() + " not found"));

        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        Product product = productRepository.findOne(id);

        if(product != null) {
            File file = new File(product.getImage());
            boolean deleted = file.delete();
            if(!deleted) {
                LOGGER.warn("file {} was't deleted", file.getAbsoluteFile().getPath());
            }
            productRepository.delete(id);
        }
    }

}
