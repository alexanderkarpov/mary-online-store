package org.marystore.core.controller;

import org.apache.commons.io.IOUtils;
import org.marystore.core.domain.CarouselItemType;
import org.marystore.core.domain.Category;
import org.marystore.core.dto.CarouselItemJson;
import org.marystore.core.exceptions.ServerErrorException;
import org.marystore.core.service.CarouselService;
import org.marystore.core.transformer.CarouselItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

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

    @RequestMapping(value = "/admin/carousel/questionnaire/file", method = RequestMethod.POST)
    public void updateQuestionnaireWithFile(@RequestPart("metadata") CarouselItemJson item,
                            @RequestPart("file") MultipartFile file) {
        updateItem(CarouselItemType.QUESTIONNAIRE, item, file);
    }

    @RequestMapping(value = "/admin/carousel/catalog/file", method = RequestMethod.POST)
    public void updateCatalogWithFile(@RequestPart("metadata") CarouselItemJson item,
                                    @RequestPart("file") MultipartFile file) {
        updateItem(CarouselItemType.CATALOG, item, file);
    }

    @RequestMapping(value = "/admin/carousel/warranty/file", method = RequestMethod.POST)
    public void updateWarrantyWithFile(@RequestPart("metadata") CarouselItemJson item,
                                    @RequestPart("file") MultipartFile file) {
        updateItem(CarouselItemType.WARRANTY, item, file);
    }

    @RequestMapping(value = "/admin/carousel/questionnaire", method = RequestMethod.POST)
    public void updateQuestionnaire(@RequestBody CarouselItemJson item) {
        updateItem(CarouselItemType.QUESTIONNAIRE, item, null);
    }

    @RequestMapping(value = "/admin/carousel/catalog", method = RequestMethod.POST)
    public void updateCatalog(@RequestBody CarouselItemJson item) {
        updateItem(CarouselItemType.CATALOG, item, null);
    }

    @RequestMapping(value = "/admin/carousel/warranty", method = RequestMethod.POST)
    public void updateWarranty(@RequestBody CarouselItemJson item) {
        updateItem(CarouselItemType.WARRANTY, item, null);
    }

    @RequestMapping(value = "/admin/carousel/{random}/questionnaire.jpg", method = RequestMethod.GET)
    public @ResponseBody byte[] getQuestionnaireImage(@PathVariable String random) throws IOException {
        return getImage(CarouselItemType.QUESTIONNAIRE);
    }

    @RequestMapping(value = "/admin/carousel/{random}/catalog.jpg", method = RequestMethod.GET)
    public @ResponseBody byte[] getCatalogImage(@PathVariable String random) throws IOException {
        return getImage(CarouselItemType.CATALOG);
    }

    @RequestMapping(value = "/admin/carousel/{random}/warranty.jpg", method = RequestMethod.GET)
    public @ResponseBody byte[] getWarrantyImage(@PathVariable String random) throws IOException {
        return getImage(CarouselItemType.WARRANTY);
    }

    private byte[] getImage(CarouselItemType type) throws IOException {
        String imgFile = carouselService.get(type).getImage();

        InputStream in = new FileInputStream(imgFile);
        return IOUtils.toByteArray(in);
    }

    private void updateItem(CarouselItemType type, CarouselItemJson item, MultipartFile file) {
        try {
            carouselService.update(type, item.getTitle(), item.getDescription(), file);
        } catch (IOException ex) {
            throw new ServerErrorException("Can't create category", ex);
        }
    }


}
