package org.marystore.core.service;

import org.marystore.core.domain.TextInfo;
import org.marystore.core.domain.TextInfoType;
import org.marystore.core.persistence.TextInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class TextInfoServiceImpl implements TextInfoService {

    @Autowired
    private TextInfoRepository textInfoRepository;

    @PostConstruct
    public void init() {

        Arrays.stream(TextInfoType.values())
                .filter(t -> textInfoRepository.findOne(t) == null)
                .forEach(t -> {
                    TextInfo item = new TextInfo();
                    item.setId(t);
                    item.setText("Welcome to our site!");

                    textInfoRepository.save(item);
                });
    }

    @Override
    public TextInfo get(TextInfoType itemType) {
        return textInfoRepository.findOne(itemType);
    }

    @Override
    public void update(TextInfo item) {
        textInfoRepository.save(item);
    }
}
