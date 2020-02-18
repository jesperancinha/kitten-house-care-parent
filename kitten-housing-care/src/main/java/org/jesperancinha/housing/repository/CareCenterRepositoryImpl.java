package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.CareCenter;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Repository
public class CareCenterRepositoryImpl implements CareCenterRepository {

    private ObjectMapper objectMapper = new ObjectMapper();
    private CareCenter careCenter = objectMapper.readValue(getClass().getResourceAsStream("/carecenter.json"), CareCenter.class);

    public CareCenterRepositoryImpl() throws IOException {
    }

    @Override
    public Mono<CareCenter> getCareCenterById(Long id) {
        return Mono.fromCallable(() -> careCenter);
    }
}
