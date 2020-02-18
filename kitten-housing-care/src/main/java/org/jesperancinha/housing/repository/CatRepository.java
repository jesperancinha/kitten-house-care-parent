package org.jesperancinha.housing.repository;

import org.jesperancinha.housing.model.Cat;

import java.io.IOException;

public interface CatRepository {
    Cat getCatById(Long id) throws IOException, InterruptedException;
}
