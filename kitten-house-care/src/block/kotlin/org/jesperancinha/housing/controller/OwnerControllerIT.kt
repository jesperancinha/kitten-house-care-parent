package org.jesperancinha.housing.controller

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.client.RestTemplate
import reactor.blockhound.BlockHound

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
internal class OwnerControllerIT @Autowired constructor(
    val ownerController: OwnerController
) {
    val restTemplate = RestTemplate()

    @LocalServerPort
    private val port = 0

    @Test
    fun checkLiabilityI_whenCallJoao_OK() {
        val uri = String.format("http://localhost:%d/owners/De Veluwe", port)
        val result = restTemplate.getForObject(uri, String::class.java)
        result.shouldNotBeNull()
        result shouldBe "OK"
    }

    @Test
    fun checkLiabilityI_whenCallStromnelwan_NOK() {
        val uri = String.format("http://localhost:%d/owners/The swamp", port)
        val result = restTemplate.getForObject(uri, String::class.java)
        result.shouldNotBeNull()
        result shouldBe "NOK"
    }

    companion object {
        init {
            BlockHound.install()
        }
    }
}