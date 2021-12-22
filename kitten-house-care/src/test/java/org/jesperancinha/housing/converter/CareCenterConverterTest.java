package org.jesperancinha.housing.converter;

import org.jesperancinha.housing.data.CareCenterDto;
import org.jesperancinha.housing.model.CareCenter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CareCenterConverterTest {

    @Test
    void toDto() {
        final CareCenterDto careCenterDto = CareCenterConverter.toDto(new CareCenter());

        assertThat(careCenterDto).isNotNull();
    }
}