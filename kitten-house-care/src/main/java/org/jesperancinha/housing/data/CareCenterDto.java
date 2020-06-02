package org.jesperancinha.housing.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CareCenterDto {
    private String name;

    private String address;

    private String refNumber;

    private String city;

    private String postCode;

    private String country;
}
