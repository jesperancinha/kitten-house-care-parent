package org.jesperancinha.kittens.dto

class CareCenterDto (
    val name: String? = null,
    val address: String? = null,
     val refNumber: String? = null,
     val city: String? = null,
     val postCode: String? = null,
     val country: String? = null
)

data class CatDto(
    val name: String? = null,
    val color: String? = null,
    val species: String? = null,
    val pattern: String? = null,
    val age: Long? = null,
    val formerOwners: MutableList<OwnerDto> = ArrayList(),
    val careCenters: MutableList<CareCenterDto> = ArrayList()
)

data class OwnerDto (
     val name: String? = null,
     val address: String? = null
)