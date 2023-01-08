package org.jesperancinha.housing.repository

import com.fasterxml.jackson.databind.ObjectMapper
import org.jesperancinha.housing.model.Cat
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class CatRepositoryImpl(objectMapper: ObjectMapper) {
    private val cat1: Cat
    private val cat2: Cat

    init {
        cat1 = objectMapper.readValue(javaClass.getResourceAsStream("/cat1.json"), Cat::class.java)
        cat2 = objectMapper.readValue(javaClass.getResourceAsStream("/cat2.json"), Cat::class.java)
    }

    fun getCatById(id: Long): Mono<Cat?> {
        return Mono.fromCallable { getCat(id) }
    }

    fun getCatByIdNonReactive(id: Long): Cat? {
        return getCat(id)
    }

    private fun getCat(id: Long): Cat? {
        if (id.toInt() == 1L) {
            return cat1
        }
        return if (id.toInt() == 2L) {
            cat2
        } else null
    }
}