package org.marystore.core.service;

import org.marystore.core.domain.Product;

public interface ProductService {

    Iterable<Product> getAll();

    Product get(long id);

    void create(long categoryId, String title, String shortDescription, String description, double price,
                int rate, String image);

    void update(Product product);
}
