package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;
import ar.edu.unju.escmi.tp5.dominio.*;

import java.util.Scanner;

public class Principal {
    private static Scanner sc = new Scanner(System.in);
    private static EncargadoVenta encargado = new EncargadoVenta("Carlos Perez", 12345678, "E-001");
    private static AdministradorVenta admin = new AdministradorVenta("Ana Gomez", 87654321, "A-001");

    public static void main(String[] args) {
        precarga();
        menu();
    }

    private static void precarga() {
        // clientes
        Cliente c1 = new ClienteMinorista("Juan Lopez", "Mitre 123", 30111222, "387-111111", true);
        Cliente c2 = new ClienteMayorista("Distribuciones SA", "Ruta 1 km 5", 30777888, "388-222222", 1001);
        CollectionCliente.guardarCliente(c1);
        CollectionCliente.guardarCliente(c2);

        // productos
        Producto p1 = new Producto(1002, "Fideo Knorr Spaghetti x500g", 1200.00, 0, 5000);
        Producto p2 = new Producto(1003, "Arroz Largo Fino x1kg", 1500.00, 25, 3000);
        CollectionProducto.guardarProducto(p1);
        CollectionProducto.guardarProducto(p2);

        // stock
        CollectionStock.registrarProducto(p1);
        CollectionStock.registrarProducto(p2);
    }

    private static void menu() {
        int opc;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Mostrar ventas");
            System.out.println("2. Mostrar total de todas las ventas");
            System.out.println("3. Verificar stock de producto (por código)");
            System.out.println("4. Alta de producto");
            System.out.println("5. Realizar venta");
            System.out.println("6. Buscar factura por N°");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1:
                    encargado.mostrarVentas();
                    break;
                case 2:
                    double total = encargado.calcularTotalVentas();
                    System.out.printf("Total de todas las ventas: $%.2f%n", total);
                    break;
                case 3:
                    System.out.print("Ingrese código de producto: ");
                    int cod = Integer.parseInt(sc.nextLine());
                    encargado.verificarStock(cod);
                    break;
                case 4:
                    altaProductoMenu();
                    break;
                case 5:
                    realizarVentaMenu();
                    break;
                case 6:
                    buscarFacturaMenu();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opc != 0);
    }

    private static void altaProductoMenu() {
        try {
            System.out.print("Código producto: ");
            int c = Integer.parseInt(sc.nextLine());
            System.out.print("Descripción: ");
            String d = sc.nextLine();
            System.out.print("Precio unitario: ");
            double p = Double.parseDouble(sc.nextLine());
            System.out.print("Descuento (0/25/30): ");
            int desc = Integer.parseInt(sc.nextLine());
            System.out.print("Stock inicial: ");
            int stock = Integer.parseInt(sc.nextLine());

            Producto prod = new Producto(c, d, p, desc, stock);
            boolean ok = admin.altaProducto(prod);
            if (ok) {
                CollectionStock.registrarProducto(prod);
                System.out.println("Producto dado de alta correctamente.");
            } else {
                System.out.println("Ya existe un producto con ese código.");
            }
        } catch (Exception ex) {
            System.out.println("Error en datos de producto: " + ex.getMessage());
        }
    }

    private static void realizarVentaMenu() {
        try {
            System.out.print("DNI del cliente: ");
            int dni = Integer.parseInt(sc.nextLine());
            Cliente cliente = CollectionCliente.buscarCliente(dni);
            if (cliente == null) {
                System.out.println("Cliente no encontrado. Debe estar registrado.");
                return;
            }
            int nro = CollectionFactura.getSiguienteNumero();
            Factura factura = new Factura(nro, cliente);

            while (true) {
                System.out.print("Ingrese código de producto (0 para terminar): ");
                int cod = Integer.parseInt(sc.nextLine());
                if (cod == 0) break;
                Producto prod = CollectionProducto.buscarProducto(cod);
                if (prod == null) {
                    System.out.println("Producto no encontrado.");
                    continue;
                }
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(sc.nextLine());

                double precioUnitario = prod.getPrecioUnitario();
                if (cliente instanceof ClienteMayorista) {
                    precioUnitario = precioUnitario / 2.0;
                }

                Detalle detalle = new Detalle(prod.getDescripcion(), cantidad, precioUnitario);
                if (prod.getDescuento() > 0) {
                    detalle.aplicarDescuento(prod.getDescuento());
                }

                if (cliente instanceof ClienteMinorista) {
                    ClienteMinorista cm = (ClienteMinorista) cliente;
                    if (cm.isPami()) {
                        detalle.aplicarDescuento(10);
                    }
                }

                // Verificar stock
                if (prod.getStock() < cantidad) {
                    System.out.println("Stock insuficiente. Disponible: " + prod.getStock());
                    continue;
                }

                prod.reducirStock(cantidad);
                CollectionStock.actualizarStock(prod);

                factura.agregarDetalle(detalle);

                System.out.println("Detalle agregado: " + detalle);
            }

            factura.calcularTotal();
            
            admin.realizarVenta(factura);

        } catch (Exception ex) {
            System.out.println("Error al realizar venta: " + ex.getMessage());
        }
    }

    private static void buscarFacturaMenu() {
        System.out.print("Número de factura: ");
        int nro = Integer.parseInt(sc.nextLine());
        Factura f = CollectionFactura.buscarFactura(nro);
        if (f == null) {
            System.out.println("Factura no encontrada.");
        } else {
            System.out.println(f);
        }
    }
}