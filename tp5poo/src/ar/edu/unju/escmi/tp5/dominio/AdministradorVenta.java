package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;

public class AdministradorVenta extends Empleado {

    public AdministradorVenta(String nombre, int dni, String legajo) {
        super(nombre, dni, legajo);
    }

    @Override
    public void mostrarVentas() {
        
        for (Factura f : CollectionFactura.getFacturas()) {
            System.out.println(f);
        }
    }

    public boolean altaProducto(Producto p) {
        return CollectionProducto.guardarProducto(p);
    }

    public void realizarVenta(Factura factura) {
        
        CollectionFactura.guardarFactura(factura);
        System.out.printf("Venta realizada. Factura N° %d total $%.2f%n", factura.getNumero(), factura.getTotal());
    }

    public void cargarStock(int codigoProducto, int cantidad) {
        Producto p = CollectionProducto.buscarProducto(codigoProducto);
        if (p == null) {
            System.out.println("Producto no existe, no se puede cargar stock.");
        } else {
            p.aumentarStock(cantidad);
            System.out.printf("Se cargaron %d unidades al producto %d. Nuevo stock: %d%n",
                    cantidad, codigoProducto, p.getStock());
        }
    }
}