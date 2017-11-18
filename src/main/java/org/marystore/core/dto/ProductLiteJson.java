package org.marystore.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductLiteJson {

    private final long id;
    private final String code;
    private final String title;

    @JsonCreator
    public static ProductLiteJson of(@JsonProperty("id")long id, @JsonProperty("code") String code,
                                     @JsonProperty("title") String title) {
        return new ProductLiteJson(id, code, title);
    }

    private ProductLiteJson(long id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
