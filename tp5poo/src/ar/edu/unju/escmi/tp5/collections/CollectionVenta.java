package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Venta;
import java.util.ArrayList;
import java.util.List;

public class CollectionVenta {
    public static List<Venta> ventas = new ArrayList<>();

    public static void guardarVenta(Venta v) {
        ventas.add(v);
    }

    public static List<Venta> getVentas() {
        return ventas;
    }

    public static double totalVentas() {
        double total = 0;
        for (Venta v : ventas) {
            if (v.getFactura() != null) total += v.getFactura().getTotal();
        }
        return total;
    }
}