package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.service.CatService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/cats")
public class CatControllerImpl implements CatController {

    private final CatService catService;

    public CatControllerImpl(CatService catService) {
        this.catService = catService;
    }

    public CatDto getCatByIdI(@PathVariable Long catId) throws IOException, InterruptedException {
        return this.catService.getCatById(catId);
    }
}
