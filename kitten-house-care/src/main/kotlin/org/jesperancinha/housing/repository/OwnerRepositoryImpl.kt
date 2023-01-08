package org.jesperancinha.housing.repository

import com.fasterxml.jackson.databind.ObjectMapper
import org.jesperancinha.housing.model.Owner
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import java.util.stream.Collectors

@Repository
class OwnerRepositoryImpl(objectMapper: ObjectMapper) {
    private val owners: Array<Owner?>

    init {
        owners = objectMapper.readValue(javaClass.getResourceAsStream("/owners.json"), Array<Owner>::class.java)
    }

    fun getOwnerById(id: Long): Mono<Owner?> {
        return Mono.fromCallable {
            Arrays.stream(owners).filter { owner: Owner? -> owner.getId() == id }
                .findFirst().orElse(null)
        }
    }

    fun getOwnersByIds(formerOwners: List<Long>): Mono<List<Owner?>> {
        return Mono.fromCallable { getOwners(formerOwners) }
    }

    fun checkLiability(address: String?): Mono<String> {
        return Flux
            .fromStream {
                Arrays.stream(owners).filter { owner: Owner? -> owner.getAddress().equals(address, ignoreCase = true) }
            }
            .reduce { owner: Owner?, owner2: Owner? ->
                if (owner.getRating() > owner2.getRating()) {
                    return@reduce owner2
                }
                owner
            }.map { owner: Owner? -> if (owner.getRating() <= 0) "NOK" else "OK" }
    }

    fun getOwnersByIdsNonReactive(formerOwners: List<Long>): List<Owner?> {
        return getOwners(formerOwners)
    }

    private fun getOwners(formerOwners: List<Long>): List<Owner?> {
        return Arrays.stream(owners)
            .filter { owner: Owner? -> formerOwners.contains(owner.getId()) }
            .collect(Collectors.toList())
    }
}