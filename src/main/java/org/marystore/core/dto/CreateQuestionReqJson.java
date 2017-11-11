package org.marystore.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateQuestionReqJson {

    private final String text;

    @JsonCreator
    public CreateQuestionReqJson(@JsonProperty("text") String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
