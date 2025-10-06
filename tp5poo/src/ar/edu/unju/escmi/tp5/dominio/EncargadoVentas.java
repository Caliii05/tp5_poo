package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionVenta;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import java.util.List;

public class EncargadoVentas extends Empleado {
    public EncargadoVentas(String nombre, int dni, String legajo) {
        super(nombre, dni, legajo);
    }

    public List<Venta> mostrarVentas() {
        return CollectionVenta.getVentas();
    }

    public double calcularTotalVentas() {
        return CollectionVenta.totalVentas();
    }

    public Producto verificarStock(int codigoProducto) {
        return CollectionProducto.buscarProducto(codigoProducto);
    }

}