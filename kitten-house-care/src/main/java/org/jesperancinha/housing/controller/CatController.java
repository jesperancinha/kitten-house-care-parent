package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CatDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/cats")
public interface CatController {

    @GetMapping
    Flux<CatDto> getAllCats();

    @GetMapping("/{catId}")
    Mono<CatDto> getCatByIdI(
        @PathVariable
            Long catId);

    @GetMapping("/full/{catId}")
    Mono<CatDto> getFullCatById(
        @PathVariable
            Long catId);

    @GetMapping("/full")
    Flux<CatDto> getFullAllCats();

    @GetMapping("/fullForTest")
    Flux<CatDto> getFullAllCatsReactiveForTest();

    @GetMapping("/full/nonreactive")
    List<CatDto> getFullAllCatsNonReactive();

}
