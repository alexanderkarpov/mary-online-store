package org.marystore.core.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Product {

    private final long id;
    private final long categoryId;
    private final String title;
    private final String shortDescription;
    private final String description;
    private final double price;
    private final int rate;
    private final String image;

    public static Builder newBuilder() {
        return new Builder();
    }

    private Product(Builder builder) {
        this.id = builder.id;
        this.categoryId = builder.categoryId;
        this.title = builder.title;
        this.shortDescription = builder.shortDescription;
        this.description = builder.description;
        this.price = builder.price;
        this.rate = builder.rate;
        this.image = builder.image;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getRate() {
        return rate;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("categoryId", categoryId)
                .append("title", title)
                .append("shortDescription", shortDescription)
                .append("description", description)
                .append("price", price)
                .append("rate", rate)
                .append("image", image)
                .toString();
    }

    public static class Builder {
        private long id;
        private long categoryId;
        private String title;
        private String shortDescription;
        private String description;
        private double price;
        private int rate;
        private String image;

        private Builder() {

        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setCategoryId(long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setRate(int rate) {
            this.rate = rate;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
