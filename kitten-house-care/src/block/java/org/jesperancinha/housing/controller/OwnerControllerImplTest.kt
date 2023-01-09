package org.jesperancinha.housing.controller

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.client.RestTemplate
import reactor.blockhound.BlockHound
import reactor.core.publisher.Mono
import java.time.Duration

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
internal class OwnerControllerImplTest @Autowired constructor(
    val ownerController: OwnerControllerImpl
) {
    val restTemplate = RestTemplate()

    @LocalServerPort
    private val port = 0
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

    @Test
    fun checkLiabilityI_whenCallJoao_OK() {
        val uri = String.format("http://localhost:%d/owners/De Veluwe", port)
        val result = restTemplate.getForObject(uri, String::class.java)
        Assertions.assertThat(result).isNotNull
        Assertions.assertThat(result).isEqualTo("OK")
    }

    @Test
    fun checkLiabilityI_whenCallStromnelwan_NOK() {
        val uri = String.format("http://localhost:%d/owners/The swamp", port)
        val result = restTemplate.getForObject(uri, String::class.java)
        Assertions.assertThat(result).isNotNull
        Assertions.assertThat(result).isEqualTo("NOK")
    }

    companion object {
        init {
            BlockHound.install()
        }
    }
}