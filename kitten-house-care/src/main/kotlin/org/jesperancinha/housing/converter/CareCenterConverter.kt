package org.jesperancinha.housing.converter

import org.jesperancinha.housing.data.CareCenterDto
import org.jesperancinha.housing.model.CareCenter

fun CareCenter.toDto() = CareCenterDto(
    name = name,
    address = address,
    city = city,
    refNumber = refNumber,
    postCode = postCode,
    country = country
)