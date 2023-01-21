package org.jesperancinha.housing.converter

import io.kotest.matchers.nulls.shouldNotBeNull
import org.assertj.core.api.Assertions
import org.jesperancinha.housing.dao.CareCenter
import org.jesperancinha.housing.service.toDto
import org.junit.jupiter.api.Test

internal class CareCenterConverterTest {
    @Test
    fun `conversion to Dto should not be null`() {
        val careCenterDto = CareCenter().toDto()
        careCenterDto.shouldNotBeNull()
    }
}