package org.jesperancinha.housing.controller

import org.jesperancinha.housing.data.CatDto
import org.jesperancinha.housing.service.CatServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/cats")
class CatControllerImpl(private val catService: CatServiceImpl) {
    @get:GetMapping
    val allCats: Flux<CatDto?>?
        get() = catService.allCats

    @GetMapping("/{catId}")
    fun getCatByIdI(@PathVariable catId: Long): Mono<CatDto?>? {
        return catService.getCatById(catId)
    }

    @GetMapping("/full/{catId}")
    fun getFullCatById(@PathVariable catId: Long): Mono<CatDto?>? {
        return catService.getFullCatById(catId)
    }

    @get:GetMapping("/full")
    val fullAllCats: Flux<CatDto?>?
        get() = catService.fullAllCats

    @get:GetMapping("/fullForTest")
    val fullAllCatsReactiveForTest: Flux<CatDto?>
        get() = catService.fullAllCats.map { catDto: CatDto? ->
            try {
                Thread.sleep(1)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            catDto
        }

    @get:GetMapping("/full/nonreactive")
    val fullAllCatsNonReactive: List<CatDto?>?
        get() {
            try {
                Thread.sleep(1)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return catService.fullAllCatsNonReactive
        }
}