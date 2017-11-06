package org.marystore.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AnswerJson {

    private final long id;
    private final String text;
    private final List<ProductLiteJson> products;

    @JsonCreator
    public static AnswerJson of(@JsonProperty long id,
                                @JsonProperty String text,
                                @JsonProperty List<ProductLiteJson> products) {
        return new AnswerJson(id, text, products);
    }

    private AnswerJson(long id, String text, List<ProductLiteJson> products) {
        this.id = id;
        this.text = text;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<ProductLiteJson> getProducts() {
        return products;
    }
}
