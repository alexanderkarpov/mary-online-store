package org.marystore.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonDeserialize(builder = AnswerJson.AnswerJsonBuilder.class)
public class AnswerJson {

    private final long id;
    private final String text;
    private final List<ProductLiteJson> products;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class AnswerJsonBuilder {
    }

}
