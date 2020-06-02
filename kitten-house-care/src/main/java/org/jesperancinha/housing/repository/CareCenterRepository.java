package org.jesperancinha.housing.repository;

import org.jesperancinha.housing.model.CareCenter;
import reactor.core.publisher.Mono;

public interface CareCenterRepository {
    Mono<CareCenter> getCareCenterById(Long id);
}
