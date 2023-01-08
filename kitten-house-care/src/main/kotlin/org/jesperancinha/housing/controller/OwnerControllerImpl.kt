package org.jesperancinha.housing.controller

import org.jesperancinha.housing.service.OwnerServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/owners")
class OwnerControllerImpl(private val ownerService: OwnerServiceImpl) {
    @GetMapping("{address}")
    fun checkLiability(
        @PathVariable(name = "address") address: String?
    ): Mono<String?>? {
        return ownerService.checkLiability(address)
    }
}