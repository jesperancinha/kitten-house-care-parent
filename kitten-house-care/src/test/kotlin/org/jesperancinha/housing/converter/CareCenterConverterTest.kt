package org.jesperancinha.housing.converter

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.jesperancinha.housing.dao.CareCenter
import org.jesperancinha.housing.service.toDto
import org.junit.jupiter.api.Test

internal class CareCenterConverterTest {
    @Test
    fun `conversion to Dto should be exact`() {
        val careCenterDto = CareCenter(
            id= 123,
            name = "Lucy and Lars",
            address = "Gouda",
            refNumber = "Where it all began",
            city = "Gouda City",
            postCode = "6666GG",
            country = "NL"
        ).toDto()

        careCenterDto.shouldNotBeNull()
        careCenterDto.name shouldBe "Lucy and Lars"
        careCenterDto.address shouldBe "Gouda"
        careCenterDto.refNumber shouldBe "Where it all began"
        careCenterDto.city shouldBe "Gouda City"
        careCenterDto.postCode shouldBe "6666GG"
        careCenterDto.country shouldBe "NL"
    }
}