package org.jesperancinha.housing.repository;

import org.jesperancinha.housing.model.Owner;
import reactor.core.publisher.Mono;

public interface OwnerRepository {
    Mono<Owner> getOwnerById(Long id);
}
