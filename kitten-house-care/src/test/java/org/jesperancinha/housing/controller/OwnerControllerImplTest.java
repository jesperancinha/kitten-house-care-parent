package org.jesperancinha.housing.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class OwnerControllerImplTest {

    final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private OwnerControllerImpl ownerController;

    @LocalServerPort
    private int port;

    static {
        BlockHound.install();
    }

    @Test
    void checkLiability_whenCallPositive_nonBlocking() {
        Mono.delay(Duration.ofMillis(1))
            .doOnNext(it -> ownerController.checkLiability("De Veluwe"))
            .block();
    }

    @Test
    void checkLiability_whenCallNegative_nonBlocking() {
        Mono.delay(Duration.ofMillis(1))
            .doOnNext(it -> ownerController.checkLiability("The swamp"))
            .block();
    }

    @Test
    void checkLiabilityI_whenCallJoao_OK() {
        final String uri = String.format("http://localhost:%d/owners/De Veluwe", port);

        final String result = restTemplate.getForObject(uri, String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("OK");
    }

    @Test
    void checkLiabilityI_whenCallStromnelwan_NOK() {
        final String uri = String.format("http://localhost:%d/owners/The swamp", port);

        final String result = restTemplate.getForObject(uri, String.class);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("NOK");
    }
}