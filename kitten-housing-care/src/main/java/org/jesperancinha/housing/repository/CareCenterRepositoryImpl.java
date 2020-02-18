package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.CareCenter;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class CareCenterRepositoryImpl implements CareCenterRepository {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public CareCenter getCareCenterById(Long id) throws IOException {
        return objectMapper.readValue(getClass().getResourceAsStream("/carecenter.json"), CareCenter.class);
    }
}
