package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    public static void precargar() {
        productos.add(new Producto(1001, "Fideos Knorr Spaghetti 500g", 1200, 0));
        productos.add(new Producto(1002, "Arroz Gallo Oro 1kg", 1500, 25));
        productos.add(new Producto(1003, "Aceite Natura 900ml", 2500, 30));
    }

    public static Producto buscarPorCodigo(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo)
                return p;
        }
        return null;
    }
}