package org.jesperancinha.housing.dto

class CareCenterDto (
    private val name: String? = null,
    private val address: String? = null,
    private val refNumber: String? = null,
    private val city: String? = null,
    private val postCode: String? = null,
    private val country: String? = null
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