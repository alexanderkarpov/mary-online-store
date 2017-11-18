package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Optional;

public class CarouselItemJson {

    private final String title;
    private final String description;
    private final String image;

    private CarouselItemJson(Builder builder) {
        this.title = Optional.ofNullable(builder.title).orElse("");
        this.description = Optional.ofNullable(builder.description).orElse("");
        this.image = Optional.ofNullable(builder.image).orElse("");
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

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String title;
        private String description;
        private String image;


        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public CarouselItemJson build() {
            return new CarouselItemJson(this);
        }
    }
}
