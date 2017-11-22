package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonDeserialize(builder = UpdateAnswerReqJson.UpdateAnswerReqJsonBuilder.class)
public class UpdateAnswerReqJson {

    private final long answerId;
    private final String text;
    private final List<Long> productIds;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class UpdateAnswerReqJsonBuilder {

    }
}
