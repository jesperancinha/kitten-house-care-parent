package org.jesperancinha.housing.repository;

import org.jesperancinha.housing.model.CareCenter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CareCenterRepository {
    Mono<CareCenter> getCareCenterById(Long id);

    Mono<List<CareCenter>> getCareCentersByIds(List<Long> careCenters);
}
