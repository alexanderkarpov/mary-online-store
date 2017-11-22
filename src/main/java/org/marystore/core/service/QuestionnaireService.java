package org.marystore.core.service;

import org.marystore.core.domain.Answer;
import org.marystore.core.domain.Question;

import java.util.List;

public interface QuestionnaireService {

    List<Question> getAllQuestions();

    List<Answer> getAnswersByQuestionId(long questionId);

    Question getQuestionById(long id);

    Answer getAnswerById(long id);

    void createQuestion(String text);

    void createAnswer(long questionId, String text, List<Long> productIds);

    void updateAnswer(long answerId, String text, List<Long> productIds);

    void updateQuestion(long questionId, String text);

    void deleteQuestion(long questionId);

    void deleteAnswer(long answerId);

}
