package org.jesperancinha.housing.service;

import org.jesperancinha.housing.repository.OwnerRepositoryImpl;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OwnerServiceImpl {

    private final OwnerRepositoryImpl ownerRepository;

    public OwnerServiceImpl(OwnerRepositoryImpl ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Mono<String> checkLiability(String name) {
        return ownerRepository.checkLiability(name);
    }

}
