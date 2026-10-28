package com.informassauro.controller;


import com.informassauro.model.Dinossauro;
import com.informassauro.service.DinossauroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:8081")
public class DinossauroController {

    private final DinossauroService dinossauroService;

    public DinossauroController(DinossauroService dinossauroService) {
        this.dinossauroService = dinossauroService;
    }

    @GetMapping("/dinossauros")
    public List<Dinossauro> listarDinossauros (){
        return dinossauroService.dinossauros();
    }

    @GetMapping("/dinossauro/{id}")
    public Dinossauro dinossauro(@PathVariable Long id){
        return dinossauroService.dinossauro(id);

    }

    @GetMapping("/carnivoros")
    public List<Dinossauro> carnivoros (){
        return dinossauroService.carnivoros();
    }

    @GetMapping("/herbivoros")
    public List<Dinossauro> herbivoros (){
        return dinossauroService.herbivoros();
    }

    @GetMapping("/onivoros")
    public List<Dinossauro> onivoros (){
        return dinossauroService.onivoros();
    }



}
