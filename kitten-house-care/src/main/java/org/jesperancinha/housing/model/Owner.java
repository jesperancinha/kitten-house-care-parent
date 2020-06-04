package org.jesperancinha.housing.model;

import lombok.Data;

@Data
public class Owner {
    private Long id;

    private String name;

    private String address;

    private Integer rating;
}
