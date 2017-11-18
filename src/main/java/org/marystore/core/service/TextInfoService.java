package org.marystore.core.service;

import org.marystore.core.domain.TextInfo;
import org.marystore.core.domain.TextInfoType;

public interface TextInfoService {

    TextInfo get(TextInfoType itemType);

    void update(TextInfo item);
}
