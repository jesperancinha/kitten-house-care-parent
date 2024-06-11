package org.jesperancinha.kittens.service

import kotlinx.coroutines.flow.*
import org.jesperancinha.kittens.dao.CareCenter
import org.jesperancinha.kittens.dao.CareCenterRepository
import org.jesperancinha.kittens.dao.CatRepository
import org.jesperancinha.kittens.dao.OwnerRepository
import org.jesperancinha.kittens.dto.CatDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.util.function.Consumer
import java.util.stream.Collectors

@Service
class CatService(
    private val catRepository: CatRepository, private val ownerRepository: OwnerRepository,
    private val careCenterRepository: CareCenterRepository
) {
    fun getCatById(id: Long) = catRepository.getCatById(id)?.toDto()

    fun getFullCatById(id: Long): CatDto? {
        return catRepository.getCatById(id)?.let { cat ->
            cat.toDto().let { catDto ->
                catDto.formerOwners.addAll(ownerRepository.getOwnersByIds(cat.formerOwners)
                    .map { it.toDto() })
            }
            careCenterRepository.getCareCentersByIds(cat.careCenters)
                .map { it.toDto() }
            cat.toDto()
        }
    }

    fun fullAllCats(): Flow<CatDto> = flowOf(requireNotNull(getFullCatById(1L)), requireNotNull(getFullCatById(2L)))
    fun allCats(): Flow<CatDto> = flowOf(requireNotNull(getCatById(1L)), requireNotNull(getCatById(2L)))
    fun fullAllCatsNonReactive(): Flow<CatDto> =
        flowOf(catRepository.getCatByIdNonReactive(1L), catRepository.getCatByIdNonReactive(2L))
            .filterNotNull().mapNotNull { catsNonReactive ->
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