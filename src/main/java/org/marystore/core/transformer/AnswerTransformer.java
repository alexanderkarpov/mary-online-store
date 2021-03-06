package org.marystore.core.transformer;

import org.marystore.core.domain.Answer;
import org.marystore.core.dto.AnswerJson;
import org.marystore.core.dto.ProductLiteJson;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AnswerTransformer {

    public AnswerJson transform(Answer src) {
        return AnswerJson.builder()
                .id(src.getId())
                .text(src.getText())
                .products(src.getProducts().stream().map(p -> ProductLiteJson.builder()
                        .id(p.getId())
                        .code(p.getCode())
                        .title(p.getTitle())
                        .build())
                        .collect(Collectors.toList()))
                .build();
    }

}
