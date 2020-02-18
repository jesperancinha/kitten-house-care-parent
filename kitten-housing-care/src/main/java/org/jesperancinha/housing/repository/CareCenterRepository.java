package org.jesperancinha.housing.repository;

import org.jesperancinha.housing.model.CareCenter;
import org.jesperancinha.housing.model.Owner;

import java.io.IOException;

public interface CareCenterRepository {
    CareCenter getCareCenterById(Long id) throws IOException;
}
