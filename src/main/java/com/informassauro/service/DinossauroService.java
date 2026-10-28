package com.informassauro.service;

import com.informassauro.model.Dinossauro;
import com.informassauro.repository.DinossauroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DinossauroService {

    private final DinossauroRepository dinossauroRepository;

    public DinossauroService(DinossauroRepository dinossauroRepository) {
        this.dinossauroRepository = dinossauroRepository;
    }

    public List<Dinossauro> dinossauros(){
        return dinossauroRepository.findAll();
    }

    public Dinossauro dinossauro (Long id){
        return dinossauroRepository.findById(id).orElseThrow(() -> new RuntimeException("Dinossauro não encontrado"));
    }

    public List<Dinossauro> carnivoros(){
        return dinossauroRepository.findAllByDieta("Carnívoro");
    }  public List<Dinossauro> herbivoros(){
        return dinossauroRepository.findAllByDieta("Herbívoro");
    }  public List<Dinossauro> onivoros(){
        return dinossauroRepository.findAllByDieta("Onívoro");
    }

}
