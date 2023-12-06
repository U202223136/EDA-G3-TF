package com.upc.tf.repository;

import com.upc.tf.entities.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
    Empresa findByCodigo(String codigo);

    Boolean existsByCodigo(String codigo);
}
