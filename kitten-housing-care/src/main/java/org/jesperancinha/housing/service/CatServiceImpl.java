package org.jesperancinha.housing.service;

import org.jesperancinha.housing.converter.CatConverter;
import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.model.Cat;
import org.jesperancinha.housing.model.Owner;
import org.jesperancinha.housing.repository.CatRepository;
import org.jesperancinha.housing.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    private final OwnerRepository ownerRepository;

    public CatServiceImpl(CatRepository catRepository, OwnerRepository ownerRepository) {
        this.catRepository = catRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public CatDto getCatById(Long id) throws IOException {
        return CatConverter.toDto(catRepository.getCatById(id));
    }

    @Override
    public CatDto getFullCatById(Long id) throws IOException, ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        final ForkJoinTask<Owner> forkJoinTask = forkJoinPool.submit(() -> ownerRepository.getOwnerById(1L));
        final Owner owner = forkJoinTask.get();
        final Cat catById = catRepository.getCatById(id);
        catById.getFormerOwners().add(owner);
        return CatConverter.toDto(catById);
    }
}
