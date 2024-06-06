package org.jesperancinha.housing.service

import org.jesperancinha.housing.dao.CareCenter
import org.jesperancinha.housing.dao.Cat
import org.jesperancinha.housing.dao.Owner
import org.jesperancinha.housing.dto.CareCenterDto
import org.jesperancinha.housing.dto.CatDto
import org.jesperancinha.housing.dto.OwnerDto

fun CareCenter.toDto() = CareCenterDto(
    name = name,
    address = address,
    city = city,
    refNumber = refNumber,
    postCode = postCode,
    country = country
)

fun Cat.toDto() = CatDto(
    name = name,
    age = age,
    color = color,
    pattern = pattern,
    species = species,
    formerOwners = mutableListOf(),

)

fun Owner.toDto() = OwnerDto(
    name = name,
    address= address
)