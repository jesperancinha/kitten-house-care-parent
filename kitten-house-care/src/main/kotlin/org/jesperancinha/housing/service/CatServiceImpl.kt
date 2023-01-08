package org.jesperancinha.housing.service

import org.jesperancinha.housing.converter.CareCenterConverter
import org.jesperancinha.housing.converter.CatConverter
import org.jesperancinha.housing.converter.OwnerConverter
import org.jesperancinha.housing.data.CatDto
import org.jesperancinha.housing.model.CareCenter
import org.jesperancinha.housing.model.Cat
import org.jesperancinha.housing.model.Owner
import org.jesperancinha.housing.repository.CareCenterRepositoryImpl
import org.jesperancinha.housing.repository.CatRepositoryImpl
import org.jesperancinha.housing.repository.OwnerRepositoryImpl
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.util.function.Consumer
import java.util.stream.Collectors
import java.util.stream.Stream

@Service
class CatServiceImpl(
    private val catRepository: CatRepositoryImpl, private val ownerRepository: OwnerRepositoryImpl,
    private val careCenterRepository: CareCenterRepositoryImpl
) {
    fun getCatById(id: Long): Mono<CatDto?> {
        return catRepository.getCatById(id).map { obj: Cat? -> CatConverter.toDto() }
    }

    fun getFullCatById(id: Long): Mono<CatDto?> {
        return catRepository.getCatById(id).map { cat: Cat? ->
            val catDto = CatConverter.toDto(cat)
            Mono.zip(
                ownerRepository.getOwnersByIds(cat.getFormerOwners())
                    .map { owners: List<Owner?>? ->
                        owners!!.forEach(Consumer { owner: Owner? -> catDto.formerOwners.add(OwnerConverter.toDto(owner)) })
                        owners
                    }
                    .subscribeOn(Schedulers.parallel()), careCenterRepository.getCareCentersByIds(cat.getCareCenters())
                    .map { careCenters: List<CareCenter?>? ->
                        careCenters
                            .forEach(Consumer { careCenter: CareCenter? ->
                                catDto.careCenters.add(
                                    CareCenterConverter.toDto(
                                        careCenter
                                    )
                                )
                            })
                        careCenters
                    }
                    .subscribeOn(Schedulers.parallel())) { owners: List<Owner?>?, cares: List<CareCenter?>? -> catDto }
                .subscribeOn(Schedulers.parallel())
        }.flatMap { source: Mono<CatDto?>? -> Mono.from(source) }.subscribeOn(Schedulers.parallel())
    }

    val fullAllCats: Flux<CatDto?>
        get() = Flux.merge(getFullCatById(1L), getFullCatById(2L))
    val allCats: Flux<CatDto?>
        get() = Flux.merge(getCatById(1L), getCatById(2L))
    val fullAllCatsNonReactive: List<CatDto?>
        get() = Stream.of(catRepository.getCatByIdNonReactive(1L), catRepository.getCatByIdNonReactive(2L))
            .map { catsNonReactive: Cat? ->
                val catDto = CatConverter.toDto(catsNonReactive)
                catDto.careCenters.addAll(
                    careCenterRepository
                        .getCareCentersByIdsNonReactive(catsNonReactive.getCareCenters())
                        .stream().map { obj: CareCenter? -> CareCenterConverter.toDto() }
                        .collect(Collectors.toList()))
                catDto.formerOwners.addAll(
                    ownerRepository
                        .getOwnersByIdsNonReactive(catsNonReactive.getFormerOwners())
                        .stream().map { obj: Owner? -> OwnerConverter.toDto() }
                        .collect(Collectors.toList()))
                catDto
            }.collect(Collectors.toList())
}