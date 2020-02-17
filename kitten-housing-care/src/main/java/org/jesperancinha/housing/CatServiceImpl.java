package org.jesperancinha.housing;

import org.jesperancinha.housing.converter.CatConverter;
import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CatServiceImpl {

    private final CatRepository catRepository;

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public CatDto getCatById(Long id) throws IOException {
        return CatConverter.toDto(catRepository.getCatById(id));
    }
}
