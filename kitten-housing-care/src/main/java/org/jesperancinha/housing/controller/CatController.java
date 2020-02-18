package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CatDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

public interface CatController {
    @GetMapping("/{catId}")
    CatDto getCatByIdI(@PathVariable Long catId) throws IOException;
}
