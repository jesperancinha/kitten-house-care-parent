package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.service.CatServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatControllerImpl {

    private final CatServiceImpl catService;

    public CatControllerImpl(CatServiceImpl catService) {
        this.catService = catService;
    }

    @org.springframework.web.bind.annotation.GetMapping
    public Flux<CatDto> getAllCats() {
        return this.catService.getAllCats();
    }

    @org.springframework.web.bind.annotation.GetMapping("/{catId}")
    public Mono<CatDto> getCatByIdI(@org.springframework.web.bind.annotation.PathVariable Long catId) {
        return this.catService.getCatById(catId);
    }

    @org.springframework.web.bind.annotation.GetMapping("/full/{catId}")
    public Mono<CatDto> getFullCatById(@org.springframework.web.bind.annotation.PathVariable Long catId) {
        return this.catService.getFullCatById(catId);
    }

    @org.springframework.web.bind.annotation.GetMapping("/full")
    public Flux<CatDto> getFullAllCats() {
        return this.catService.getFullAllCats();
    }

    @org.springframework.web.bind.annotation.GetMapping("/fullForTest")
    public Flux<CatDto> getFullAllCatsReactiveForTest() {
        return this.catService.getFullAllCats().map(catDto -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return catDto;
        });
    }

    @org.springframework.web.bind.annotation.GetMapping("/full/nonreactive")
    public List<CatDto> getFullAllCatsNonReactive() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.catService.getFullAllCatsNonReactive();
    }
}
