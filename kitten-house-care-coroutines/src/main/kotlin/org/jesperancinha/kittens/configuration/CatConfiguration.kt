package org.jesperancinha.kittens.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CatConfiguration {
    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
    }
}