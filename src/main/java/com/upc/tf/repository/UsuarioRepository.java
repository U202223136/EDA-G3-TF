package com.upc.tf.repository;

import com.upc.tf.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    Usuario findByNombreAndClave(String nombre, String clave);

}
