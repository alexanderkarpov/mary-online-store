package org.marystore.core.transformer;

import org.marystore.core.domain.Answer;
import org.marystore.core.dto.AnswerJson;
import org.marystore.core.dto.ProductLiteJson;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AnswerTransformer {

    public AnswerJson transform(Answer src) {
        return AnswerJson.of(src.getId(), src.getText(),
                src.getProducts().stream().map(p -> ProductLiteJson.of(p.getId(), p.getCode()))
                        .collect(Collectors.toList()));

    }

}
