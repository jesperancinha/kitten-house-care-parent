package org.jesperancinha.housing.converter

import org.jesperancinha.housing.data.OwnerDto
import org.jesperancinha.housing.model.Owner

object OwnerConverter {
    fun toDto(owner: Owner?): OwnerDto {
        return OwnerDto.builder().name(owner.getName()).addres(owner.getAddress()).build()
    }
}