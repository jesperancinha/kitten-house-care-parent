package org.jesperancinha.housing.dao

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

data class CareCenter(
    val id: Long? = null,
    val name: String? = null,
    val address: String? = null,
    val refNumber: String? = null,
    val city: String? = null,
    val postCode: String? = null,
    val country: String? = null,
)

data class Cat(
    val id: Long? = null,
    val name: String? = null,
    val color: String? = null,
    val species: String? = null,
    val pattern: String? = null,
    val age: Long? = null,
    val formerOwners: List<Long> = ArrayList(),
    val careCenters: List<Long> = ArrayList(),
)

data class Owner(
    @JsonProperty("id")
    val id: Long? = null,
    @JsonProperty("name")
    val name: String? = null,
    @JsonProperty("address")
    val address: String? = null,
    @JsonProperty("rating")
    val rating: Int,
)

@Repository
class CareCenterRepository(objectMapper: ObjectMapper) {
    private val careCenters: Array<CareCenter>

    init {
        careCenters = objectMapper
            .readValue(javaClass.getResourceAsStream("/carecenters.json"), Array<CareCenter>::class.java)
    }

    fun getCareCenterById(id: Long): Mono<CareCenter> {
        return Mono.fromCallable {
            careCenters.firstOrNull { careCenter -> careCenter.id == id }
        }
    }

    fun getCareCentersByIds(careCenterIds: List<Long>): Mono<List<CareCenter>> {
        return Mono.fromCallable { getCareCenters(careCenterIds) }
    }

    fun getCareCentersByIdsNonReactive(careCenters: List<Long>): List<CareCenter> {
        return getCareCenters(careCenters)
    }

    private fun getCareCenters(careCenteIds: List<Long>): List<CareCenter> = careCenters
        .filter { careCenter -> careCenteIds.contains(careCenter.id) }
}

@Repository
class CatRepository(objectMapper: ObjectMapper) {
    private val cat1: Cat by lazy {
        objectMapper.readValue(
            javaClass.getResourceAsStream("/cat1.json"),
            Cat::class.java
        )
    }
    private val cat2: Cat by lazy {
        objectMapper.readValue(
            javaClass.getResourceAsStream("/cat2.json"),
            Cat::class.java
        )
    }

    fun getCatById(id: Long): Mono<Cat> = Mono.fromCallable { getCat(id) }

    fun getCatByIdNonReactive(id: Long) = getCat(id)

    private fun getCat(id: Long): Cat? = when (id) {
        1L -> cat1
        2L -> cat2
        else -> null
    }
}

@Repository
class OwnerRepository(objectMapper: ObjectMapper) {
    private val owners: Array<Owner> by lazy {
        objectMapper.readValue(
            javaClass.getResourceAsStream("/owners.json"),
            Array<Owner>::class.java
        )
    }

    fun getOwnerById(id: Long): Mono<Owner> = Mono.fromCallable {
        owners.first { owner -> owner.id == id }
    }

    fun getOwnersByIds(formerOwners: List<Long>): Mono<List<Owner>> {
        return Mono.fromCallable { getOwners(formerOwners) }
    }

    fun checkLiability(address: String): Mono<String> {
        return Flux.fromStream {
            owners.filter { owner -> owner.address.equals(address, ignoreCase = true) }.stream()
        }.reduce { owner: Owner, owner2: Owner ->
                if (owner.rating > owner2.rating) {
                    return@reduce owner2
                }
                owner
            }.map { owner -> if (owner.rating <= 0) "NOK" else "OK" }
    }

    fun getOwnersByIdsNonReactive(formerOwners: List<Long>): List<Owner> {
        return getOwners(formerOwners)
    }

    private fun getOwners(formerOwners: List<Long>): List<Owner> {
        return owners
            .filter { owner -> formerOwners.contains(owner.id) }
    }
}