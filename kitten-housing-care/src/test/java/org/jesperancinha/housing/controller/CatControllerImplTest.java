package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.repository.CatRepositoryImpl;
import org.jesperancinha.housing.service.CatServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CatControllerImplTest {

    @Autowired
    private CatControllerImpl catController;

    @Autowired
    private CatServiceImpl catService;

    @Autowired
    private CatRepositoryImpl catRepository;

    static {
        BlockHound.install();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCatByIdI() {
        assertThrows(Exception.class, () ->
                Mono.delay(Duration.ofMillis(1))
                        .doOnNext(it -> {
                            try {
                                catController.getCatByIdI(1L);
                            } catch (IOException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .block()
        );
    }
}