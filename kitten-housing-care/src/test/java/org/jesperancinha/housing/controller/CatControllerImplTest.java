package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CareCenterDto;
import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.data.OwnerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CatControllerImplTest {

    final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CatControllerImpl catController;

    @LocalServerPort
    private int port;

    static {
        BlockHound.install();
    }

    @Test
    void getCatByIdI_whenCall_testBlocking() {
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
    void getFullCatById_whenCall_testBlocking() {
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

    @Test
    void getCatByIdI_whenCall_Ok() {
        final String uri = String.format("http://localhost:%d/cats/1", port);

        final CatDto catDto = restTemplate.getForObject(uri, CatDto.class);

        assertThat(catDto).isNotNull();
        assertThat(catDto.getName()).isEqualTo("Fluffy");
        assertThat(catDto.getColor()).isEqualTo("orange");
        assertThat(catDto.getSpecies()).isEqualTo("Katachtigen");
        assertThat(catDto.getAge()).isEqualTo(4L);
        assertThat(catDto.getFormerOwners()).isEmpty();
        assertThat(catDto.getCareCenters()).isEmpty();
    }

    @Test
    void getFullCatById_whenCall_FullOk() {
        final String uri = String.format("http://localhost:%d/cats/full/1", port);

        final CatDto catDto = restTemplate.getForObject(uri, CatDto.class);

        assertThat(catDto).isNotNull();
        assertThat(catDto.getName()).isEqualTo("Fluffy");
        assertThat(catDto.getColor()).isEqualTo("orange");
        assertThat(catDto.getSpecies()).isEqualTo("Katachtigen");
        assertThat(catDto.getAge()).isEqualTo(4L);
        final List<OwnerDto> formerOwners = catDto.getFormerOwners();
        assertThat(formerOwners).isNotEmpty();
        assertThat(formerOwners).hasSize(1);
        OwnerDto ownerDto = formerOwners.get(0);
        assertThat(ownerDto.getName()).isEqualTo("Dr. Michael");
        assertThat(ownerDto.getAddres()).isEqualTo("Eye of Sauron");
        final List<CareCenterDto> careCenters = catDto.getCareCenters();
        assertThat(careCenters).hasSize(1);
        final CareCenterDto careCenterDto = careCenters.get(0);
        assertThat(careCenterDto).isNotNull();
        assertThat(careCenterDto.getName()).isEqualTo("Nieuwegein Kitten Center");
        assertThat(careCenterDto.getAddress()).isEqualTo("Kittenstraat");
        assertThat(careCenterDto.getRefNumber()).isEqualTo("23ABC");
        assertThat(careCenterDto.getCity()).isEqualTo("Nieuwegein");
        assertThat(careCenterDto.getPostCode()).isEqualTo("9999CC");
        assertThat(careCenterDto.getCountry()).isEqualTo("Nederland");
    }
}