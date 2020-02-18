package org.jesperancinha.housing.service;

import org.jesperancinha.housing.data.CatDto;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface CatService {
    CatDto getCatById(Long id) throws IOException;

    CatDto getFullCatById(Long id) throws IOException, ExecutionException, InterruptedException;
}
