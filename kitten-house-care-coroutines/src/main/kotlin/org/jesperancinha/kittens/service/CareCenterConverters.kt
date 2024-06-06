package org.jesperancinha.kittens.service

import org.jesperancinha.kittens.dao.CareCenter
import org.jesperancinha.kittens.dao.Cat
import org.jesperancinha.kittens.dao.Owner
import org.jesperancinha.kittens.dto.CareCenterDto
import org.jesperancinha.kittens.dto.CatDto
import org.jesperancinha.kittens.dto.OwnerDto

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