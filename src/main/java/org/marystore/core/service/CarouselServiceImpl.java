package org.marystore.core.service;

import org.marystore.core.domain.CarouselItem;
import org.marystore.core.domain.CarouselItemType;
import org.marystore.core.persistence.CarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.StreamSupport;

@Component
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselRepository carouselRepository;

    @Autowired
    private ImageNameService imageNameService;

    @PostConstruct
    public void init() {

        Arrays.stream(CarouselItemType.values())
                .filter(t -> carouselRepository.findOne(t) == null)
                .forEach(t -> {
                    CarouselItem item = new CarouselItem();
                    item.setId(t);
                    item.setTitle(t.name());
                    item.setDescription("");
                    item.setImage("noimage.jpg");

                    carouselRepository.save(item);
                });
    }

    @Override
    public CarouselItem get(CarouselItemType itemType) {
        return carouselRepository.findOne(itemType);
    }

    @Override
    public void update(CarouselItemType id, String title, String description,
                       MultipartFile file) throws IOException {
        String fileName = imageNameService.getNextName(file.getOriginalFilename());
        byte[] fileBytes = file.getBytes();
        File imageFile = new File(fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            bufferedOutputStream.write(fileBytes);
            bufferedOutputStream.flush();
        }

        CarouselItem item = new CarouselItem();
        item.setId(id);
        item.setTitle(title);
        item.setDescription(description);
        item.setImage(imageFile.getPath());

        carouselRepository.save(item);
    }
}
