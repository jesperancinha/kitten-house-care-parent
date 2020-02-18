package org.jesperancinha.housing.service;

import org.jesperancinha.housing.converter.CatConverter;
import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public CatDto getCatById(Long id) throws IOException {
        return CatConverter.toDto(catRepository.getCatById(id));
    }
}
