package org.jesperancinha.housing.service

import org.jesperancinha.housing.dao.CareCenter
import org.jesperancinha.housing.dao.CareCenterRepository
import org.jesperancinha.housing.dao.CatRepository
import org.jesperancinha.housing.dao.OwnerRepository
import org.jesperancinha.housing.dto.CatDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.util.function.Consumer
import java.util.stream.Collectors

@Service
class CatServiceImpl(
    private val catRepository: CatRepository, private val ownerRepository: OwnerRepository,
    private val careCenterRepository: CareCenterRepository
) {
    fun getCatById(id: Long): Mono<CatDto> {
        return catRepository.getCatById(id).map { cat -> cat.toDto() }
    }

    fun getFullCatById(id: Long): Mono<CatDto> {
        return catRepository.getCatById(id).map { cat ->
            val catDto = cat.toDto()
            Mono.zip(
                ownerRepository.getOwnersByIds(cat.formerOwners)
                    .map { owners ->
                        owners.forEach(Consumer { owner -> catDto.formerOwners.add(owner.toDto()) })
                        owners
                    }
                    .subscribeOn(Schedulers.parallel()), careCenterRepository.getCareCentersByIds(cat.careCenters)
                    .map { careCenters: List<CareCenter> ->
                        careCenters
                            .forEach(Consumer { careCenter ->
                                catDto.careCenters.add(careCenter.toDto())
                            })
                        careCenters
                    }
                    .subscribeOn(Schedulers.parallel())) { _, _ -> catDto }
                .subscribeOn(Schedulers.parallel())
        }.flatMap { source -> Mono.from(source) }.subscribeOn(Schedulers.parallel())
    }

    fun fullAllCats(): Flux<CatDto> = Flux.merge(getFullCatById(1L), getFullCatById(2L))
    fun allCats(): Flux<CatDto> = Flux.merge(getCatById(1L), getCatById(2L))
    fun fullAllCatsNonReactive(): List<CatDto> = listOfNotNull(catRepository.getCatByIdNonReactive(1L), catRepository.getCatByIdNonReactive(2L))
            .map { catsNonReactive ->
                val catDto = catsNonReactive.toDto()
                catDto.careCenters.addAll(
                    careCenterRepository
                        .getCareCentersByIdsNonReactive(catsNonReactive.careCenters)
                        .stream().map { careCenter -> careCenter.toDto() }
                        .collect(Collectors.toList()))
                catDto.formerOwners.addAll(
                    ownerRepository
                        .getOwnersByIdsNonReactive(catsNonReactive.formerOwners)
                        .stream().map { carer -> carer.toDto() }
                        .collect(Collectors.toList()))
                catDto
            }
}