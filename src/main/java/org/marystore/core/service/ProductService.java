package org.marystore.core.service;

import org.marystore.core.domain.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {

    Iterable<Product> getAll();

    Iterable<Product> getByCategoryId(long categoryId);

    Product get(long id);

    void create(long categoryId, String title, String shortDescription, String description, double price,
                int rate, MultipartFile file) throws IOException;

    void update(Product product);
}
