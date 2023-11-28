package com.upc.tf.service;

import com.upc.tf.entities.Producto;
import com.upc.tf.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Guardar un producto en la base de datos
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    // Obtener un producto por su ID
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    // Eliminar un producto por su ID
    public void eliminarProductoPorId(Long id) {
        productoRepository.deleteById(id);
    }

    // Buscar productos por nombre
    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }
}
