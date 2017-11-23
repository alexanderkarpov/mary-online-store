package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = ProductJson.ProductJsonBuilder.class)
public class ProductJson {

    private long id;
    private String code;
    private CategoryJson category;
    private String title;
    private String shortDescription;
    private String description;
    private double price;
    private int rate;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class ProductJsonBuilder {
    }
}
