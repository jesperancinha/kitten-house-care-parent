package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.Cat;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class CatRepositoryImpl implements CatRepository {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Cat getCatById(Long id) throws IOException {
        return objectMapper.readValue(getClass().getResourceAsStream("/cat.json"), Cat.class);
    }
}
