package org.jesperancinha.housing.repository;

import org.jesperancinha.housing.model.Cat;
import reactor.core.publisher.Mono;

public interface CatRepository {
    Mono<Cat> getCatById(Long id);
}
