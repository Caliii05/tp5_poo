package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Producto;

import java.util.HashMap;
import java.util.Map;

public class CollectionStock {
    
    public static Map<Integer, Integer> stockMap = new HashMap<>();

    public static void registrarProducto(Producto p) {
        stockMap.put(p.getCodigoProducto(), p.getStock());
    }

    public static void actualizarStock(Producto p) {
        stockMap.put(p.getCodigoProducto(), p.getStock());
    }

    public static Integer getStock(int codigo) {
        return stockMap.get(codigo);
    }
}