package org.jesperancinha.housing.model

import lombok.Data

@Data
class Cat {
    private val id: Long? = null
    private val name: String? = null
    private val color: String? = null
    private val species: String? = null
    private val pattern: String? = null
    private val age: Long? = null
    private val formerOwners: List<Long> = ArrayList()
    private val careCenters: List<Long> = ArrayList()
}