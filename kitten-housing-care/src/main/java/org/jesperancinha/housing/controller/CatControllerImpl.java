package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.service.CatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cats")
public class CatControllerImpl implements CatController {

    private final CatService catService;

    public CatControllerImpl(CatService catService) {
        this.catService = catService;
    }

    public Flux<CatDto> getAllCats() {
        return this.catService.getAllCats();
    }

    public Flux<CatDto> getFullAllCats() {
        return this.catService.getFullAllCats();
    }

    public Mono<CatDto> getCatByIdI(Long catId) {
        return this.catService.getCatById(catId);
    }

    public Mono<CatDto> getFullCatById(Long catId) {
        return this.catService.getFullCatById(catId);
    }
}
