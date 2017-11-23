package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = CategoryJson.CategoryJsonBuilder.class)
public class CategoryJson {

    private final Long id;
    private final String name;
    private final String description;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class CategoryJsonBuilder {
    }
}
