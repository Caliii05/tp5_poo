package ar.edu.unju.escmi.tp5.principal;

import java.util.Scanner;
import ar.edu.unju.escmi.tp5.collections.*;
import ar.edu.unju.escmi.tp5.dominio.*;

public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static int nroFacturaSiguiente = 1;

    public static void main(String[] args) {
        precargaDatos();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== SISTEMA DE VENTAS TP5 ===");
            System.out.println("1. Encargado de Ventas");
            System.out.println("2. Administrador de Venta");
            System.out.println("3. Cliente (buscar factura)");
            System.out.println("4. Mostrar total de ventas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    menuEncargado();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 3:
                    menuCliente();
                    break;
                case 4:
                    System.out.println("Total ventas: $" + CollectionFactura.calcularTotalVentas());
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    private static void precargaDatos() {
        // productos
        Producto p1 = new Producto(1001, "Fideo Knorr Spaghetti x500g", 1200.0, 0, 5000);
        Producto p2 = new Producto(1002, "Arroz X 1kg", 1500.0, 25, 3000);
        Producto p3 = new Producto(1003, "Aceite 900ml", 2500.0, 30, 2000);
        CollectionProducto.guardarProducto(p1);
        CollectionProducto.guardarProducto(p2);
        CollectionProducto.guardarProducto(p3);

        // stock (sincronizado)
        CollectionStock.agregarStock(new Stock(p1, 5000));
        CollectionStock.agregarStock(new Stock(p2, 3000));
        CollectionStock.agregarStock(new Stock(p3, 2000));

        // clientes
        ClienteMayorista cm = new ClienteMayorista("Distribuciones SA", "Av. Central 100", 20123456, 388123456, 1, 0);
        ClienteMinorista cmin = new ClienteMinorista("Lucia Gomez", "Calle 1", 40123456, 388654321, true, 10.0);
        CollectionCliente.guardarCliente(cm);
        CollectionCliente.guardarCliente(cmin);

        // opcional: empleados
        EncargadoVenta ev = new EncargadoVenta("Juan Perez", 30123456, "LEG001", 1);
        AdministradorVenta av = new AdministradorVenta("Maria Diaz", 31123456, "LEG002", 2);
        CollectionEmpleado.agregarEmpleado(ev);
        CollectionEmpleado.agregarEmpleado(av);

        // precargar una factura de ejemplo
        Factura f = new Factura(nroFacturaSiguiente++, cmin);
        Detalle d1 = new Detalle(p1, 2, p1.getPrecioUnitario()); // 2 unidades
        f.agregarDetalle(d1);
        CollectionFactura.guardarFactura(f);
        cmin.agregarFactura(f);
    }

    private static void menuEncargado() {
        EncargadoVenta e = (EncargadoVenta) CollectionEmpleado.buscarEmpleadoPorId(1);
        if (e == null) e = new EncargadoVenta("Encargado Default", 0, "LEG0", 1);
        boolean back = false;
        while (!back) {
            System.out.println("\n--- MENÚ Encargado de Ventas ---");
            System.out.println("1. Mostrar ventas");
            System.out.println("2. Verificar stock por código");
            System.out.println("3. Calcular total de ventas");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            int op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    e.mostrarVentas();
                    break;
                case 2:
                    System.out.print("Ingresar código producto: ");
                    int cod = Integer.parseInt(sc.nextLine());
                    e.verificarStock(cod);
                    break;
                case 3:
                    System.out.println("Total ventas: $" + e.calcularTotalVentas());
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void menuAdministrador() {
        AdministradorVenta admin = (AdministradorVenta) CollectionEmpleado.buscarEmpleadoPorId(2);
        if (admin == null) admin = new AdministradorVenta("Admin Default", 0, "LEG0", 2);
        boolean back = false;
        while (!back) {
            System.out.println("\n--- MENÚ Administrador de Ventas ---");
            System.out.println("1. Alta de producto");
            System.out.println("2. Realizar venta");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            int op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    altaProductoFlow(admin);
                    break;
                case 2:
                    realizarVentaFlow();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void altaProductoFlow(AdministradorVenta admin) {
        try {
            System.out.print("Código producto: ");
            int cod = Integer.parseInt(sc.nextLine());
            System.out.print("Descripción: ");
            String desc = sc.nextLine();
            System.out.print("Precio unitario: ");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.print("Descuento (0/25/30): ");
            int descPor = Integer.parseInt(sc.nextLine());
            System.out.print("Stock inicial (unidades): ");
            int stock = Integer.parseInt(sc.nextLine());
            Producto p = new Producto(cod, desc, precio, descPor, stock);
            boolean ok = admin.altaProducto(p, stock);
            if (ok) System.out.println("Producto dado de alta OK.");
            else System.out.println("No se pudo dar de alta (posible duplicado).");
        } catch (Exception ex) {
            System.out.println("Error en datos: " + ex.getMessage());
        }
    }

    private static void realizarVentaFlow() {
        try {
            System.out.print("DNI cliente: ");
            int dni = Integer.parseInt(sc.nextLine());
            Cliente cliente = CollectionCliente.buscarClientePorDni(dni);
            if (cliente == null) {
                System.out.println("Cliente no encontrado. Debe crearlo primero.");
                return;
            }
            Factura factura = new Factura(nroFacturaSiguiente++, cliente);
            boolean agregarMas = true;
            while (agregarMas) {
                System.out.print("Código producto: ");
                int cod = Integer.parseInt(sc.nextLine());
                Producto prod = CollectionProducto.buscarProducto(cod);
                if (prod == null) {
                    System.out.println("Producto no encontrado.");
                    continue;
                }
                Stock stock = CollectionStock.buscarPorProducto(cod);
                System.out.print("Cantidad (si es mayorista ingresar bultos? -> ver nota): ");
                int cantidad = Integer.parseInt(sc.nextLine());
                // Si cliente es mayorista: se supone que ingresa cantidad en bultos (10 unidades cada bulto)
                int cantidadFinal = cantidad;
                double precioUnitarioAplicado = prod.getPrecioUnitario();
                if (cliente instanceof ClienteMayorista) {
                    // se interpreta cantidad ingresada como bultos
                    cantidadFinal = cantidad * 10;
                    // precio unitario mitad
                    precioUnitarioAplicado = prod.getPrecioUnitario() / 2.0;
                } else {
                    // cliente minorista: precio unitario normal pero si producto tiene descuento aplicarlo al precioUnitario
                    if (prod.getDescuento() > 0) {
                        precioUnitarioAplicado = prod.calcularPrecioConDescuento();
                    }
                }

                if (stock == null || stock.getCantidad() < cantidadFinal) {
                    System.out.println("Stock insuficiente. Disponible: " + (stock == null ? 0 : stock.getCantidad()));
                    continue;
                }

                Detalle d = new Detalle(prod, cantidadFinal, precioUnitarioAplicado);
                factura.agregarDetalle(d);
                // actualizar stock
                stock.actualizarStock(cantidadFinal);
                System.out.println("Artículo agregado: " + d);

                System.out.print("Agregar otro producto? (s/n): ");
                String r = sc.nextLine();
                if (!r.equalsIgnoreCase("s")) agregarMas = false;
            }

            double total = factura.calcularTotal();
            System.out.println("Total factura: $" + total);
            System.out.print("Ingrese monto recibido (efectivo): ");
            double monto = Double.parseDouble(sc.nextLine());
            double cambio = cliente.realizarPago(monto, total);
            if (cambio >= 0) {
                // guardar factura
                CollectionFactura.guardarFactura(factura);
                cliente.agregarFactura(factura);
                System.out.println("Venta registrada. Factura N° " + factura.getNumero());
            } else {
                System.out.println("Venta cancelada por pago insuficiente.");
            }

        } catch (Exception ex) {
            System.out.println("Error en la venta: " + ex.getMessage());
        }
    }

    private static void menuCliente() {
        System.out.print("Ingresar DNI del cliente para buscar factura: ");
        int dni = Integer.parseInt(sc.nextLine());
        Cliente c = CollectionCliente.buscarClientePorDni(dni);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Ingrese número de factura: ");
        int nro = Integer.parseInt(sc.nextLine());
        Factura f = c.buscarFactura(nro);
        if (f != null) {
            System.out.println(f);
        } else {
            System.out.println("Factura no encontrada para este cliente.");
        }
    }
}