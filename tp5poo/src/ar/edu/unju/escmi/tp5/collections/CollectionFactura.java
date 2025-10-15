package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Factura;

import java.util.ArrayList;
import java.util.List;

public class CollectionFactura {
    public static List<Factura> facturas = new ArrayList<>();
    private static int siguienteNumero = 1;

    public static int getSiguienteNumero() {
        return siguienteNumero++;
    }

    public static boolean guardarFactura(Factura f) {
        facturas.add(f);
        return true;
    }

    public static Factura buscarFactura(int numero) {
        for (Factura f : facturas) {
            if (f.getNumero() == numero) return f;
        }
        return null;
    }

    public static List<Factura> getFacturas() {
        return facturas;
    }
}