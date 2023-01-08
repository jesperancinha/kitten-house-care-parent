package org.jesperancinha.housing.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerRepositoryImplTest {
    private final OwnerRepositoryImpl ownerRepository = new OwnerRepositoryImpl(new ObjectMapper());

    OwnerRepositoryImplTest() throws IOException {
    }

    @Test
    void givenLiable_checkLiability_Ok() {
        Mono<String> deVeluwe = ownerRepository.checkLiability("De Veluwe");
        final String block = deVeluwe.block();
        assertThat(block).isEqualTo("OK");
    }

    @Test
    void givenNonLiable_checkLiability_NOk() {
        Mono<String> the_swamp = ownerRepository.checkLiability("The Swamp");
        final String block = the_swamp.block();
        assertThat(block).isEqualTo("NOK");
    }
}