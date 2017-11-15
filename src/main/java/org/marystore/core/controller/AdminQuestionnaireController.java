package org.marystore.core.controller;

import org.marystore.core.dto.AnswerJson;
import org.marystore.core.dto.CreateAnswerReqJson;
import org.marystore.core.dto.CreateQuestionReqJson;
import org.marystore.core.dto.QuestionJson;
import org.marystore.core.service.QuestionnaireService;
import org.marystore.core.transformer.AnswerTransformer;
import org.marystore.core.transformer.QuestionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/admin/questionnaire/all", method = RequestMethod.GET)
    public List<QuestionJson> getAllQuestions() {
        return questionnaireService.getAllQuestions()
                .stream().map(questionTransformer::transform).collect(Collectors.toList());
    }

    @RequestMapping(value = "/admin/questionnaire/answers/all")
    public List<AnswerJson> getAnswersByQuestionId(@RequestParam long questionId) {
        return questionnaireService.getAnswersByQuestionId(questionId).stream()
                .map(answerTransformer::transform).collect(Collectors.toList());
    }

    @RequestMapping(value = "/admin/questionnaire/question", method = RequestMethod.GET)
    public QuestionJson getQuestionById(@RequestParam long id) {
        return questionTransformer.transform(questionnaireService.getQuestionById(id));
    }

    @RequestMapping(value = "/admin/questionnaire/answer", method = RequestMethod.GET)
    public AnswerJson getAnswerById(@RequestParam long id) {
        return answerTransformer.transform(questionnaireService.getAnswerById(id));
    }

    @RequestMapping(value = "/admin/questionnaire/question", method = RequestMethod.POST)
    public void createQuestion(@RequestBody CreateQuestionReqJson req) {
        questionnaireService.createQuestion(req.getText());
    }

    @RequestMapping(value = "/admin/questionnaire/answer", method = RequestMethod.POST)
    public void createAnswer(@RequestBody CreateAnswerReqJson req) {
        questionnaireService.createAnswer(req.getQuestionId(), req.getText(), req.getProductIds());
    }

    @RequestMapping(value = "/admin/questionnaire/question", method = RequestMethod.DELETE)
    public void deleteQuestion(@RequestParam long id) {
        questionnaireService.deleteQuestion(id);
    }

}
