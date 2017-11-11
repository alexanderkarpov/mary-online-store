package org.marystore.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CreateQuestionReqJson {

    private final String text;

    @JsonCreator
    public CreateQuestionReqJson(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
