package org.jesperancinha.housing.converter;

import org.jesperancinha.housing.data.OwnerDto;
import org.jesperancinha.housing.model.Owner;

public class OwnerConverter {
    public static OwnerDto toDto(Owner owner) {
        return OwnerDto.builder()
                .name(owner.getName())
                .addres(owner.getAddres())
                .build();
    }
}
