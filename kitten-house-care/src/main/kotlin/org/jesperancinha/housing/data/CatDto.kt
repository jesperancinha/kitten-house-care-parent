package org.jesperancinha.housing.data

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
class CatDto {
    private val name: String? = null
    private val color: String? = null
    private val species: String? = null
    private val pattern: String? = null
    private val age: Long? = null
    private val formerOwners: List<OwnerDto> = ArrayList()
    private val careCenters: List<CareCenterDto> = ArrayList()
}