package org.jesperancinha.housing.repository

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.jesperancinha.housing.dao.OwnerRepository
import org.junit.jupiter.api.Test

internal class OwnerRepositoryTest {
    private val ownerRepository = OwnerRepository(ObjectMapper())
    @Test
    fun givenLiable_checkLiability_Ok() {
        val deVeluwe = ownerRepository.checkLiability("De Veluwe")
        val block = deVeluwe.block()
        block shouldBe "Ok"
    }

    @Test
    fun givenNonLiable_checkLiability_NOk() {
        val the_swamp = ownerRepository.checkLiability("The Swamp")
        val block = the_swamp.block()
        block shouldBe "NOK"
    }
}