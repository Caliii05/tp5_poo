package ar.edu.unju.escmi.tp5.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
    private int numero;
    private Date fecha;
    private Cliente cliente;
    private List<Detalle> detalles;
    private double total;

    public Factura(int numero, Date fecha, Cliente cliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    public int getNumero() { return numero; }
    public Date getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public List<Detalle> getDetalles() { return detalles; }
    public double getTotal() { return total; }

    public void agregarDetalle(Detalle d) {
        detalles.add(d);
        recalcularTotal();
    }

    public void recalcularTotal() {
        double suma = 0;
        for (Detalle d : detalles) suma += d.getSubtotal();
        
        total = cliente.aplicarDescuentoGlobal(suma);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Factura N°%d - Fecha: %s\n", numero, fecha));
        sb.append("Cliente: ").append(cliente.mostrarDatos()).append("\n");
        sb.append("Detalles:\n");
        for (Detalle d : detalles) sb.append("  ").append(d).append("\n");
        sb.append(String.format("Total: $%.2f\n", total));
        return sb.toString();
    }
}