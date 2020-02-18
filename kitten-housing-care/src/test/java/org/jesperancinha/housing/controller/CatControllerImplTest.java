package org.jesperancinha.housing.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CatControllerImplTest {

    @Autowired
    private CatControllerImpl catController;

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
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .block()
        );
    }

    @Test
    void getFullCatById() {
        assertThrows(Exception.class, () ->
                Mono.delay(Duration.ofMillis(1))
                        .doOnNext(it -> {
                            try {
                                catController.getFullCatById(1L);
                            } catch (IOException | ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .block()
        );
    }
}