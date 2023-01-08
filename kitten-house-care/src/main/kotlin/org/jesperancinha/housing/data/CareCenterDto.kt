package org.jesperancinha.housing.data

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

class CareCenterDto (
    private val name: String? = null,
    private val address: String? = null,
    private val refNumber: String? = null,
    private val city: String? = null,
    private val postCode: String? = null,
    private val country: String? = null
)