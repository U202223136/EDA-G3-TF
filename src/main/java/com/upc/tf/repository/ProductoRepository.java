package com.upc.tf.repository;

import com.upc.tf.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    Producto findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);
}
