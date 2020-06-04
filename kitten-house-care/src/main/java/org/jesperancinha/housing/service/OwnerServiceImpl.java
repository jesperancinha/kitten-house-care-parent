package org.jesperancinha.housing.service;

import org.jesperancinha.housing.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Mono<String> checkLiability(String name) {
        return ownerRepository.checkLiability(name);
    }

}
