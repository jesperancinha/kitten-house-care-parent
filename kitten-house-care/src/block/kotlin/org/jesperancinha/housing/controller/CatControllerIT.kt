package org.jesperancinha.housing.controller

import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe 
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
internal class CatControllerIT {
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
            catDto.shouldNotBeNull()
            catDto.name shouldBe "Lania"
            catDto.color shouldBe "orange"
            catDto.species shouldBe "Katachtigen"
            catDto.age shouldBe 4L
            catDto.formerOwners.shouldBeEmpty()
            catDto.careCenters.shouldBeEmpty()
        }

    @Test
    fun fullCatById_whenCall_FullOk(){
            val uri = String.format("http://localhost:%d/cats/full/1", port)
            val catDto = restTemplate.getForObject(uri, CatDto::class.java)
            catDto.shouldNotBeNull()
            catDto.name shouldBe "Lania"
            catDto.color shouldBe "orange"
            catDto.species shouldBe "Katachtigen"
            catDto.age shouldBe 4L
            val formerOwners: List<OwnerDto> = catDto.formerOwners
            formerOwners.shouldNotBeEmpty()
            formerOwners.shouldHaveSize(1)
            val ownerDto = formerOwners[0]
            ownerDto.name shouldBe "Eng. João Esperancinha"
            ownerDto.address shouldBe "De Veluwe"
            val careCenters: List<CareCenterDto> = catDto.careCenters
            careCenters.shouldHaveSize(1)
            val careCenterDto = careCenters[0]
            careCenterDto.shouldNotBeNull()
            careCenterDto.name shouldBe "Nieuwegein Kitten Center"
            careCenterDto.address shouldBe "Kittenstraat"
            careCenterDto.refNumber shouldBe "23ABC"
            careCenterDto.city shouldBe "Nieuwegein"
            careCenterDto.postCode shouldBe "9999CC"
            careCenterDto.country shouldBe "Nederland"
        }

    @Test
    fun all_whenCall_Ok(){
            val uri = String.format("http://localhost:%d/cats", port)
            val catDtos = restTemplate.getForObject(uri, Array<CatDto>::class.java)
            catDtos.shouldNotBeNull()
            val catDto1 = Arrays.stream(catDtos)
                .filter { catDto ->
                    (catDto.name
                            == "Lania")
                }
                .findFirst()
                .orElse(null)
            catDto1.shouldNotBeNull()
            catDto1.name shouldBe "Lania"
            catDto1.color shouldBe "orange"
            catDto1.species shouldBe "Katachtigen"
            catDto1.age shouldBe 4L
            val formerOwners: List<OwnerDto> = catDto1.formerOwners
            formerOwners.shouldBeEmpty()
            val careCenters: List<CareCenterDto> = catDto1.careCenters
            careCenters.shouldBeEmpty()
            val catDto2 = Arrays.stream(catDtos)
                .filter { catDto -> (catDto.name == "Mit") }
                .findFirst()
                .orElse(null)
            catDto2.shouldNotBeNull()
            catDto2.name shouldBe "Mit"
            catDto2.color shouldBe "black and white"
            catDto2.species shouldBe "Katachtigen"
            catDto2.age shouldBe 9L
            val formerOwners2: List<OwnerDto> = catDto2.formerOwners
            formerOwners2.shouldBeEmpty()
            val careCenters2: List<CareCenterDto> = catDto2.careCenters
            careCenters2.shouldBeEmpty()
        }

    @Test
    fun fullAll_whenCall_FullOk(){
            val uri = String.format("http://localhost:%d/cats/full", port)
            val catDtos = restTemplate.getForObject(uri, Array<CatDto>::class.java)
            catDtos.shouldNotBeNull()
            val catDto1 = Arrays.stream(catDtos)
                .filter { catDto -> (catDto.name == "Lania") }
                .findFirst()
                .orElse(null)
            catDto1.shouldNotBeNull()
            catDto1.name shouldBe "Lania"
            catDto1.color shouldBe "orange"
            catDto1.species shouldBe "Katachtigen"
            catDto1.age shouldBe 4L
            val formerOwners: List<OwnerDto> = catDto1.formerOwners
            formerOwners.shouldNotBeEmpty()
            formerOwners.shouldHaveSize(1)
            val ownerDto = formerOwners[0]
            ownerDto.name shouldBe "Eng. João Esperancinha"
            ownerDto.address shouldBe "De Veluwe"
            val careCenters: List<CareCenterDto> = catDto1.careCenters
            careCenters.shouldHaveSize(1)
            val careCenterDto = careCenters[0]
            careCenterDto.shouldNotBeNull()
            careCenterDto.name shouldBe "Nieuwegein Kitten Center"
            careCenterDto.address shouldBe "Kittenstraat"
            careCenterDto.refNumber shouldBe "23ABC"
            careCenterDto.city shouldBe "Nieuwegein"
            careCenterDto.postCode shouldBe "9999CC"
            careCenterDto.country shouldBe "Nederland"
            val catDto2 = Arrays.stream(catDtos)
                .filter { catDto ->
                    (catDto.name
                            == "Mit")
                }
                .findFirst()
                .orElse(null)
            catDto2.shouldNotBeNull()
            catDto2.name shouldBe "Mit"
            catDto2.color shouldBe "black and white"
            catDto2.species shouldBe "Katachtigen"
            catDto2.age shouldBe 9L
            val formerOwners2: List<OwnerDto> = catDto2.formerOwners
            formerOwners2.shouldNotBeEmpty()
            formerOwners2.shouldHaveSize(1)
            val ownerDto2 = formerOwners2[0]
            ownerDto2.name shouldBe "Stromnelwan Zieligofski"
            ownerDto2.address shouldBe "The swamp"
            val careCenters2: List<CareCenterDto> = catDto2.careCenters
            careCenters2.shouldHaveSize(1)
            val careCenterDto2 = careCenters2[0]
            careCenterDto2.shouldNotBeNull()
            careCenterDto2.name shouldBe "Nieuwegein Kitten Center"
            careCenterDto2.address shouldBe "Kittenstraat"
            careCenterDto2.refNumber shouldBe "23ABC"
            careCenterDto2.city shouldBe "Nieuwegein"
            careCenterDto2.postCode shouldBe "9999CC"
            careCenterDto2.country shouldBe "Nederland"
        }

    companion object {
        init {
            BlockHound.install()
        }
    }
}