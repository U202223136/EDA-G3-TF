package com.upc.tf;

import com.upc.tf.entities.*;
import com.upc.tf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TfApplication implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private MovService movService;


    @Autowired
    private NumeradorService numeradorService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ApplicationContext context;

    private final static String TITLE = "Sistema de Gestión de Inventario";

    public static void main(String[] args) {
        SpringApplication.run(TfApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (!logIn()) {
            SpringApplication.exit(context);
            return;
        }

        String code = "";

        do {
            code = menu();

            switch (code.toUpperCase()) {
                case "I" -> mantenimientoIngreso();
                case "E" -> mantenimientoEgreso();
                case "V" -> mantenimientoVenta();
                case "U" -> mantenimientoUsuario();
                case "K" -> informeKardex();
            }
        } while (!code.equalsIgnoreCase("X"));
    }

    private String menu() {
        String res;
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println(TITLE);
        System.out.println("====================================================================================================");
        System.out.println("Mantenimiento\t\t\t|Informes   \t\t|Salir (X)");
        System.out.println("- Ingreso (I)\t\t- Kardex (K) ");
        System.out.println("- Salida (E)");
        System.out.println("- Venta (V)");
        System.out.println("- Usuario (U)");
        System.out.println();
        System.out.println();

        System.out.print("Ingrese una opcion: ");
        res = sc.nextLine();

        return res;
    }

    public boolean logIn() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Iniciar session");
        System.out.println("==============================");

        String nombre = null;
        do {
            System.out.print("Ingrese nombre: ");
            nombre = sc.nextLine();
        } while (nombre == null || nombre.isEmpty());

        String clave = null;
        do {
            System.out.print("Ingrese clave: ");
            clave = sc.nextLine();
        } while (clave == null || clave.isEmpty());

        try {
            usuarioService.signin(nombre, clave);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

        return true;
    }

    public void mantenimientoUsuario() {
        boolean isRegister;

        do {
            isRegister = registerUsuario();
        } while (!isRegister);
    }

    public boolean registerUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Registro Usuario");
        System.out.println("==============================");

        String nombre = null;
        do {
            System.out.print("Ingrese nombre: ");
            nombre = sc.nextLine();
        } while (nombre == null || nombre.isEmpty());

        String clave = null;
        do {
            System.out.print("Ingrese clave: ");
            clave = sc.nextLine();
        } while (clave == null || clave.isEmpty());

        try {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setClave(clave);
            usuario.setAdmin(false);
            usuario.setActivo(true);

            usuarioService.guardar(usuario);

            System.out.println("Usuario registrado!");
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

        return true;
    }

    public void mantenimientoIngreso() {
        boolean isRegister;

        do {
            isRegister = registerIngreso();
        } while (!isRegister);
    }

    public boolean registerIngreso() {
        Scanner sc = new Scanner(System.in);

        LinkedList<Numerador> numeradores = numeradorService.numeradores();
        LinkedList<Empresa> proveedores = empresaService.empresas();
        LinkedList<Almacen> almacenes = almacenService.almacenes();

        System.out.println();
        System.out.println(TITLE);
        System.out.println("Registro Ingreso");
        System.out.println("====================================================================================================");

        System.out.println("Listado de proveedores" + proveedores);
        Empresa proveedor = null;
        do {
            System.out.print("Ingrese codigo del proveedor: ");
            String codProveedor = sc.nextLine();

            proveedor = empresaService.obtenerPorCodigo(codProveedor);

        } while (proveedor == null);

        System.out.println("Listado de Numeradores" + numeradores);
        Numerador numerador = null;
        do {
            System.out.print("Ingrese codigo del numerador: ");
            String codigoNumerdor = sc.nextLine();

            numerador = numeradorService.obtenerPorSerie(codigoNumerdor);
        } while (numerador == null);

        System.out.println("Almacenes: " + almacenes);
        Almacen almacen = null;
        do {
            System.out.print("Ingrese codigo del almacen: ");
            String codAlmacen = sc.nextLine();

            almacen = almacenService.obtenerPorCodigo(codAlmacen);
        } while (almacen == null);


        String aux = String.valueOf(numerador.getNro() + 1);
        String correlativo = "%s%s".formatted("0".repeat((7 - aux.length())), aux);

        Mov mov = new Mov();
        mov.setTipo("I");
        mov.setId_emp(proveedor.getId_emp());
        mov.setId_alm(almacen.getId_alm());
        mov.setFch_mov(new Date());
        mov.setId_num(numerador.getId_num());
        mov.setNro_mov(correlativo);

        List<MovDet> detalles = addProducto(mov);

        try {
            mov.setDetList(detalles);
            movService.guardar(mov);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

        LinkedList<Mov> movs = movService.movimientos();
        System.out.println("Movimientos: " + movs);

        return true;
    }

    public List<MovDet> addProducto(Mov mov) {
        Scanner sc = new Scanner(System.in);
        List<MovDet> dets = new LinkedList<>();

        var productos = productoService.productos();

        String res = "N";

        do {
            System.out.println("Agregar producto!");
            System.out.println();

            System.out.println("Listado de Producto");
            System.out.println(productos);

            Producto producto = null;
            do {
                System.out.print("Ingrese codigo del producto: ");
                String codProd = sc.nextLine();
                producto = productoService.obtenerPorCodigo(codProd);
            } while (producto == null);

            double cantidad = 0D;
            do {
                System.out.print("Ingrese cantidad del producto: ");
                cantidad = sc.nextDouble();
            } while (Double.isNaN(cantidad));

            double precio = 0D;
            do {
                System.out.print("Ingrese precio del producto: ");
                precio = sc.nextDouble();
            } while (Double.isNaN(precio));

            MovDet d = new MovDet();
            d.setMov(mov);
            d.setProducto(producto);
            d.setCantidad(cantidad);
            d.setPrecio(precio);
            dets.add(d);

            System.out.println("Desea agregar otro producto  Si[S] No [N] ?");
            res = sc.next();

        } while (res.equalsIgnoreCase("S"));

        return dets;
    }


    public  void mantenimientoEgreso(){

    }

    public void mantenimientoVenta(){

    }

    public void informeKardex(){

    }

    public void mantenimientoAlmacen() {
        //        System.out.println("Running...!");

        try {
            Almacen almacen = new Almacen();

            almacen.setCodigo("A03");
            almacen.setDescripcion("Almacen Delivery");
            almacenService.guardar(almacen);

        } catch (Exception e) {
            System.out.println(e.toString());
        }


        LinkedList<Almacen> almacens = almacenService.almacenes();
        System.out.println("almacenes:  " + almacens);

    }


}
