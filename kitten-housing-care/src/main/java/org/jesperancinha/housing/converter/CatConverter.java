package org.jesperancinha.housing.converter;

import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.model.Cat;

import java.util.stream.Collectors;

public class CatConverter {

    public static CatDto toDto(Cat catById) {
        return CatDto.builder()
                .name(catById.getName())
                .age(catById.getAge())
                .color(catById.getColor())
                .pattern(catById.getPattern())
                .species(catById.getSpecies())
                .formerOwners(catById.getFormerOwners().stream().map(OwnerConverter::toDto).collect(Collectors.toList()))
                .build();
    }
}
