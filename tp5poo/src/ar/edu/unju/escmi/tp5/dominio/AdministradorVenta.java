package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;

public class AdministradorVenta extends Empleado {

    public AdministradorVenta(String nombre, int dni, String legajo, int idEmpleado) {
        super(nombre, dni, legajo, idEmpleado);
    }

    public boolean altaProducto(Producto p, int stockInicial) {
        if (CollectionProducto.buscarProducto(p.getCodigoProducto()) == null) {
            CollectionProducto.guardarProducto(p);
            CollectionStock.agregarStock(new Stock(p, stockInicial));
            return true;
        } else {
            System.out.println("El producto ya existe.");
            return false;
        }
    }

    public double calcularComision(double totalVentas, double porcentaje) {
        return totalVentas * porcentaje / 100.0;
    }
}