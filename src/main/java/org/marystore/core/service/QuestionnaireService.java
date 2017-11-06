package org.marystore.core.service;

import org.marystore.core.domain.Answer;
import org.marystore.core.domain.Question;

import java.util.List;

public interface QuestionnaireService {

    List<Question> getAllQuestions();

    Question getQuestionById(long id);

    Answer getAnswerById(long id);

    void createQuestion(String text, List<Answer> answers);

    void addAnswer(long questionId, Answer answer);

    void updateQuestion(Question question);

    void updateAnswer(Answer answer);

    void deleteQuestion(long questionId);

    void deleteAnswer(long answerId);

}
