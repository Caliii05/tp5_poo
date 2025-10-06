package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Producto;
import java.util.ArrayList;
import java.util.List;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    public static void guardarProducto(Producto p) {
        productos.add(p);
    }

    public static Producto buscarProducto(int codigoProducto) {
        for (Producto p : productos) {
            if (p.getCodigoProducto() == codigoProducto) return p;
        }
        return null;
    }

    public static List<Producto> getProductos() {
        return productos;
    }
}