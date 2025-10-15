package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Producto;

import java.util.ArrayList;
import java.util.List;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    public static boolean guardarProducto(Producto p) {
        if (buscarProducto(p.getCodigoProducto()) != null) return false;
        productos.add(p);
        return true;
    }

    public static Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigoProducto() == codigo) return p;
        }
        return null;
    }

    public static Integer getStockByCodigo(int codigo) {
        Producto p = buscarProducto(codigo);
        if (p == null) return null;
        return p.getStock();
    }

    public static List<Producto> getProductos() {
        return productos;
    }
}