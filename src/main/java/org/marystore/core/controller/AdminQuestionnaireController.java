package org.marystore.core.controller;

import org.marystore.core.dto.AnswerJson;
import org.marystore.core.dto.QuestionJson;
import org.marystore.core.service.QuestionnaireService;
import org.marystore.core.transformer.AnswerTransformer;
import org.marystore.core.transformer.QuestionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdminQuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionTransformer questionTransformer;

    @Autowired
    private AnswerTransformer answerTransformer;


    public List<QuestionJson> getAllQuestions() {
        return questionnaireService.getAllQuestions()
                .stream().map(questionTransformer::transform).collect(Collectors.toList());
    }

    public QuestionJson getQuestionById(long id) {
        return questionTransformer.transform(questionnaireService.getQuestionById(id));

    }

    public AnswerJson getAnswerById(long id) {
        return answerTransformer.transform(questionnaireService.getAnswerById(id));
    }

}
