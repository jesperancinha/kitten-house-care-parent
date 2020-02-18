package org.jesperancinha.housing.data;

import lombok.Builder;

@Builder
public class CareCenterDto {
    private String name;

    private String address;

    private String refNumber;

    private String city;

    private String postCode;

    private String country;
}
