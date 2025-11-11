package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.*;

public class CollectionStock {
    public static List<Stock> stocks = new ArrayList<>();

    public static void precargar() {
        for (Producto p : CollectionProducto.productos) {
            stocks.add(new Stock(p, 5000));
        }
    }

    public static Stock buscarPorProducto(int codigo) {
        for (Stock s : stocks) {
            if (s.getProducto().getCodigo() == codigo)
                return s;
        }
        return null;
    }
}