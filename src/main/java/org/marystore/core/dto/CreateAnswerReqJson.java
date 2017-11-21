package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonDeserialize(builder = CreateAnswerReqJson.CreateAnswerReqJsonBuilder.class)
public class CreateAnswerReqJson {

    private final long questionId;
    private final String text;
    private final List<Long> productIds;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class CreateAnswerReqJsonBuilder {

    }
}
