package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int numero;
    private LocalDate fecha;
    private double total;
    private List<Detalle> detalles;
    private Cliente cliente;

    public Factura(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarDetalle(Detalle d) {
        detalles.add(d);
        recalcularTotal();
    }

    private void recalcularTotal() {
        double suma = 0.0;
        for (Detalle d : detalles) {
            suma += d.calcularSubtotal();
        }
        // aplicar descuento del cliente
        double totalConDescuento = cliente.aplicarDescuentoCliente(suma);
        this.total = totalConDescuento;
    }

    public double calcularTotal() {
        recalcularTotal();
        return total;
    }

    public int getNumero() { return numero; }
    public LocalDate getFecha() { return fecha; }
    public List<Detalle> getDetalles() { return detalles; }
    public Cliente getCliente() { return cliente; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura N° ").append(numero).append(" - Fecha: ").append(fecha).append("\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("Detalles:\n");
        for (Detalle d : detalles) {
            sb.append("  ").append(d.toString()).append("\n");
        }
        sb.append(String.format("Total: $%.2f", calcularTotal()));
        return sb.toString();
    }
}