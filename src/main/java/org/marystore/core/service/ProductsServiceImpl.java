package org.marystore.core.service;

import org.marystore.core.domain.Product;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ProductsServiceImpl implements ProductsService {

    private static final List<Product> SAMPLE = Collections.unmodifiableList(
            Arrays.asList(
                    Product.newBuilder()
                            .setId(1)
                            .setCategoryId(1)
                            .setTitle("Item One")
                            .setShortDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setImage("http://placehold.it/700x400")
                            .setPrice(199.99)
                            .build(),

                    Product.newBuilder()
                            .setId(2)
                            .setCategoryId(1)
                            .setTitle("Item Two")
                            .setShortDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setImage("http://placehold.it/700x400")
                            .setPrice(199.99)
                            .build(),

                    Product.newBuilder()
                            .setId(3)
                            .setCategoryId(1)
                            .setTitle("Item Three")
                            .setShortDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setImage("http://placehold.it/700x400")
                            .setPrice(199.99)
                            .build(),

                    Product.newBuilder()
                            .setId(4)
                            .setCategoryId(1)
                            .setTitle("Item Four")
                            .setShortDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setImage("http://placehold.it/700x400")
                            .setPrice(199.99)
                            .build(),

                    Product.newBuilder()
                            .setId(5)
                            .setCategoryId(1)
                            .setTitle("Item Five")
                            .setShortDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setImage("http://placehold.it/700x400")
                            .setPrice(199.99)
                            .build(),

                    Product.newBuilder()
                            .setId(6)
                            .setCategoryId(1)
                            .setTitle("Item Six")
                            .setShortDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!")
                            .setImage("http://placehold.it/700x400")
                            .setPrice(199.99)
                            .build()

            )
    );

    @Override
    public List<Product> getAll() {
        return SAMPLE;
    }
}
