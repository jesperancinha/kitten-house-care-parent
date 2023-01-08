package org.jesperancinha.housing.converter

import org.assertj.core.api.Assertions
import org.jesperancinha.housing.converter.CareCenterConverter.toDto
import org.jesperancinha.housing.model.CareCenter
import org.junit.jupiter.api.Test

internal class CareCenterConverterTest {
    @Test
    fun toDto() {
        val careCenterDto = toDto(CareCenter())
        Assertions.assertThat(careCenterDto).isNotNull
    }
}