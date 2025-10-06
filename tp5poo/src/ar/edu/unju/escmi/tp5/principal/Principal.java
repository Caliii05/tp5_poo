package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.dominio.*;
import ar.edu.unju.escmi.tp5.collections.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Principal {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        precargaDatos();
        mostrarMenu();
    }

    private static void precargaDatos() {
        // clientes
        ClienteMayorista cm = new ClienteMayorista("Distribuciones Srl", "Av. Central 100", 20123456, 9001);
        ClienteMinorista cmi1 = new ClienteMinorista("Ana Perez", "Calle Falsa 123", 30123456, true);
        ClienteMinorista cmi2 = new ClienteMinorista("Juan Gomez", "Alameda 50", 30111111, false);
        CollectionCliente.guardarCliente(cm);
        CollectionCliente.guardarCliente(cmi1);
        CollectionCliente.guardarCliente(cmi2);

        // productos
        Producto p1 = new Producto(1001, "Fideo Knorr Spaghetti x500gr", 1200.00, 0, 5000);
        Producto p2 = new Producto(1002, "Arroz Gallo 1kg", 1500.00, 25, 2000);
        Producto p3 = new Producto(1003, "Aceite Cocina 1L", 3000.00, 0, 800);
        CollectionProducto.guardarProducto(p1);
        CollectionProducto.guardarProducto(p2);
        CollectionProducto.guardarProducto(p3);

    }

    private static void mostrarMenu() {
        EncargadoVentas encargado = new EncargadoVentas("Carlos", 40123456, "E-01");
        AdministradorVentas admin = new AdministradorVentas("María", 40111111, "A-01");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1) Mostrar todas las ventas (Encargado)");
            System.out.println("2) Mostrar total de todas las ventas (Encargado)");
            System.out.println("3) Verificar stock de un producto (Encargado)");
            System.out.println("4) Buscar factura por número (Cliente / General)");
            System.out.println("5) Alta de producto (Administrador)");
            System.out.println("6) Cargar stock de producto (Administrador)");
            System.out.println("7) Realizar venta (Administrador)");
            System.out.println("8) Listar productos");
            System.out.println("9) Listar clientes");
            System.out.println("0) Salir");
            System.out.print("Elija una opción: ");
            String opt = sc.nextLine();
            switch (opt) {
                case "1": mostrarVentas(encargado); break;
                case "2": System.out.printf("Total ventas: $%.2f\n", encargado.calcularTotalVentas()); break;
                case "3": verificarStock(encargado); break;
                case "4": buscarFactura(); break;
                case "5": altaProducto(admin); break;
                case "6": cargarStock(admin); break;
                case "7": realizarVenta(); break;
                case "8": listarProductos(); break;
                case "9": listarClientes(); break;
                case "0": salir = true; break;
                default: System.out.println("Opción inválida."); break;
            }
        }
        System.out.println("Saliendo...");
    }

    private static void mostrarVentas(EncargadoVentas encargado) {
        List<Venta> ventas = encargado.mostrarVentas();
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (Venta v : ventas) {
            System.out.println(v);
            if (v.getFactura() != null) System.out.println(v.getFactura());
        }
    }

    private static void verificarStock(EncargadoVentas encargado) {
        System.out.print("Ingrese código de producto: ");
        int codigo = Integer.parseInt(sc.nextLine());
        Producto p = encargado.verificarStock(codigo);
        if (p == null) System.out.println("Producto no encontrado.");
        else System.out.println(p);
    }

    private static void buscarFactura() {
        System.out.print("Ingrese número de factura: ");
        int num = Integer.parseInt(sc.nextLine());
        Factura f = CollectionFactura.buscarPorNumero(num);
        if (f == null) System.out.println("Factura no encontrada.");
        else System.out.println(f);
    }

    private static void altaProducto(AdministradorVentas admin) {
        try {
            System.out.print("Código producto: ");
            int cod = Integer.parseInt(sc.nextLine());
            System.out.print("Descripción: ");
            String desc = sc.nextLine();
            System.out.print("Precio unitario: ");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.print("Descuento (0,25,30): ");
            int descuento = Integer.parseInt(sc.nextLine());
            System.out.print("Stock inicial (unidades): ");
            int stock = Integer.parseInt(sc.nextLine());
            Producto p = new Producto(cod, desc, precio, descuento, stock);
            boolean ok = admin.altaProducto(p);
            if (ok) System.out.println("Producto dado de alta correctamente.");
            else System.out.println("Error: producto con ese código ya existe.");
        } catch (Exception e) {
            System.out.println("Error en datos ingresados.");
        }
    }

    private static void cargarStock(AdministradorVentas admin) {
        try {
            System.out.print("Código producto: ");
            int cod = Integer.parseInt(sc.nextLine());
            System.out.print("Cantidad a cargar: ");
            int cant = Integer.parseInt(sc.nextLine());
            boolean ok = admin.cargarStock(cod, cant);
            if (ok) System.out.println("Stock actualizado.");
            else System.out.println("Producto no encontrado.");
        } catch (Exception e) {
            System.out.println("Error en datos ingresados.");
        }
    }

    private static void realizarVenta() {
        try {
            System.out.println("----- Realizar Venta -----");
            System.out.print("Ingrese DNI del cliente (si no existe se pedirá datos para registrar cliente minorista): ");
            int dni = Integer.parseInt(sc.nextLine());
            Cliente cliente = CollectionCliente.buscarPorDni(dni);
            if (cliente == null) {
                System.out.println("Cliente no encontrado. Se creará un cliente minorista.");
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Domicilio: ");
                String dom = sc.nextLine();
                System.out.print("¿Tiene PAMI? (s/n): ");
                boolean pami = sc.nextLine().trim().equalsIgnoreCase("s");
                cliente = new ClienteMinorista(nombre, dom, dni, pami);
                CollectionCliente.guardarCliente(cliente);
            }

            Venta venta = new Venta(cliente);
            boolean seguir = true;
            final int BULTOSIZE = 10;
            while (seguir) {
                listarProductos();
                System.out.print("Ingrese código producto a vender (0 para finalizar): ");
                int cod = Integer.parseInt(sc.nextLine());
                if (cod == 0) break;
                Producto p = CollectionProducto.buscarProducto(cod);
                if (p == null) { System.out.println("Producto no existe."); continue; }
                System.out.println(p);
                System.out.print("Ingrese cantidad: ");
                int cantidad = Integer.parseInt(sc.nextLine());
                double precioUnitarioAplicado;
                int unidadesReales = cantidad;
                if (cliente instanceof ClienteMayorista) {
                    unidadesReales = cantidad * BULTOSIZE;
                    precioUnitarioAplicado = p.getPrecioUnitario() / 2.0;
                } else {
                    precioUnitarioAplicado = p.precioConDescuentoUnitario();
                }
                if (p.getStock() < unidadesReales) {
                    System.out.println("Stock insuficiente. Stock actual: " + p.getStock());
                    continue;
                }
                Detalle d = new Detalle(p, unidadesReales, precioUnitarioAplicado);
                venta.agregarDetalle(d);
                System.out.print("Agregar otro producto? (s/n): ");
                if (!sc.nextLine().trim().equalsIgnoreCase("s")) seguir = false;
            }

            if (venta.getDetalles().isEmpty()) {
                System.out.println("No se agregaron productos. Venta cancelada.");
                return;
            }
            Factura f = venta.finalizarVenta();
            System.out.println("Venta realizada. Factura generada:");
            System.out.println(f);
        } catch (Exception e) {
            System.out.println("Error en realización de venta: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void listarProductos() {
        System.out.println("=== Productos ===");
        for (Producto p : CollectionProducto.getProductos()) {
            System.out.println(p);
        }
    }

    private static void listarClientes() {
        System.out.println("=== Clientes ===");
        for (Cliente c : CollectionCliente.getClientes()) {
            System.out.println(c.mostrarDatos());
        }
    }
}