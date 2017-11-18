package org.marystore.core.service;

import org.marystore.core.domain.CarouselItem;
import org.marystore.core.domain.CarouselItemType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CarouselService {

    CarouselItem get(CarouselItemType itemType);

    void update(CarouselItemType id, String title, String description, MultipartFile file) throws IOException;
}
