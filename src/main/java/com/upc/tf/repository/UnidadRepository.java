package com.upc.tf.repository;

import com.upc.tf.entities.Producto;
import com.upc.tf.entities.Unidad;
import org.springframework.data.repository.CrudRepository;

public interface UnidadRepository extends CrudRepository<Unidad, Integer> {

    Unidad findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

}
