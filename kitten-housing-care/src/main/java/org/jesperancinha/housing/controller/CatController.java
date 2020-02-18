package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CatDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cats")
public interface CatController {

    @GetMapping
    Flux<CatDto> getAllCats();

    @GetMapping("/full")
    Flux<CatDto> getFullAllCats();

    @GetMapping("/{catId}")
    Mono<CatDto> getCatByIdI(@PathVariable Long catId);

    @GetMapping("/full/{catId}")
    Mono<CatDto> getFullCatById(@PathVariable Long catId);
}
