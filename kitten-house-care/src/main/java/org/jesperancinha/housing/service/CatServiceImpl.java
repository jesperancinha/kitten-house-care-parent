package org.jesperancinha.housing.service;

import org.jesperancinha.housing.converter.CareCenterConverter;
import org.jesperancinha.housing.converter.CatConverter;
import org.jesperancinha.housing.converter.OwnerConverter;
import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.repository.CareCenterRepository;
import org.jesperancinha.housing.repository.CatRepository;
import org.jesperancinha.housing.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    private final OwnerRepository ownerRepository;

    private final CareCenterRepository careCenterRepository;

    public CatServiceImpl(CatRepository catRepository, OwnerRepository ownerRepository,
        CareCenterRepository careCenterRepository) {
        this.catRepository = catRepository;
        this.ownerRepository = ownerRepository;
        this.careCenterRepository = careCenterRepository;
    }

    @Override
    public Mono<CatDto> getCatById(Long id) {
        return catRepository.getCatById(id).map(CatConverter::toDto);
    }

    @Override
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

    @Override
    public Flux<CatDto> getFullAllCats() {
        return Flux.merge(getFullCatById(1L), getFullCatById(2L));
    }

    @Override
    public Flux<CatDto> getAllCats() {
        return Flux.merge(getCatById(1L), getCatById(2L));
    }

}
