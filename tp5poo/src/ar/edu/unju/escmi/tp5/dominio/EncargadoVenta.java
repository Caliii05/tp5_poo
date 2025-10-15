package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;

import java.util.List;

public class EncargadoVenta extends Empleado {

    public EncargadoVenta(String nombre, int dni, String legajo) {
        super(nombre, dni, legajo);
    }

    @Override
    public void mostrarVentas() {
        List<Factura> facturas = CollectionFactura.getFacturas();
        System.out.println("----- LISTADO DE VENTAS -----");
        for (Factura f : facturas) {
            System.out.printf("N°%d - Fecha: %s - Cliente: %s - Total: $%.2f%n",
                    f.getNumero(), f.getFecha(), f.getCliente().getNombre(), f.getTotal());
        }
    }

    public void verificarStock(int codigoProducto) {
        Integer stock = CollectionProducto.getStockByCodigo(codigoProducto);
        if (stock == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.printf("Stock del producto %d: %d unidades.%n", codigoProducto, stock);
        }
    }

    public double calcularTotalVentas() {
        double suma = 0;
        for (Factura f : CollectionFactura.getFacturas()) {
            suma += f.getTotal();
        }
        return suma;
    }
}