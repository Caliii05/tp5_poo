package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;

public class EncargadoVenta extends Empleado {

    public EncargadoVenta(String nombre, int dni, String legajo, int idEmpleado) {
        super(nombre, dni, legajo, idEmpleado);
    }

    public void mostrarVentas() {
        System.out.println("=== LISTADO DE FACTURAS ===");
        for (Factura f : CollectionFactura.facturas) {
            System.out.println(f);
            System.out.println("---------------------------");
        }
    }

    public void verificarStock(int codigoProducto) {
        Stock s = CollectionStock.buscarPorProducto(codigoProducto);
        if (s == null) {
            System.out.println("Producto no encontrado en stock.");
        } else {
            System.out.println(s);
        }
    }

    public double calcularTotalVentas() {
        return CollectionFactura.calcularTotalVentas();
    }
}