package org.jesperancinha.housing.repository;

import org.jesperancinha.housing.model.Owner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OwnerRepository {
    Mono<Owner> getOwnerById(Long id);
    Mono<List<Owner>> getOwnersByIds(List<Long> formerOwners);
    Mono<String> checkLiability(String address);
}
