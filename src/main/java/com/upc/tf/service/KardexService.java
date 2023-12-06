package com.upc.tf.service;

import com.upc.tf.entities.Kardex;
import com.upc.tf.repository.KardexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KardexService {

    @Autowired
    private KardexRepository kardexRepository;

    public LinkedList<Kardex> kardexs() {
        List<Kardex> list = (List<Kardex>) kardexRepository.findAll();

        return new LinkedList<>(list);
    }

    public Kardex guardar(Kardex kardex) throws Exception {
//        if (movRepository.existsByCodigo(mov.getCodigo())) {
//            throw new Exception("Ya existe un registro con el codigo: " + documento.getCodigo());
//        }

        return kardexRepository.save(kardex);
    }

    public Kardex obtenerPorId(Integer id) {
        return kardexRepository.findById(id).orElse(null);
    }

//    public Kardex obtenerPorCodigo(String codigo) {
//        return kardexRepository.findByCodigo(codigo);
//    }

    public void eliminar(Integer id) {
        kardexRepository.deleteById(id);
    }

}
