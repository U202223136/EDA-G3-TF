package com.upc.tf.service;

import com.upc.tf.entities.Empresa;
import com.upc.tf.entities.Numerador;
import com.upc.tf.repository.EmpresaRepository;
import com.upc.tf.repository.NumeradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class NumeradorService {

    @Autowired
    private NumeradorRepository numeradorRepository;

    public LinkedList<Numerador> numeradores() {
        List<Numerador> list = (List<Numerador>) numeradorRepository.findAll();

        return new LinkedList<>(list);
    }

    public void guardar(Numerador numerador) throws Exception {
        if (numeradorRepository.existsBySerie(numerador.getSerie())) {
            throw new Exception("Ya existe un registro con el serie: " + numerador.getSerie());
        }

        numeradorRepository.save(numerador);
    }

    public Numerador obtenerPorId(Integer id) {
        return numeradorRepository.findById(id).orElse(null);
    }

    public Numerador obtenerPorSerie(String serie) {
        return numeradorRepository.findBySerie(serie);
    }

    public void eliminar(Integer id) {
        numeradorRepository.deleteById(id);
    }
}
