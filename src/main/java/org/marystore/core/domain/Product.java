package org.marystore.core.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "product_code", length = 10, unique = true)
    private String code;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    private String title;
    @Column(length = 1024)
    private String shortDescription;
    @Column(length = 4096)
    private String description;
    private int price;
    private int rate;
    private String image;
}
