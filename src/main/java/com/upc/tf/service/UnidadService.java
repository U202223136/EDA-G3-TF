package com.upc.tf.service;

import com.upc.tf.entities.Unidad;
import com.upc.tf.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UnidadService {

    @Autowired
    private UnidadRepository unidadRepository;

    public LinkedList<Unidad> unidades() {
        List<Unidad> list = (List<Unidad>) unidadRepository.findAll();

        return new LinkedList<>(list);
    }

    public void guardar(Unidad unidad) throws Exception {
        if (unidadRepository.existsByCodigo(unidad.getCodigo())) {
            throw new Exception("Ya existe un registro con el codigo: " + unidad.getCodigo());
        }

        unidadRepository.save(unidad);
    }

    public Unidad obtenerPorId(Integer id) {
        return unidadRepository.findById(id).orElse(null);
    }

    public Unidad obtenerPorCodigo(String codigo) {
        return unidadRepository.findByCodigo(codigo);
    }

    public void eliminar(Integer id) {
        unidadRepository.deleteById(id);
    }

}
