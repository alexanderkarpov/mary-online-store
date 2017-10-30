package org.marystore.core.service;

import org.marystore.core.domain.Category;
import org.marystore.core.domain.Product;
import org.marystore.core.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<Product> getByCategoryId(long categoryId) {
        //TODO: optimize this shit using Criteria
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .filter(p -> p.getId() == categoryId)
                .collect(Collectors.toList());
    }

    @Override
    public Product get(long id) {
        return productRepository.findOne(id);
    }

    @Override
    @Transactional
    public void create(long categoryId, String title, String shortDescription, String description, double price,
                       int rate, String image) {
        Category category = Optional.ofNullable(categoryService.get(categoryId))
                .orElseThrow(() -> new IllegalArgumentException("Category " + categoryId + " not found"));

        Product product = new Product();
        product.setCategory(category);
        product.setTitle(title);
        product.setShortDescription(shortDescription);
        product.setDescription(description);
        product.setPrice(price);
        product.setRate(rate);
        product.setImage(image);
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

    /*
    Product.newBuilder()
                            .setId(6)
                            .setCategoryId(1)
                            .setTitle("Item Six")
                            .setShortDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setImage("http://placehold.it/700x400")
                            .setPrice(199.99)
                            .build()
     */


}
