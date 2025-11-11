package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Factura;

public class CollectionFactura {
    public static List<Factura> facturas = new ArrayList<>();

    public static void agregarFactura(Factura f) {
        facturas.add(f);
    }

    public static Factura buscarPorNumero(int numero) {
        for (Factura f : facturas) {
            if (f.toString().contains("Factura N° " + numero))
                return f;
        }
        return null;
    }

    public static double totalVentas() {
        double total = 0;
        for (Factura f : facturas)
            total += f.calcularTotal();
        return total;
    }
}