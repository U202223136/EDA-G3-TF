package com.upc.tf.service;

import com.upc.tf.entities.Empresa;
import com.upc.tf.entities.Producto;
import com.upc.tf.repository.EmpresaRepository;
import com.upc.tf.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public LinkedList<Producto> productos() {
        List<Producto> list = (List<Producto>) productoRepository.findAll();

        return new LinkedList<>(list);
    }

    public void guardar(Producto producto) throws Exception {
        if (productoRepository.existsByCodigo(producto.getCodigo())) {
            throw new Exception("Ya existe un registro con el codigo: " + producto.getCodigo());
        }

        productoRepository.save(producto);
    }

    public Producto obtenerPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto obtenerPorCodigo(String codigo) {
        return productoRepository.findByCodigo(codigo);
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

}
