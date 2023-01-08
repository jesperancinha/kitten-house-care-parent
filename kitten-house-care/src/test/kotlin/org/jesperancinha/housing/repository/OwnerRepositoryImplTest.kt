package org.jesperancinha.housing.repository

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class OwnerRepositoryImplTest {
    private val ownerRepository = OwnerRepositoryImpl(ObjectMapper())
    @Test
    fun givenLiable_checkLiability_Ok() {
        val deVeluwe = ownerRepository.checkLiability("De Veluwe")
        val block = deVeluwe.block()
        Assertions.assertThat(block).isEqualTo("OK")
    }

    @Test
    fun givenNonLiable_checkLiability_NOk() {
        val the_swamp = ownerRepository.checkLiability("The Swamp")
        val block = the_swamp.block()
        Assertions.assertThat(block).isEqualTo("NOK")
    }
}