package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = ProductLiteJson.ProductLiteJsonBuilder.class)
public class ProductLiteJson {

    private final long id;
    private final String code;
    private final String title;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class ProductLiteJsonBuilder {

    }

}
