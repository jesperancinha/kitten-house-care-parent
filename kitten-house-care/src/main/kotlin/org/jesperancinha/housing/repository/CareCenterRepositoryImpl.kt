package org.jesperancinha.housing.repository

import com.fasterxml.jackson.databind.ObjectMapper
import org.jesperancinha.housing.model.CareCenter
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*
import java.util.stream.Collectors

@Repository
class CareCenterRepositoryImpl(objectMapper: ObjectMapper) {
    private val careCenters: Array<CareCenter?>

    init {
        careCenters = objectMapper
            .readValue(javaClass.getResourceAsStream("/carecenters.json"), Array<CareCenter>::class.java)
    }

    fun getCareCenterById(id: Long): Mono<CareCenter?> {
        return Mono.fromCallable {
            Arrays.stream(careCenters).filter { careCenter: CareCenter? -> careCenter.getId() == id }
                .findFirst()
                .orElse(null)
        }
    }

    fun getCareCentersByIds(careCenteIds: List<Long>): Mono<List<CareCenter?>> {
        return Mono.fromCallable { getCareCenters(careCenteIds) }
    }

    fun getCareCentersByIdsNonReactive(careCenters: List<Long>): List<CareCenter?> {
        return getCareCenters(careCenters)
    }

    private fun getCareCenters(careCenteIds: List<Long>): List<CareCenter?> {
        return Arrays.stream(careCenters)
            .filter { careCenter: CareCenter? -> careCenteIds.contains(careCenter.getId()) }
            .collect(Collectors.toList())
    }
}