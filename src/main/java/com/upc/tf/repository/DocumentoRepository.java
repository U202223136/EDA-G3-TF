package com.upc.tf.repository;

import com.upc.tf.entities.Documento;
import org.springframework.data.repository.CrudRepository;

public interface DocumentoRepository extends CrudRepository<Documento, Integer> {
    Documento findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);
}
