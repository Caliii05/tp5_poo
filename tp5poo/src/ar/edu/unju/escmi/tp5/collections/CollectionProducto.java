package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    public static boolean guardarProducto(Producto p) {
        
        if (buscarProducto(p.getCodigoProducto()) == null) {
            return productos.add(p);
        }
        return false;
    }

    public static Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigoProducto() == codigo) return p;
        }
        return null;
    }
}