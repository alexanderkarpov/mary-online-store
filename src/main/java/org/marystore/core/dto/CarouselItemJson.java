package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = CarouselItemJson.CarouselItemJsonBuilder.class)
public class CarouselItemJson {

    private final String title;
    private final String description;
    private final String image;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class CarouselItemJsonBuilder {
    }
}
