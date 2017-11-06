package org.marystore.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionJson {

    private final long id;
    private final String text;
    private final List<AnswerJson> answers;

    @JsonCreator
    public static QuestionJson of(@JsonProperty long id,
                                  @JsonProperty String text,
                                  @JsonProperty List<AnswerJson> answers) {
        return new QuestionJson(id, text, answers);
    }

    private QuestionJson(long id, String text, List<AnswerJson> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers; //TODO: list should be immutable
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<AnswerJson> getAnswers() {
        return answers;
    }
}
