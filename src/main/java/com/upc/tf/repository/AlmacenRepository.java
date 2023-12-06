package com.upc.tf.repository;

import com.upc.tf.entities.Almacen;
import org.springframework.data.repository.CrudRepository;

public interface AlmacenRepository extends CrudRepository<Almacen, Integer> {
    Almacen findByCodigo(String codigo);

    Boolean existsByCodigo(String codigo);
}
