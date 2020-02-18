package org.jesperancinha.housing.data;

import lombok.Builder;

import java.util.List;

@Builder
public class CatDto {
    private String name;

    private String color;

    private String species;

    private String pattern;

    private Long age;

    private List<OwnerDto> formerOwners;
}
