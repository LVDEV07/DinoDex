package com.informassauro.repository;

import com.informassauro.model.Dinossauro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DinossauroRepository extends JpaRepository<Dinossauro, Long> {

}
