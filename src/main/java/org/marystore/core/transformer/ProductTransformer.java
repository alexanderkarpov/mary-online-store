package org.marystore.core.transformer;

import org.marystore.core.domain.Product;
import org.marystore.core.dto.ProductJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformer {

    @Autowired
    private CategoryTransformer categoryTransformer;

    public ProductJson transform(Product product) {

        return ProductJson.builder()
                .id(product.getId())
                .code(product.getCode())
                .category(categoryTransformer.transform(product.getCategory()))
                .title(product.getTitle())
                .shortDescription(product.getShortDescription())
                .description(product.getDescription())
                .price(product.getPrice() / 100.0)
                .rate(product.getRate())
                .build();
    }
}
