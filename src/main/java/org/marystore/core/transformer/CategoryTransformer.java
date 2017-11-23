package org.marystore.core.transformer;

import org.marystore.core.domain.Category;
import org.marystore.core.dto.CategoryJson;
import org.springframework.stereotype.Component;

@Component
public class CategoryTransformer {

    public CategoryJson transform(Category category) {

        return CategoryJson.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
