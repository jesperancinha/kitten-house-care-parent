package org.jesperancinha.housing.converter

import org.assertj.core.api.Assertions
import org.jesperancinha.housing.dao.CareCenter
import org.jesperancinha.housing.service.toDto
import org.junit.jupiter.api.Test

internal class CareCenterConverterTest {
    @Test
    fun toDto() {
        val careCenterDto = CareCenter().toDto()
        Assertions.assertThat(careCenterDto).isNotNull
    }
}