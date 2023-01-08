package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.housing.model.Cat;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Repository
public class CatRepositoryImpl {

    private final Cat cat1;
    private final Cat cat2;

    public CatRepositoryImpl(ObjectMapper objectMapper) throws IOException {
        this.cat1 = objectMapper.readValue(getClass().getResourceAsStream("/cat1.json"), Cat.class);
        this.cat2 = objectMapper.readValue(getClass().getResourceAsStream("/cat2.json"), Cat.class);
    }

    public Mono<Cat> getCatById(Long id) {
        return Mono.fromCallable(() -> getCat(id));
    }

    public Cat getCatByIdNonReactive(Long id) {
        return getCat(id);
    }

    private Cat getCat(Long id) {
        if (id.intValue() == 1L) {
            return cat1;
        }
        if (id.intValue() == 2L) {
            return cat2;
        }
        return null;
    }
}
