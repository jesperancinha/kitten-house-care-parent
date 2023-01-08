package org.jesperancinha.housing.service;

import org.jesperancinha.housing.converter.CareCenterConverter;
import org.jesperancinha.housing.converter.CatConverter;
import org.jesperancinha.housing.converter.OwnerConverter;
import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.repository.CareCenterRepositoryImpl;
import org.jesperancinha.housing.repository.CatRepositoryImpl;
import org.jesperancinha.housing.repository.OwnerRepositoryImpl;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CatServiceImpl {

    private final CatRepositoryImpl catRepository;

    private final OwnerRepositoryImpl ownerRepository;

    private final CareCenterRepositoryImpl careCenterRepository;

    public CatServiceImpl(CatRepositoryImpl catRepository, OwnerRepositoryImpl ownerRepository,
                          CareCenterRepositoryImpl careCenterRepository) {
        this.catRepository = catRepository;
        this.ownerRepository = ownerRepository;
        this.careCenterRepository = careCenterRepository;
    }

    public Mono<CatDto> getCatById(Long id) {
        return catRepository.getCatById(id).map(CatConverter::toDto);
    }

    public Mono<CatDto> getFullCatById(Long id) {
        return catRepository.getCatById(id).map(cat -> {
            CatDto catDto = CatConverter.toDto(cat);
            return Mono.zip(ownerRepository.getOwnersByIds(cat.getFormerOwners())
                .map(owners -> {
                    owners.forEach(owner -> catDto.getFormerOwners().add(OwnerConverter.toDto(owner)));
                    return owners;
                })
                .subscribeOn(Schedulers.parallel()), careCenterRepository.getCareCentersByIds(cat.getCareCenters())
                .map(careCenters -> {
                    careCenters
                        .forEach(careCenter -> catDto.getCareCenters().add(CareCenterConverter.toDto(careCenter)));
                    return careCenters;
                })
                .subscribeOn(Schedulers.parallel()), (owners, cares) -> catDto)
                .subscribeOn(Schedulers.parallel());
        }).flatMap(Mono::from).subscribeOn(Schedulers.parallel());
    }

    public Flux<CatDto> getFullAllCats() {
        return Flux.merge(getFullCatById(1L), getFullCatById(2L));
    }

    public Flux<CatDto> getAllCats() {
        return Flux.merge(getCatById(1L), getCatById(2L));
    }

    public List<CatDto> getFullAllCatsNonReactive() {
        return Stream.of(catRepository.getCatByIdNonReactive(1L), catRepository.getCatByIdNonReactive(2L))
            .map(catsNonReactive -> {
                CatDto catDto = CatConverter.toDto(catsNonReactive);
                catDto.getCareCenters().addAll(
                    careCenterRepository
                        .getCareCentersByIdsNonReactive(catsNonReactive.getCareCenters())
                        .stream().map(CareCenterConverter::toDto)
                .collect(Collectors.toList()));
                catDto.getFormerOwners().addAll(
                    ownerRepository
                        .getOwnersByIdsNonReactive(catsNonReactive.getFormerOwners())
                        .stream().map(OwnerConverter::toDto)
                .collect(Collectors.toList()));
                return catDto;
            }).collect(Collectors.toList());
    }

}
