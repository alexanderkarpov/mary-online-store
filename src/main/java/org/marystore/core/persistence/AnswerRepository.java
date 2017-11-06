package org.marystore.core.persistence;

import org.marystore.core.domain.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
}
