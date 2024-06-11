package org.jesperancinha.kittens.controller

import org.jesperancinha.kittens.dto.CatDto
import org.jesperancinha.kittens.service.CatService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.util.concurrent.Flow

@RestController
@RequestMapping("/cats")
class CatControllerImpl(private val catService: CatService) {
    @GetMapping
    fun allCats(): List<CatDto> = catService.allCats()

    @GetMapping("/{catId}")
    suspend fun getCatByIdI(@PathVariable catId: Long)= catService.getCatById(catId)

    @GetMapping("/full/{catId}")
   suspend fun getFullCatById(@PathVariable catId: Long)= catService.getFullCatById(catId)

    @GetMapping("/full")
    fun fullAllCats(): List<CatDto> = catService.fullAllCats()

    @GetMapping("/fullForTest")
    fun fullAllCatsReactiveForTest(): List<CatDto> = catService.fullAllCats()

    @GetMapping("/full/nonreactive")
    fun fullAllCatsNonReactive(): List<CatDto> = run {
        Thread.sleep(1)
        catService.fullAllCatsNonReactive()
    }
}