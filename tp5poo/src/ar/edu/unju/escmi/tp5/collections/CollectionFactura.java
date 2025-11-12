package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Factura;

public class CollectionFactura {
    public static List<Factura> facturas = new ArrayList<>();

    public static boolean guardarFactura(Factura f) {
        return facturas.add(f);
    }

    public static Factura buscarFactura(int numero) {
        for (Factura f : facturas) {
            if (f.getNumero() == numero) return f;
        }
        return null;
    }

    public static double calcularTotalVentas() {
        double suma = 0.0;
        for (Factura f : facturas) {
            suma += f.calcularTotal();
        }
        return suma;
    }
}