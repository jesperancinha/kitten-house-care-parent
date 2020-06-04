package org.jesperancinha.housing.service;

import reactor.core.publisher.Mono;

public interface OwnerService {
    Mono<String> checkLiability(String name);
}
