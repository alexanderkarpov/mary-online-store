package org.marystore.core.persistence;

import org.marystore.core.domain.Category;
import org.marystore.core.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
