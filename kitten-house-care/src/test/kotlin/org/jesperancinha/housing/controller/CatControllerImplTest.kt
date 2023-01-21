package org.jesperancinha.housing.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Mono
import java.time.Duration


@SpringBootTest
class CatControllerImplTest @Autowired constructor(
    val ownerController: OwnerController
) {

    @Test
    fun checkLiability_whenCallPositive_nonBlocking() {
        Mono.delay(Duration.ofMillis(1))
            .doOnNext { ownerController.checkLiability("De Veluwe") }
            .block()
    }

    @Test
    fun checkLiability_whenCallNegative_nonBlocking() {
        Mono.delay(Duration.ofMillis(1))
            .doOnNext { ownerController.checkLiability("The swamp") }
            .block()
    }

}