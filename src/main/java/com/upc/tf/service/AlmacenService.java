package com.upc.tf.service;

import com.upc.tf.entities.Almacen;
import com.upc.tf.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AlmacenService {

//    @Autowired
//    private AlmacenRepository almacenRepository;

    private final AlmacenRepository almacenRepository;

    @Autowired
    public AlmacenService(AlmacenRepository almacenRepository) {
        this.almacenRepository = almacenRepository;
    }

    public LinkedList<Almacen> almacenes() {
        List<Almacen> list = (List<Almacen>) almacenRepository.findAll();

        return new LinkedList<>(list);
    }

    public void guardar(Almacen almacen) throws Exception {
        if (almacenRepository.existsByCodigo(almacen.getCodigo()) ) {
            throw new Exception("Ya existe almacen con el codigo: " + almacen.getCodigo());
        }

        almacenRepository.save(almacen);
    }

    public Almacen obtenerPorId(Integer id) {
        return almacenRepository.findById(id).orElse(null);
    }

    public Almacen obtenerPorCodigo(String codigo) {
        return almacenRepository.findByCodigo(codigo);
    }

    public void eliminar(Integer id) {
        almacenRepository.deleteById(id);
    }

}
