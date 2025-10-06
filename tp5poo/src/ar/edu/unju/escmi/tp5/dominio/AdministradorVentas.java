package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionProducto;

public class AdministradorVentas extends Empleado {
    public AdministradorVentas(String nombre, int dni, String legajo) {
        super(nombre, dni, legajo);
    }

    public boolean altaProducto(Producto p) {
        if (CollectionProducto.buscarProducto(p.getCodigoProducto()) != null) {
            return false;
        }
        CollectionProducto.guardarProducto(p);
        return true;
    }

    public boolean cargarStock(int codigoProducto, int cantidad) {
        Producto p = CollectionProducto.buscarProducto(codigoProducto);
        if (p == null) return false;
        p.aumentarStock(cantidad);
        return true;
    }

}