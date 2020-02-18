package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.Owner;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Owner getOwnerById(Long id) throws IOException {
        return objectMapper.readValue(getClass().getResourceAsStream("/owner.json"), Owner.class);
    }
}
