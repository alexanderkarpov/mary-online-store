package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = CreateQuestionReqJson.CreateQuestionReqJsonBuilder.class)
public class CreateQuestionReqJson {

    private final String text;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class CreateQuestionReqJsonBuilder {

    }

}
