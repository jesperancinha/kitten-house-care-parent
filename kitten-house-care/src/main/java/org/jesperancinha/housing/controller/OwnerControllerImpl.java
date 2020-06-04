package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.service.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/owners")
public class OwnerControllerImpl implements OwnerController{

    private final OwnerService ownerService;

    public OwnerControllerImpl(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("{address}")
    public Mono<String> checkLiability(
        @PathVariable(name = "address")
            String address) {
        return ownerService.checkLiability(address);
    }
}
