package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.service.OwnerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/owners")
public class OwnerControllerImpl {

    private final OwnerServiceImpl ownerService;

    public OwnerControllerImpl(OwnerServiceImpl ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("{address}")
    public Mono<String> checkLiability(
        @PathVariable(name = "address")
            String address) {
        return ownerService.checkLiability(address);
    }
}
