package org.jesperancinha.housing.data;

import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CatDto {
    private String name;

    private String color;

    private String species;

    private String pattern;

    private Long age;

    private List<OwnerDto> formerOwners;

    private List<CareCenterDto> careCenters;
}
