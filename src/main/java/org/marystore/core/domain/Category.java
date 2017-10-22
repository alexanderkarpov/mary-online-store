package org.marystore.core.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Category {

    private final long id;
    private final String name;
    private final String description;
    private final String imageSrc;

    public static Builder newBuilder() {
        return new Builder();
    }

    private Category(long id, String name, String description, String imageSrc) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageSrc = imageSrc;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("imageSrc", imageSrc)
                .toString();
    }

    public static class Builder {

        private long id;
        private String name;
        private String description;
        private String imageSrc;

        private Builder() {

        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setImageSrc(String imageSrc) {
            this.imageSrc = imageSrc;
            return this;
        }

        public Category build() {
            return new Category(id, name, description, imageSrc);
        }
    }
}
