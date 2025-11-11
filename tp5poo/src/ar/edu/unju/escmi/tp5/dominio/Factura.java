package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int numero;
    private LocalDate fecha;
    private Cliente cliente;
    private List<DetalleFactura> detalles;

    public Factura(int numero, Cliente cliente) {
        this.numero = numero;
        this.fecha = LocalDate.now();
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleFactura detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleFactura d : detalles) {
            total += d.calcularImporte();
        }
        return cliente.calcularDescuento(total);
    }

    @Override
    public String toString() {
        return "Factura N° " + numero + " - Fecha: " + fecha + "\n" +
               cliente + "\n" +
               "Total: $" + calcularTotal();
    }
}