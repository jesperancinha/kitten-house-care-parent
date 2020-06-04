package org.jesperancinha.housing.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

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

    private final List<OwnerDto> formerOwners = new ArrayList<>();

    private final List<CareCenterDto> careCenters = new ArrayList<>();
}
