package org.jesperancinha.housing.service;

import org.jesperancinha.housing.data.CatDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CatService {
    Mono<CatDto> getCatById(Long id);

    Mono<CatDto> getFullCatById(Long id);

    Flux<CatDto> getFullAllCats();

    Flux<CatDto> getAllCats();

    List<CatDto> getFullAllCatsNonReactive();
}
