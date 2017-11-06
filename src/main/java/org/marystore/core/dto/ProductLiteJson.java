package org.marystore.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductLiteJson {

    private final long id;
    private final String code;

    @JsonCreator
    public static ProductLiteJson of(@JsonProperty("id")long id, @JsonProperty("code") String code) {
        return new ProductLiteJson(id, code);
    }

    private ProductLiteJson(long id, String code) {
        this.id = id;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
