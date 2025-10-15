package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int numero;
    private LocalDate fecha;
    private double total;
    private Cliente cliente;
    private List<Detalle> detalles;

    public Factura(int numero, Cliente cliente) {
        this.numero = numero;
        this.fecha = LocalDate.now();
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarDetalle(Detalle d) {
        detalles.add(d);
        calcularTotal();
    }

    public void calcularTotal() {
        double suma = 0;
        for (Detalle d : detalles) {
            suma += d.getSubtotal();
        }
        this.total = suma;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Factura N°%d - Fecha: %s - Cliente: %s - Total: $%.2f%n",
                numero, fecha, cliente.getNombre(), total));
        sb.append("Detalles:\n");
        for (Detalle d : detalles) {
            sb.append("  ").append(d.toString()).append("\n");
        }
        return sb.toString();
    }
}