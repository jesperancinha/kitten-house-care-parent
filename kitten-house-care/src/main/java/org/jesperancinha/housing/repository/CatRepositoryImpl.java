package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.Cat;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Repository
public class CatRepositoryImpl implements CatRepository {

    private ObjectMapper objectMapper = new ObjectMapper();

    private final Cat cat1 = objectMapper.readValue(getClass().getResourceAsStream("/cat1.json"), Cat.class);
    private final Cat cat2 = objectMapper.readValue(getClass().getResourceAsStream("/cat2.json"), Cat.class);

    public CatRepositoryImpl() throws IOException {
    }

    @Override
    public Mono<Cat> getCatById(Long id) {
        if (id.intValue() == 1L) {
            return Mono.fromCallable(() -> cat1);
        }
        return Mono.fromCallable(() -> cat2);
    }
}
