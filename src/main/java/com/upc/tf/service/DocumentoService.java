package com.upc.tf.service;

import com.upc.tf.entities.Documento;
import com.upc.tf.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public LinkedList<Documento> documentos() {
        List<Documento> list = (List<Documento>) documentoRepository.findAll();

        return new LinkedList<>(list);
    }

    public void guardar(Documento documento) throws Exception {
        if (documentoRepository.existsByCodigo(documento.getCodigo())) {
            throw new Exception("Ya existe un registro con el codigo: " + documento.getCodigo());
        }

        documentoRepository.save(documento);
    }

    public Documento obtenerPorId(Integer id) {
        return documentoRepository.findById(id).orElse(null);
    }

    public Documento obtenerPorCodigo(String codigo) {
        return documentoRepository.findByCodigo(codigo);
    }

    public void eliminar(Integer id) {
        documentoRepository.deleteById(id);
    }


}
