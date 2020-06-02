package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.Owner;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Owner owner1 = objectMapper.readValue(getClass().getResourceAsStream("/owner.json"), Owner.class);

    public OwnerRepositoryImpl() throws IOException {
    }

    @Override
    public Mono<Owner> getOwnerById(Long id) {
        return Mono.fromCallable(() -> owner1);
    }
}
