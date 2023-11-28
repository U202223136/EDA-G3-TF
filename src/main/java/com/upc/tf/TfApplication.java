package com.upc.tf;

import com.upc.tf.entities.Producto;
import com.upc.tf.entities.Usuario;
import com.upc.tf.service.ProductoService;
import com.upc.tf.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TfApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(TfApplication.class, args);
	}

	@Autowired
	private ProductoService productoService;


	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(String... args) throws Exception {

//		Producto productoNew = new Producto();
//		productoNew.setNombre("Producto Nuevo");
//		productoNew.setPrecio(25.88);
//		productoService.guardarProducto(productoNew);
//
//		Usuario nuevoUsuario = new Usuario("Jhonny", "Clave22");
//		usuarioService.guardarUsuario(nuevoUsuario);

//		// Obtener un producto por su ID
//		Optional<Producto> productoRecuperado = productoService.obtenerProductoPorId(1L);
//		System.out.println("Producto recuperado por ID: " + productoRecuperado.orElse(null));

		// Obtener todos los productos
		List<Producto> todosLosProductos = productoService.obtenerTodosLosProductos();
		System.out.println("Productos: " + todosLosProductos);

		// Eliminar un producto por su ID
//		productoService.eliminarProductoPorId(1L);

		Iterable<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
		System.out.println("Usuarios: " + usuarios);

	}
}
