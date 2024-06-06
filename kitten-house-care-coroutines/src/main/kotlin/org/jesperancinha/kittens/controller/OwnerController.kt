package org.jesperancinha.kittens.controller

import org.jesperancinha.kittens.service.OwnerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/owners")
class OwnerController(private val ownerService: OwnerService) {
    @GetMapping("{address}")
    fun checkLiability(@PathVariable(name = "address") address: String): Mono<String> =
        ownerService.checkLiability(address)
}