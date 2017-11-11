package org.marystore.core.service;

import org.marystore.core.domain.Answer;
import org.marystore.core.domain.Product;
import org.marystore.core.domain.Question;
import org.marystore.core.persistence.AnswerRepository;
import org.marystore.core.persistence.ProductRepository;
import org.marystore.core.persistence.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final static Logger LOGGER = LoggerFactory.getLogger(QuestionnaireServiceImpl.class);

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public List<Question> getAllQuestions() {
        return StreamSupport.stream(questionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Question getQuestionById(long id) {
        return questionRepository.findOne(id);
    }

    @Override
    @Transactional
    public Answer getAnswerById(long id) {
        return answerRepository.findOne(id);
    }

    @Override
    @Transactional
    public void createQuestion(String text) {
        Question question = new Question();
        question.setText(text);
        question.setAnswers(Collections.emptyList());

        questionRepository.save(question);


    }

    @Override
    @Transactional
    public void createAnswer(long questionId, String text, List<Long> productIds) {
        Question question = Optional.ofNullable(questionRepository.findOne(questionId))
                .orElseThrow(() -> new EntityNotFoundException("question not found: " + questionId));
        List<Product> products = productIds.stream().map(productRepository::findOne)
                .map(Optional::ofNullable)
                .map(o -> o.orElseThrow(() -> new EntityNotFoundException("product not found")))
                .collect(Collectors.toList());

        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setText(text);
        answer.setProducts(products);

        answerRepository.save(answer);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {

    }

    @Override
    @Transactional
    public void updateAnswer(Answer answer) {

    }

    @Override
    @Transactional
    public void deleteQuestion(long questionId) {
        questionRepository.delete(questionId);

    }

    @Override
    @Transactional
    public void deleteAnswer(long answerId) {
        answerRepository.delete(answerId);
    }
}
