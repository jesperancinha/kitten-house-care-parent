package org.jesperancinha.housing.controller

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
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
    val restTemplate by lazy {  RestTemplate()}

    @Autowired
    lateinit var catController: CatControllerImpl

    @LocalServerPort
    protected var port: Int = 0

    @Test
    fun catByIdI_whenCall_nonBlocking(){
        Mono.delay(Duration.ofMillis(1))
                .doOnNext { catController.getCatByIdI(1L) }
                .block()
        }

    @Test
    fun fullCatById_whenCall_nonBlocking(){
            Mono.delay(Duration.ofMillis(1))
                .doOnNext {catController.getFullCatById(1L) }
                .block()
        }

    @Test
    fun allCats_whenCall_nonBlocking(){
            Mono.delay(Duration.ofMillis(1))
                .doOnNext {catController.allCats() }
                .block()
        }

    @Test
    fun fullAllCats_whenCall_nonBlocking(){
            Mono.delay(Duration.ofMillis(1))
                .doOnNext {catController.fullAllCats() }
                .block()
        }

    @Test
    fun fullAllCatsNonReaciveForTest_whenCall_Blocking(){
            Mono.delay(Duration.ofMillis(1))
                .doOnNext {catController.fullAllCatsReactiveForTest() }
                .block()
        }

    @Test
    fun fullAllCatsNonReacive_whenCall_Blocking(){
            Assertions.assertThatExceptionOfType(Exception::class.java).isThrownBy {
                Mono.delay(Duration.ofMillis(1))
                    .doOnNext {catController.fullAllCatsNonReactive() }
                    .block()
            }
        }

    @Test
    fun catByIdI_whenCall_Ok(){
            val uri = String.format("http://localhost:%d/cats/1", port)
            val catDto = restTemplate.getForObject(uri, CatDto::class.java)
            assertThat(catDto).isNotNull
            assertThat(catDto.name).isEqualTo("Lania")
            assertThat(catDto.color).isEqualTo("orange")
            assertThat(catDto.species).isEqualTo("Katachtigen")
            assertThat(catDto.age).isEqualTo(4L)
            assertThat(catDto.formerOwners).isEmpty()
            assertThat(catDto.careCenters).isEmpty()
        }

    @Test
    fun fullCatById_whenCall_FullOk(){
            val uri = String.format("http://localhost:%d/cats/full/1", port)
            val catDto = restTemplate.getForObject(uri, CatDto::class.java)
            assertThat(catDto).isNotNull
            assertThat(catDto.name).isEqualTo("Lania")
            assertThat(catDto.color).isEqualTo("orange")
            assertThat(catDto.species).isEqualTo("Katachtigen")
            assertThat(catDto.age).isEqualTo(4L)
            val formerOwners: List<OwnerDto> = catDto.formerOwners
            assertThat(formerOwners).isNotEmpty
            assertThat(formerOwners).hasSize(1)
            val ownerDto = formerOwners[0]
            assertThat(ownerDto.name).isEqualTo("Eng. João Esperancinha")
            assertThat(ownerDto.address).isEqualTo("De Veluwe")
            val careCenters: List<CareCenterDto> = catDto.careCenters
            assertThat(careCenters).hasSize(1)
            val careCenterDto = careCenters[0]
            assertThat(careCenterDto).isNotNull
            assertThat(careCenterDto.name).isEqualTo("Nieuwegein Kitten Center")
            assertThat(careCenterDto.address).isEqualTo("Kittenstraat")
            assertThat(careCenterDto.refNumber).isEqualTo("23ABC")
            assertThat(careCenterDto.city).isEqualTo("Nieuwegein")
            assertThat(careCenterDto.postCode).isEqualTo("9999CC")
            assertThat(careCenterDto.country).isEqualTo("Nederland")
        }

    @Test
    fun all_whenCall_Ok(){
            val uri = String.format("http://localhost:%d/cats", port)
            val catDtos = restTemplate.getForObject(uri, Array<CatDto>::class.java)
            assertThat(catDtos).isNotNull
            val catDto1 = Arrays.stream(catDtos)
                .filter { catDto ->
                    (catDto.name
                            == "Lania")
                }
                .findFirst()
                .orElse(null)
            assertThat(catDto1).isNotNull
            assertThat(catDto1.name).isEqualTo("Lania")
            assertThat(catDto1.color).isEqualTo("orange")
            assertThat(catDto1.species).isEqualTo("Katachtigen")
            assertThat(catDto1.age).isEqualTo(4L)
            val formerOwners: List<OwnerDto> = catDto1.formerOwners
            assertThat(formerOwners).isEmpty()
            val careCenters: List<CareCenterDto> = catDto1.careCenters
            assertThat(careCenters).isEmpty()
            val catDto2 = Arrays.stream(catDtos)
                .filter { catDto ->
                    (catDto.name
                            == "Mit")
                }
                .findFirst()
                .orElse(null)
            assertThat(catDto2).isNotNull
            assertThat(catDto2.name).isEqualTo("Mit")
            assertThat(catDto2.color).isEqualTo("black and white")
            assertThat(catDto2.species).isEqualTo("Katachtigen")
            assertThat(catDto2.age).isEqualTo(9L)
            val formerOwners2: List<OwnerDto> = catDto2.formerOwners
            assertThat(formerOwners2).isEmpty()
            val careCenters2: List<CareCenterDto> = catDto2.careCenters
            assertThat(careCenters2).isEmpty()
        }

    @Test
    fun fullAll_whenCall_FullOk(){
            val uri = String.format("http://localhost:%d/cats/full", port)
            val catDtos = restTemplate.getForObject(uri, Array<CatDto>::class.java)
            assertThat(catDtos).isNotNull
            val catDto1 = Arrays.stream(catDtos)
                .filter { catDto ->
                    (catDto.name
                            == "Lania")
                }
                .findFirst()
                .orElse(null)
            assertThat(catDto1).isNotNull
            assertThat(catDto1.name).isEqualTo("Lania")
            assertThat(catDto1.color).isEqualTo("orange")
            assertThat(catDto1.species).isEqualTo("Katachtigen")
            assertThat(catDto1.age).isEqualTo(4L)
            val formerOwners: List<OwnerDto> = catDto1.formerOwners
            assertThat(formerOwners).isNotEmpty
            assertThat(formerOwners).hasSize(1)
            val ownerDto = formerOwners[0]
            assertThat(ownerDto.name).isEqualTo("Eng. João Esperancinha")
            assertThat(ownerDto.address).isEqualTo("De Veluwe")
            val careCenters: List<CareCenterDto> = catDto1.careCenters
            assertThat(careCenters).hasSize(1)
            val careCenterDto = careCenters[0]
            assertThat(careCenterDto).isNotNull
            assertThat(careCenterDto.name).isEqualTo("Nieuwegein Kitten Center")
            assertThat(careCenterDto.address).isEqualTo("Kittenstraat")
            assertThat(careCenterDto.refNumber).isEqualTo("23ABC")
            assertThat(careCenterDto.city).isEqualTo("Nieuwegein")
            assertThat(careCenterDto.postCode).isEqualTo("9999CC")
            assertThat(careCenterDto.country).isEqualTo("Nederland")
            val catDto2 = Arrays.stream(catDtos)
                .filter { catDto ->
                    (catDto.name
                            == "Mit")
                }
                .findFirst()
                .orElse(null)
            assertThat(catDto2).isNotNull
            assertThat(catDto2.name).isEqualTo("Mit")
            assertThat(catDto2.color).isEqualTo("black and white")
            assertThat(catDto2.species).isEqualTo("Katachtigen")
            assertThat(catDto2.age).isEqualTo(9L)
            val formerOwners2: List<OwnerDto> = catDto2.formerOwners
            assertThat(formerOwners2).isNotEmpty
            assertThat(formerOwners2).hasSize(1)
            val ownerDto2 = formerOwners2[0]
            assertThat(ownerDto2.name).isEqualTo("Eng. Stromnelwan Zieligofski")
            assertThat(ownerDto2.address).isEqualTo("The swamp")
            val careCenters2: List<CareCenterDto> = catDto2.careCenters
            assertThat(careCenters2).hasSize(1)
            val careCenterDto2 = careCenters2[0]
            assertThat(careCenterDto2).isNotNull
            assertThat(careCenterDto2.name).isEqualTo("Nieuwegein Kitten Center")
            assertThat(careCenterDto2.address).isEqualTo("Kittenstraat")
            assertThat(careCenterDto2.refNumber).isEqualTo("23ABC")
            assertThat(careCenterDto2.city).isEqualTo("Nieuwegein")
            assertThat(careCenterDto2.postCode).isEqualTo("9999CC")
            assertThat(careCenterDto2.country).isEqualTo("Nederland")
        }

    companion object {
        init {
            BlockHound.install()
        }
    }
}