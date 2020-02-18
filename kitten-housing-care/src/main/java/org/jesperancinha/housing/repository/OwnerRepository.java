package org.jesperancinha.housing.repository;

import org.jesperancinha.housing.model.Owner;

import java.io.IOException;

public interface OwnerRepository {
    Owner getOwnerById(Long id) throws IOException;
}
