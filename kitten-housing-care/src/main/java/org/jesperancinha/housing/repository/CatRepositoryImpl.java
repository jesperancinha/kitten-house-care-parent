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
        if (id.intValue() == 1L) {
            return objectMapper.readValue(getClass().getResourceAsStream("/cat1.json"), Cat.class);
        }
        return objectMapper.readValue(getClass().getResourceAsStream("/cat2.json"), Cat.class);
    }
}
