package org.marystore.core.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@Entity
public class CarouselItem {

    @Id
    private CarouselItemType id;
    private String title;
    @Column(length = 1024)
    private String description;
    private String image;

}
