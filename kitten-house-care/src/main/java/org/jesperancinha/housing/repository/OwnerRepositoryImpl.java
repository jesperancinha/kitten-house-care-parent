package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.CareCenter;
import org.jesperancinha.housing.model.Owner;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

    private final Owner[] owners;

    public OwnerRepositoryImpl(ObjectMapper objectMapper) throws IOException {
        this.owners = objectMapper.readValue(getClass().getResourceAsStream("/owners.json"), Owner[].class);
    }

    @Override
    public Mono<Owner> getOwnerById(Long id) {
        return Mono.fromCallable(
            () -> Arrays.stream(owners).filter(owner -> owner.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public Mono<List<Owner>> getOwnersByIds(List<Long> formerOwners) {
        return Mono.fromCallable(() -> Arrays.stream(owners).filter(owner -> formerOwners.contains(owner.getId())).collect(
            Collectors.toList()));
    }
}
