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
        Mono.delay(Duration.ofMillis(1))
                .doOnNext(it -> {
                    try {
                        catController.getCatByIdI(1L);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .block();
    }

    @Test
    void getFullCatById_whenCall_testBlocking() {
        Mono.delay(Duration.ofMillis(1))
                .doOnNext(it -> {
                    try {
                        catController.getFullCatById(1L);
                    } catch (IOException | ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .block();
    }

    @Test
    void getAllCats_whenCall_testBlocking() {
        Mono.delay(Duration.ofMillis(1))
                .doOnNext(it -> {
                    try {
                        catController.getAllCats();
                    } catch (ExecutionException | InterruptedException | IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .block();
    }

    @Test
    void getFullAllCats_whenCall_testBlocking() {
        Mono.delay(Duration.ofMillis(1))
                .doOnNext(it -> {
                    try {
                        catController.getFullAllCats();
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .block();
    }

    @Test
    void getCatByIdI_whenCall_Ok() {
        final String uri = String.format("http://localhost:%d/cats/1", port);

        final CatDto catDto = restTemplate.getForObject(uri, CatDto.class);

        assertThat(catDto).isNotNull();
        assertThat(catDto.getName()).isEqualTo("Bocco");
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
        assertThat(catDto.getName()).isEqualTo("Bocco");
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

    @Test
    void getAll_whenCall_Ok() {
        final String uri = String.format("http://localhost:%d/cats", port);

        final CatDto[] catDtos = restTemplate.getForObject(uri, CatDto[].class);

        assertThat(catDtos).isNotNull();
        final CatDto catDto1 = catDtos[0];
        assertThat(catDto1).isNotNull();
        assertThat(catDto1.getName()).isEqualTo("Bocco");
        assertThat(catDto1.getColor()).isEqualTo("orange");
        assertThat(catDto1.getSpecies()).isEqualTo("Katachtigen");
        assertThat(catDto1.getAge()).isEqualTo(4L);
        final List<OwnerDto> formerOwners = catDto1.getFormerOwners();
        assertThat(formerOwners).isEmpty();
        final List<CareCenterDto> careCenters = catDto1.getCareCenters();
        assertThat(careCenters).isEmpty();

        CatDto catDto2 = catDtos[1];
        assertThat(catDto2).isNotNull();
        assertThat(catDto2.getName()).isEqualTo("Zuu");
        assertThat(catDto2.getColor()).isEqualTo("black and white");
        assertThat(catDto2.getSpecies()).isEqualTo("Katachtigen");
        assertThat(catDto2.getAge()).isEqualTo(9L);
        final List<OwnerDto> formerOwners2 = catDto2.getFormerOwners();
        assertThat(formerOwners2).isEmpty();
        final List<CareCenterDto> careCenters2 = catDto2.getCareCenters();
        assertThat(careCenters2).isEmpty();
    }

    @Test
    void getFullAll_whenCall_FullOk() {
        final String uri = String.format("http://localhost:%d/cats/full", port);

        final CatDto[] catDtos = restTemplate.getForObject(uri, CatDto[].class);

        assertThat(catDtos).isNotNull();
        final CatDto catDto1 = catDtos[0];
        assertThat(catDto1).isNotNull();
        assertThat(catDto1.getName()).isEqualTo("Bocco");
        assertThat(catDto1.getColor()).isEqualTo("orange");
        assertThat(catDto1.getSpecies()).isEqualTo("Katachtigen");
        assertThat(catDto1.getAge()).isEqualTo(4L);
        final List<OwnerDto> formerOwners = catDto1.getFormerOwners();
        assertThat(formerOwners).isNotEmpty();
        assertThat(formerOwners).hasSize(1);
        OwnerDto ownerDto = formerOwners.get(0);
        assertThat(ownerDto.getName()).isEqualTo("Dr. Michael");
        assertThat(ownerDto.getAddres()).isEqualTo("Eye of Sauron");
        final List<CareCenterDto> careCenters = catDto1.getCareCenters();
        assertThat(careCenters).hasSize(1);
        final CareCenterDto careCenterDto = careCenters.get(0);
        assertThat(careCenterDto).isNotNull();
        assertThat(careCenterDto.getName()).isEqualTo("Nieuwegein Kitten Center");
        assertThat(careCenterDto.getAddress()).isEqualTo("Kittenstraat");
        assertThat(careCenterDto.getRefNumber()).isEqualTo("23ABC");
        assertThat(careCenterDto.getCity()).isEqualTo("Nieuwegein");
        assertThat(careCenterDto.getPostCode()).isEqualTo("9999CC");
        assertThat(careCenterDto.getCountry()).isEqualTo("Nederland");

        CatDto catDto2 = catDtos[1];
        assertThat(catDto2).isNotNull();
        assertThat(catDto2.getName()).isEqualTo("Zuu");
        assertThat(catDto2.getColor()).isEqualTo("black and white");
        assertThat(catDto2.getSpecies()).isEqualTo("Katachtigen");
        assertThat(catDto2.getAge()).isEqualTo(9L);
        final List<OwnerDto> formerOwners2 = catDto2.getFormerOwners();
        assertThat(formerOwners2).isNotEmpty();
        assertThat(formerOwners2).hasSize(1);
        OwnerDto ownerDto2 = formerOwners2.get(0);
        assertThat(ownerDto2.getName()).isEqualTo("Dr. Michael");
        assertThat(ownerDto2.getAddres()).isEqualTo("Eye of Sauron");
        final List<CareCenterDto> careCenters2 = catDto2.getCareCenters();
        assertThat(careCenters2).hasSize(1);
        final CareCenterDto careCenterDto2 = careCenters2.get(0);
        assertThat(careCenterDto2).isNotNull();
        assertThat(careCenterDto2.getName()).isEqualTo("Nieuwegein Kitten Center");
        assertThat(careCenterDto2.getAddress()).isEqualTo("Kittenstraat");
        assertThat(careCenterDto2.getRefNumber()).isEqualTo("23ABC");
        assertThat(careCenterDto2.getCity()).isEqualTo("Nieuwegein");
        assertThat(careCenterDto2.getPostCode()).isEqualTo("9999CC");
        assertThat(careCenterDto2.getCountry()).isEqualTo("Nederland");
    }
}