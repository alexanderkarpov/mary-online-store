package org.marystore.core.persistence;

import org.marystore.core.domain.TextInfo;
import org.marystore.core.domain.TextInfoType;
import org.springframework.data.repository.CrudRepository;

public interface TextInfoRepository extends CrudRepository<TextInfo, TextInfoType> {
}
