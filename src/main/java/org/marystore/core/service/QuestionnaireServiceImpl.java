package org.marystore.core.service;

import org.marystore.core.domain.Answer;
import org.marystore.core.domain.Question;
import org.marystore.core.persistence.AnswerRepository;
import org.marystore.core.persistence.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Question> getAllQuestions() {
        return StreamSupport.stream(questionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }

    @Override
    public Question getQuestionById(long id) {
        return questionRepository.findOne(id);
    }

    @Override
    public Answer getAnswerById(long id) {
        return answerRepository.findOne(id);
    }

    @Override
    public void createQuestion(String text, List<Answer> answers) {
        //TODO: transaction

    }

    @Override
    public void addAnswer(long questionId, Answer answer) {

    }

    @Override
    public void updateQuestion(Question question) {

    }

    @Override
    public void updateAnswer(Answer answer) {

    }

    @Override
    public void deleteQuestion(long questionId) {

    }

    @Override
    public void deleteAnswer(long answerId) {

    }
}
