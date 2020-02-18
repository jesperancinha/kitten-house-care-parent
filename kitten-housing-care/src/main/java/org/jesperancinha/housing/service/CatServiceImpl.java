package org.jesperancinha.housing.service;

import org.jesperancinha.housing.converter.CatConverter;
import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.model.CareCenter;
import org.jesperancinha.housing.model.Cat;
import org.jesperancinha.housing.model.Owner;
import org.jesperancinha.housing.repository.CareCenterRepository;
import org.jesperancinha.housing.repository.CatRepository;
import org.jesperancinha.housing.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    private final OwnerRepository ownerRepository;

    private final CareCenterRepository careCenterRepository;

    public CatServiceImpl(CatRepository catRepository,
                          OwnerRepository ownerRepository,
                          CareCenterRepository careCenterRepository) {
        this.catRepository = catRepository;
        this.ownerRepository = ownerRepository;
        this.careCenterRepository = careCenterRepository;
    }

    @Override
    public CatDto getCatById(Long id) throws IOException {
        return CatConverter.toDto(catRepository.getCatById(id));
    }

    @Override
    public CatDto getFullCatById(Long id) throws IOException, ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        final ForkJoinTask<Owner> forkJoinTaskOwner = forkJoinPool.submit(() -> ownerRepository.getOwnerById(1L));
        final ForkJoinTask<CareCenter> forkJoinTaskCareCenter = forkJoinPool.submit(() -> careCenterRepository.getCareCenterById(1L));
        final Owner owner = forkJoinTaskOwner.get();
        final CareCenter careCenter = forkJoinTaskCareCenter.get();
        final Cat catById = catRepository.getCatById(id);
        catById.getFormerOwners().add(owner);
        catById.getCareCenters().add(careCenter);
        return CatConverter.toDto(catById);
    }

    @Override
    public List<CatDto> getFullAllCats() throws ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        ForkJoinTask<CatDto> catForkJoinTask1 = forkJoinPool.submit(() -> getFullCatById(1L));
        ForkJoinTask<CatDto> catForkJoinTask2 = forkJoinPool.submit(() -> getFullCatById(2L));
        CatDto cat1 = catForkJoinTask1.get();
        CatDto cat2 = catForkJoinTask2.get();
        return Stream.of(cat1, cat2).collect(Collectors.toList());
    }

    @Override
    public List<CatDto> getAllCats() throws IOException {
        return Stream.of(catRepository.getCatById(1L), catRepository.getCatById(2L)).map(CatConverter::toDto).collect(Collectors.toList());
    }
}
