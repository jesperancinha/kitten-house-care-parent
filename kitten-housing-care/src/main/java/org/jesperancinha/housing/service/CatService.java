package org.jesperancinha.housing.service;

import org.jesperancinha.housing.data.CatDto;

import java.io.IOException;

public interface CatService {
    CatDto getCatById(Long id) throws IOException, InterruptedException;
}
