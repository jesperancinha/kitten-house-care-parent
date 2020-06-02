package org.jesperancinha.housing.model;

import lombok.Data;

@Data
public class CareCenter {

    private Long id;

    private String name;

    private String address;

    private String refNumber;

    private String city;

    private String postCode;

    private String country;
}
