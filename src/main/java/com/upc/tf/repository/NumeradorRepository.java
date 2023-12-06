package com.upc.tf.repository;

import com.upc.tf.entities.Numerador;
import org.springframework.data.repository.CrudRepository;

public interface NumeradorRepository extends CrudRepository<Numerador, Integer> {
    Numerador findBySerie(String serie);

    boolean existsBySerie(String serie);
}
