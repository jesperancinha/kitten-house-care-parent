package org.jesperancinha.housing.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cat {
    private Long id;

    private String name;

    private String color;

    private String species;

    private String pattern;

    private Long age;

    private List<Owner> formerOwners = new ArrayList<>();

    private List<CareCenter> careCenters = new ArrayList<>();
}
