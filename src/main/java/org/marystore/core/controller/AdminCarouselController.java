package org.marystore.core.controller;

import org.marystore.core.domain.CarouselItemType;
import org.marystore.core.dto.CarouselItemJson;
import org.marystore.core.exceptions.ServerErrorException;
import org.marystore.core.service.CarouselService;
import org.marystore.core.transformer.CarouselItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AdminCarouselController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CarouselItemTransformer transformer;

    @RequestMapping(value = "/admin/carousel/questionnaire", method = RequestMethod.GET)
    private CarouselItemJson getQuestionnaire() {
        return transformer.transform(carouselService.get(CarouselItemType.QUESTIONNAIRE));
    }

    @RequestMapping(value = "/admin/carousel/catalog", method = RequestMethod.GET)
    private CarouselItemJson getCatalog() {
        return transformer.transform(carouselService.get(CarouselItemType.CATALOG));
    }

    @RequestMapping(value = "/admin/carousel/warranty", method = RequestMethod.GET)
    private CarouselItemJson getWarranty() {
        return transformer.transform(carouselService.get(CarouselItemType.WARRANTY));
    }

    @RequestMapping(value = "/admin/carousel/questionnaire", method = RequestMethod.POST)
    public void updateQuestionnaire(@RequestPart("metadata") CarouselItemJson item,
                            @RequestPart("file") MultipartFile file) {
        updateItem(CarouselItemType.QUESTIONNAIRE, item, file);
    }

    @RequestMapping(value = "/admin/carousel/catalog", method = RequestMethod.POST)
    public void updateCatalog(@RequestPart("metadata") CarouselItemJson item,
                                    @RequestPart("file") MultipartFile file) {
        updateItem(CarouselItemType.CATALOG, item, file);
    }

    @RequestMapping(value = "/admin/carousel/warranty", method = RequestMethod.POST)
    public void updateWarranty(@RequestPart("metadata") CarouselItemJson item,
                                    @RequestPart("file") MultipartFile file) {
        updateItem(CarouselItemType.WARRANTY, item, file);
    }

    private void updateItem(CarouselItemType type, CarouselItemJson item, MultipartFile file) {
        try {
            carouselService.update(type, item.getTitle(), item.getDescription(), file);
        } catch (IOException ex) {
            throw new ServerErrorException("Can't create category", ex);
        }
    }


}
