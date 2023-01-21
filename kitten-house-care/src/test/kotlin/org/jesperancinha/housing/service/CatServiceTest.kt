package org.jesperancinha.housing.service

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class CatServiceTest @Autowired constructor(
    val catService: CatService,
) {

    @Test
    fun `should get full cat 1`() {
        catService.getFullCatById(1L).block()
            .let {
                it.shouldNotBeNull()
                    .formerOwners
                    .shouldHaveSize(1)
                    .first().apply {
                        name shouldBe "Eng. João Esperancinha"
                        address shouldBe "De Veluwe"
                    }
            }
    }

    @Test
    fun `should get full cat 2`() {
        catService.getFullCatById(2L).block()
            .let {
                it.shouldNotBeNull()
                    .formerOwners
                    .shouldHaveSize(1)
                    .first().apply {
                        name shouldBe "Stromnelwan Zieligofski"
                        address shouldBe "The swamp"
                    }
            }
    }
}