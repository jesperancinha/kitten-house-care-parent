package org.jesperancinha.housing.controller

import org.assertj.core.api.Assertions
import org.jesperancinha.housing.dto.CareCenterDto
import org.jesperancinha.housing.dto.CatDto
import org.jesperancinha.housing.dto.OwnerDto
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
import java.util.*

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
internal class CatControllerImplTest {
    val restTemplate = RestTemplate()

    @Autowired
    private val catController: CatControllerImpl? = null

    @LocalServerPort
    private val port = 0

    @get:Test
    val catByIdI_whenCall_nonBlocking: Unit
        get() {
            Mono.delay(Duration.ofMillis(1))
                .doOnNext { it: Long? -> catController!!.getCatByIdI(1L) }
                .block()
        }

    @get:Test
    val fullCatById_whenCall_nonBlocking: Unit
        get() {
            Mono.delay(Duration.ofMillis(1))
                .doOnNext { it: Long? -> catController!!.getFullCatById(1L) }
                .block()
        }

    @get:Test
    val allCats_whenCall_nonBlocking: Unit
        get() {
            Mono.delay(Duration.ofMillis(1))
                .doOnNext { it: Long? -> catController!!.allCats }
                .block()
        }

    @get:Test
    val fullAllCats_whenCall_nonBlocking: Unit
        get() {
            Mono.delay(Duration.ofMillis(1))
                .doOnNext { it: Long? -> catController!!.fullAllCats }
                .block()
        }

    @get:Test
    val fullAllCatsNonReaciveForTest_whenCall_Blocking: Unit
        get() {
            Mono.delay(Duration.ofMillis(1))
                .doOnNext { it: Long? -> catController!!.fullAllCatsReactiveForTest }
                .block()
        }

    @get:Test
    val fullAllCatsNonReacive_whenCall_Blocking: Unit
        get() {
            Assertions.assertThatExceptionOfType(Exception::class.java).isThrownBy {
                Mono.delay(Duration.ofMillis(1))
                    .doOnNext { it: Long? -> catController!!.fullAllCatsNonReactive }
                    .block()
            }
        }

    @get:Test
    val catByIdI_whenCall_Ok: Unit
        get() {
            val uri = String.format("http://localhost:%d/cats/1", port)
            val catDto = restTemplate.getForObject(uri, CatDto::class.java)
            Assertions.assertThat(catDto).isNotNull
            Assertions.assertThat(catDto.name).isEqualTo("Lania")
            Assertions.assertThat(catDto.color).isEqualTo("orange")
            Assertions.assertThat(catDto.species).isEqualTo("Katachtigen")
            Assertions.assertThat(catDto.age).isEqualTo(4L)
            Assertions.assertThat(catDto.formerOwners).isEmpty()
            Assertions.assertThat(catDto.careCenters).isEmpty()
        }

    @get:Test
    val fullCatById_whenCall_FullOk: Unit
        get() {
            val uri = String.format("http://localhost:%d/cats/full/1", port)
            val catDto = restTemplate.getForObject(uri, CatDto::class.java)
            Assertions.assertThat(catDto).isNotNull
            Assertions.assertThat(catDto.name).isEqualTo("Lania")
            Assertions.assertThat(catDto.color).isEqualTo("orange")
            Assertions.assertThat(catDto.species).isEqualTo("Katachtigen")
            Assertions.assertThat(catDto.age).isEqualTo(4L)
            val formerOwners: List<OwnerDto> = catDto.formerOwners
            Assertions.assertThat(formerOwners).isNotEmpty
            Assertions.assertThat(formerOwners).hasSize(1)
            val ownerDto = formerOwners[0]
            Assertions.assertThat(ownerDto.name).isEqualTo("Eng. João Esperancinha")
            assertThat(ownerDto.getAddres()).isEqualTo("De Veluwe")
            val careCenters: List<CareCenterDto> = catDto.careCenters
            Assertions.assertThat(careCenters).hasSize(1)
            val careCenterDto = careCenters[0]
            Assertions.assertThat(careCenterDto).isNotNull
            assertThat(careCenterDto.getName()).isEqualTo("Nieuwegein Kitten Center")
            assertThat(careCenterDto.getAddress()).isEqualTo("Kittenstraat")
            assertThat(careCenterDto.getRefNumber()).isEqualTo("23ABC")
            assertThat(careCenterDto.getCity()).isEqualTo("Nieuwegein")
            assertThat(careCenterDto.getPostCode()).isEqualTo("9999CC")
            assertThat(careCenterDto.getCountry()).isEqualTo("Nederland")
        }

    @get:Test
    val all_whenCall_Ok: Unit
        get() {
            val uri = String.format("http://localhost:%d/cats", port)
            val catDtos: Array<CatDto?> = restTemplate.getForObject(uri, Array<CatDto>::class.java)
            Assertions.assertThat(catDtos).isNotNull
            val catDto1 = Arrays.stream(catDtos)
                .filter { catDto: CatDto? ->
                    (catDto!!.name
                            == "Lania")
                }
                .findFirst()
                .orElse(null)
            Assertions.assertThat(catDto1).isNotNull
            Assertions.assertThat(catDto1!!.name).isEqualTo("Lania")
            Assertions.assertThat(catDto1.color).isEqualTo("orange")
            Assertions.assertThat(catDto1.species).isEqualTo("Katachtigen")
            Assertions.assertThat(catDto1.age).isEqualTo(4L)
            val formerOwners: List<OwnerDto> = catDto1.formerOwners
            Assertions.assertThat(formerOwners).isEmpty()
            val careCenters: List<CareCenterDto> = catDto1.careCenters
            Assertions.assertThat(careCenters).isEmpty()
            val catDto2 = Arrays.stream(catDtos)
                .filter { catDto: CatDto? ->
                    (catDto!!.name
                            == "Mit")
                }
                .findFirst()
                .orElse(null)
            Assertions.assertThat(catDto2).isNotNull
            Assertions.assertThat(catDto2!!.name).isEqualTo("Mit")
            Assertions.assertThat(catDto2.color).isEqualTo("black and white")
            Assertions.assertThat(catDto2.species).isEqualTo("Katachtigen")
            Assertions.assertThat(catDto2.age).isEqualTo(9L)
            val formerOwners2: List<OwnerDto> = catDto2.formerOwners
            Assertions.assertThat(formerOwners2).isEmpty()
            val careCenters2: List<CareCenterDto> = catDto2.careCenters
            Assertions.assertThat(careCenters2).isEmpty()
        }

    @get:Test
    val fullAll_whenCall_FullOk: Unit
        get() {
            val uri = String.format("http://localhost:%d/cats/full", port)
            val catDtos: Array<CatDto?> = restTemplate.getForObject(uri, Array<CatDto>::class.java)
            Assertions.assertThat(catDtos).isNotNull
            val catDto1 = Arrays.stream(catDtos)
                .filter { catDto: CatDto? ->
                    (catDto!!.name
                            == "Lania")
                }
                .findFirst()
                .orElse(null)
            Assertions.assertThat(catDto1).isNotNull
            Assertions.assertThat(catDto1!!.name).isEqualTo("Lania")
            Assertions.assertThat(catDto1.color).isEqualTo("orange")
            Assertions.assertThat(catDto1.species).isEqualTo("Katachtigen")
            Assertions.assertThat(catDto1.age).isEqualTo(4L)
            val formerOwners: List<OwnerDto> = catDto1.formerOwners
            Assertions.assertThat(formerOwners).isNotEmpty
            Assertions.assertThat(formerOwners).hasSize(1)
            val ownerDto = formerOwners[0]
            Assertions.assertThat(ownerDto.name).isEqualTo("Eng. João Esperancinha")
            assertThat(ownerDto.getAddres()).isEqualTo("De Veluwe")
            val careCenters: List<CareCenterDto> = catDto1.careCenters
            Assertions.assertThat(careCenters).hasSize(1)
            val careCenterDto = careCenters[0]
            Assertions.assertThat(careCenterDto).isNotNull
            assertThat(careCenterDto.getName()).isEqualTo("Nieuwegein Kitten Center")
            assertThat(careCenterDto.getAddress()).isEqualTo("Kittenstraat")
            assertThat(careCenterDto.getRefNumber()).isEqualTo("23ABC")
            assertThat(careCenterDto.getCity()).isEqualTo("Nieuwegein")
            assertThat(careCenterDto.getPostCode()).isEqualTo("9999CC")
            assertThat(careCenterDto.getCountry()).isEqualTo("Nederland")
            val catDto2 = Arrays.stream(catDtos)
                .filter { catDto: CatDto? ->
                    (catDto!!.name
                            == "Mit")
                }
                .findFirst()
                .orElse(null)
            Assertions.assertThat(catDto2).isNotNull
            Assertions.assertThat(catDto2!!.name).isEqualTo("Mit")
            Assertions.assertThat(catDto2.color).isEqualTo("black and white")
            Assertions.assertThat(catDto2.species).isEqualTo("Katachtigen")
            Assertions.assertThat(catDto2.age).isEqualTo(9L)
            val formerOwners2: List<OwnerDto> = catDto2.formerOwners
            Assertions.assertThat(formerOwners2).isNotEmpty
            Assertions.assertThat(formerOwners2).hasSize(1)
            val ownerDto2 = formerOwners2[0]
            Assertions.assertThat(ownerDto2.name).isEqualTo("Eng. Stromnelwan Zieligofski")
            assertThat(ownerDto2.getAddres()).isEqualTo("The swamp")
            val careCenters2: List<CareCenterDto> = catDto2.careCenters
            Assertions.assertThat(careCenters2).hasSize(1)
            val careCenterDto2 = careCenters2[0]
            Assertions.assertThat(careCenterDto2).isNotNull
            assertThat(careCenterDto2.getName()).isEqualTo("Nieuwegein Kitten Center")
            assertThat(careCenterDto2.getAddress()).isEqualTo("Kittenstraat")
            assertThat(careCenterDto2.getRefNumber()).isEqualTo("23ABC")
            assertThat(careCenterDto2.getCity()).isEqualTo("Nieuwegein")
            assertThat(careCenterDto2.getPostCode()).isEqualTo("9999CC")
            assertThat(careCenterDto2.getCountry()).isEqualTo("Nederland")
        }

    companion object {
        init {
            BlockHound.install()
        }
    }
}