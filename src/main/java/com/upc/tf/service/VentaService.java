package com.upc.tf.service;

import com.upc.tf.entities.Mov;
import com.upc.tf.entities.Venta;
import com.upc.tf.repository.MovRepository;
import com.upc.tf.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public LinkedList<Venta> ventas() {
        List<Venta> list = (List<Venta>) ventaRepository.findAll();

        return new LinkedList<>(list);
    }

    public Venta guardar(Venta venta) throws Exception {
//        if (movRepository.existsByCodigo(mov.getCodigo())) {
//            throw new Exception("Ya existe un registro con el codigo: " + documento.getCodigo());
//        }

        return ventaRepository.save(venta);
    }

    public Venta obtenerPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

//    public Mov obtenerPorCodigo(String codigo) {
//        return movRepository.findByCodigo(codigo);
//    }

    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);
    }
}
