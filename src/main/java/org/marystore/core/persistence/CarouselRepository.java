package org.marystore.core.persistence;

import org.marystore.core.domain.CarouselItem;
import org.marystore.core.domain.CarouselItemType;
import org.springframework.data.repository.CrudRepository;

public interface CarouselRepository extends CrudRepository<CarouselItem, CarouselItemType> {
}
