package org.marystore.core.transformer;

import org.marystore.core.domain.CarouselItem;
import org.marystore.core.dto.CarouselItemJson;
import org.springframework.stereotype.Component;

@Component
public class CarouselItemTransformer {

    public CarouselItemJson transform(CarouselItem item) {
        return new CarouselItemJson(item.getTitle(), item.getDescription(), item.getImage());
    }

}
