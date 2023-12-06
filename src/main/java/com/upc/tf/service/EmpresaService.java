package com.upc.tf.service;

import com.upc.tf.entities.Empresa;
import com.upc.tf.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public LinkedList<Empresa> empresas() {
        List<Empresa> list = (List<Empresa>) empresaRepository.findAll();

        return new LinkedList<>(list);
    }

    public void guardar(Empresa empresa) throws Exception {
        if (empresaRepository.existsByCodigo(empresa.getCodigo())) {
            throw new Exception("Ya existe un registro con el codigo: " + empresa.getCodigo());
        }

        empresaRepository.save(empresa);
    }

    public Empresa obtenerPorId(Integer id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public Empresa obtenerPorCodigo(String codigo) {
        return empresaRepository.findByCodigo(codigo);
    }

    public void eliminar(Integer id) {
        empresaRepository.deleteById(id);
    }

}
