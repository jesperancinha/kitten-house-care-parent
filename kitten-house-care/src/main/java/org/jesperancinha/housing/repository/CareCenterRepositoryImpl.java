package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.CareCenter;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CareCenterRepositoryImpl implements CareCenterRepository {

    private final CareCenter[] careCenters;

    public CareCenterRepositoryImpl(ObjectMapper objectMapper) throws IOException {
        this.careCenters = objectMapper
            .readValue(getClass().getResourceAsStream("/carecenters.json"), CareCenter[].class);

    }

    @Override
    public Mono<CareCenter> getCareCenterById(Long id) {
        return Mono.fromCallable(
            () -> Arrays.stream(careCenters).filter(careCenter -> careCenter.getId().equals(id)).findFirst()
                .orElse(null));
    }

    @Override
    public Mono<List<CareCenter>> getCareCentersByIds(List<Long> careCenteIds) {
        return Mono.fromCallable(
            () -> getCareCenters(careCenteIds));
    }

    @Override
    public List<CareCenter> getCareCentersByIdsNonReactive(List<Long> careCenters) {
        return getCareCenters(careCenters);
    }

    private List<CareCenter> getCareCenters(List<Long> careCenteIds) {
        return Arrays.stream(careCenters)
            .filter(careCenter -> careCenteIds.contains(careCenter.getId()))
            .collect(Collectors.toList());
    }
}
