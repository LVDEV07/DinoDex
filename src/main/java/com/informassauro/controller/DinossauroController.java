package com.informassauro.controller;


import com.informassauro.model.Dinossauro;
import com.informassauro.service.DinossauroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class DinossauroController {

    private final DinossauroService dinossauroService;

    public DinossauroController(DinossauroService dinossauroService) {
        this.dinossauroService = dinossauroService;
    }

    @GetMapping("/dinossauros")
    public List<Dinossauro> listarDinossauros (){
        return dinossauroService.dinossauros();
    }

    @GetMapping("/dinossauro/{id    }")
    public Dinossauro dinossauro(@PathVariable Long id){
        return dinossauroService.dinossauro(id);
    }

}
