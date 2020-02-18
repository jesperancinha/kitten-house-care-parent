package org.jesperancinha.housing.controller;

import org.jesperancinha.housing.data.CatDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/cats")
public interface CatController {
    @GetMapping("/{catId}")
    CatDto getCatByIdI(@PathVariable Long catId) throws IOException, InterruptedException;
}
