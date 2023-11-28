package com.upc.tf.repository;

import com.upc.tf.entities.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    List<Producto> findByNombre (String nombre);

}
