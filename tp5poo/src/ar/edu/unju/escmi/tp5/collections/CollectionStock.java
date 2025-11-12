package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Stock;
import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionStock {
    public static List<Stock> stocks = new ArrayList<>();

    public static void agregarStock(Stock s) {
        stocks.add(s);
    }

    public static Stock buscarPorProducto(int codigoProducto) {
        for (Stock s : stocks) {
            if (s.getProducto().getCodigoProducto() == codigoProducto) return s;
        }
        return null;
    }
}