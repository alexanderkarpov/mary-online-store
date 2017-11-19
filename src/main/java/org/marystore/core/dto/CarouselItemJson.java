package org.marystore.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarouselItemJson {

    private final String title;
    private final String description;
    private final String image;

    @JsonCreator
    public CarouselItemJson(@JsonProperty("title") String title,
                            @JsonProperty("description") String description,
                            @JsonProperty("image") String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
