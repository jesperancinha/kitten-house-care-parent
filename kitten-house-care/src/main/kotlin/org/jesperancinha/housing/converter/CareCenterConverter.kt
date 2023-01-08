package org.jesperancinha.housing.converter

import org.jesperancinha.housing.data.CareCenterDto
import org.jesperancinha.housing.model.CareCenter

object CareCenterConverter {
    @JvmStatic
    fun toDto(careCenter: CareCenter?): CareCenterDto {
        return CareCenterDto.builder().name(careCenter.getName()).address(careCenter.getAddress())
            .city(careCenter.getCity()).refNumber(careCenter.getRefNumber()).postCode(careCenter.getPostCode())
            .country(careCenter.getCountry()).build()
    }
}