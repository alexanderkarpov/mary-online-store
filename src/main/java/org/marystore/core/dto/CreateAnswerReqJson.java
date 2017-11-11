package org.marystore.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateAnswerReqJson {

    private final long questionId;
    private final String text;
    private final List<Long> productIds;

    @JsonCreator
    public CreateAnswerReqJson(@JsonProperty("questionId") long questionId,
                               @JsonProperty("text") String text,
                               @JsonProperty("productIds") List<Long> productIds) {
        this.questionId = questionId;
        this.text = text;
        this.productIds = productIds;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }

    public List<Long> getProductIds() {
        return productIds;
    }
}
