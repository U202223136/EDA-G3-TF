package com.upc.tf.service;

import com.upc.tf.entities.Mov;
import com.upc.tf.repository.MovRepository;
import com.upc.tf.repository.NumeradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MovService {

    @Autowired
    private MovRepository movRepository;

    @Autowired
    private NumeradorRepository numeradorRepository;

    public LinkedList<Mov> movimientos() {
        List<Mov> list = (List<Mov>) movRepository.findAll();

        return new LinkedList<>(list);
    }

    public Mov guardar(Mov mov) throws Exception {
//        if (movRepository.existsByCodigo(mov.getCodigo())) {
//            throw new Exception("Ya existe un registro con el codigo: " + documento.getCodigo());
//        }



        return movRepository.save(mov);
    }

    public Mov obtenerPorId(Integer id) {
        return movRepository.findById(id).orElse(null);
    }

//    public Mov obtenerPorCodigo(String codigo) {
//        return movRepository.findByCodigo(codigo);
//    }

    public void eliminar(Integer id) {
        movRepository.deleteById(id);
    }

}
