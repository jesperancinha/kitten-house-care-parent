package org.jesperancinha.housing.controller

import org.jesperancinha.housing.dto.CatDto
import org.jesperancinha.housing.service.CatService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@RestController
@RequestMapping("/cats")
class CatControllerImpl(private val catService: CatService) {
    @GetMapping
    fun allCats(): Flux<CatDto> = catService.allCats()

    @GetMapping("/{catId}")
    suspend fun getCatByIdI(@PathVariable catId: Long)= catService.getCatById(catId)

    @GetMapping("/full/{catId}")
    fun getFullCatById(@PathVariable catId: Long): Mono<CatDto> = catService.getFullCatById(catId)

    @GetMapping("/full")
    fun fullAllCats(): Flux<CatDto> = catService.fullAllCats()

    @GetMapping("/fullForTest")
    fun fullAllCatsReactiveForTest(): Flux<CatDto> = catService.fullAllCats().publishOn(Schedulers.boundedElastic())
        .map { catDto -> Thread.sleep(1)
        catDto
    }

    @GetMapping("/full/nonreactive")
    fun fullAllCatsNonReactive(): List<CatDto> = run {
        Thread.sleep(1)
        catService.fullAllCatsNonReactive()
    }
}