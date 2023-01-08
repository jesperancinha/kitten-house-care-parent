package org.jesperancinha.housing.converter

import org.jesperancinha.housing.data.CatDto
import org.jesperancinha.housing.model.Cat

object CatConverter {
    fun toDto(catById: Cat?): CatDto {
        return CatDto.builder().name(catById.getName()).age(catById.getAge()).color(catById.getColor())
            .pattern(catById.getPattern())
            .species(catById.getSpecies()) //            .formerOwners(catById.getFormerOwners().stream().map(OwnerConverter::toDto).collect(Collectors.toList()))
            //            .careCenters(catById.getCareCenters().stream().map(CareCenterConverter::toDto).collect(Collectors.toList()))
            .build()
    }
}