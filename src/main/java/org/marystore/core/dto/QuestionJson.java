package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonDeserialize(builder = QuestionJson.QuestionJsonBuilder.class)
public class QuestionJson {

    private final long id;
    private final String text;
    private final List<AnswerJson> answers;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class QuestionJsonBuilder {

    }
}
