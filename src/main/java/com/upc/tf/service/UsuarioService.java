package com.upc.tf.service;

import com.upc.tf.entities.Usuario;
import com.upc.tf.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public LinkedList<Usuario> usuarios() {
        List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();

        return new LinkedList<>(list);
    }

    public Usuario guardar(Usuario usuario) throws Exception {
        if (usuarioRepository.existsByNombre(usuario.getNombre())) {
            throw new Exception("Ya existe un usuario con el nombre: " + usuario.getNombre());
        }

        usuario.encriptar();
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario signin(String nombre, String clave) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setClave(clave);

        usuario.encriptar();
        Usuario usu = usuarioRepository.findByNombreAndClave(nombre, usuario.getClave());

        if (usu == null) throw new Exception("Acceso denegado!" );

        return usu;
    }

}
