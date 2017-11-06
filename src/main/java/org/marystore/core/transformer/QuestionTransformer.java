package org.marystore.core.transformer;

import org.marystore.core.domain.Question;
import org.marystore.core.dto.QuestionJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuestionTransformer {

    @Autowired
    private AnswerTransformer answerTransformer;

    public QuestionJson transform(Question src) {
        return QuestionJson.of(src.getId(), src.getText(),
                src.getAnswers().stream().map(answerTransformer::transform).collect(Collectors.toList()));
    }

}
