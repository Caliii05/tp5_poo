package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Factura;
import java.util.ArrayList;
import java.util.List;

public class CollectionFactura {
    public static List<Factura> facturas = new ArrayList<>();
    private static int ultimoNumero = 0;

    public static void guardarFactura(Factura f) {
        facturas.add(f);
        if (f.getNumero() > ultimoNumero) ultimoNumero = f.getNumero();
    }

    public static Factura buscarPorNumero(int numero) {
        for (Factura f : facturas) {
            if (f.getNumero() == numero) return f;
        }
        return null;
    }

    public static int siguienteNumero() {
        ultimoNumero++;
        return ultimoNumero;
    }

    public static List<Factura> getFacturas() {
        return facturas;
    }
}