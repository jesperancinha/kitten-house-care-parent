package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CatDto;
import org.jesperancinha.housing.service.CatService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/cats")
public class CatControllerImpl implements CatController {

    private final CatService catService;

    public CatControllerImpl(CatService catService) {
        this.catService = catService;
    }

   public List<CatDto> getAllCats() throws ExecutionException, InterruptedException, IOException {
        return this.catService.getAllCats();
    }

   public List<CatDto> getFullAllCats() throws ExecutionException, InterruptedException {
        return this.catService.getFullAllCats();
    }

    public CatDto getCatByIdI(@PathVariable Long catId) throws IOException {
        return this.catService.getCatById(catId);
    }

    public CatDto getFullCatById(@PathVariable Long catId) throws IOException, ExecutionException, InterruptedException {
        return this.catService.getFullCatById(catId);
    }
}
