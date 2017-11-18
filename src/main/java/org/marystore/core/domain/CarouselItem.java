package org.marystore.core.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarouselItem {

    @Id
    private CarouselItemType id;
    private String title;
    @Column(length = 1024)
    private String description;
    private String image;

    public CarouselItemType getId() {
        return id;
    }

    public void setId(CarouselItemType id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("description", description)
                .append("image", image)
                .toString();
    }
}
