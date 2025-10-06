package ar.edu.unju.escmi.tp5.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionVenta;

public class Venta {
    private Date fecha;
    private Cliente cliente;
    private List<Detalle> detalles;
    private Factura factura;

    public Venta(Cliente cliente) {
        this.fecha = new Date();
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(Detalle d) {
        detalles.add(d);
    }

    public Factura finalizarVenta() {
        int numeroFactura = CollectionFactura.siguienteNumero();
        factura = new Factura(numeroFactura, fecha, cliente);
        for (Detalle d : detalles) {
            factura.agregarDetalle(d);
        }
        
        for (Detalle d : detalles) {
            Producto p = d.getProducto();
            p.reducirStock(d.getCantidad());
        }
        
        CollectionFactura.guardarFactura(factura);
        CollectionVenta.guardarVenta(this);
        return factura;
    }

    public Date getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public List<Detalle> getDetalles() { return detalles; }
    public Factura getFactura() { return factura; }

    @Override
    public String toString() {
        return String.format("Venta - Fecha: %s - Cliente: %s - Detalles: %d items - FacturaN:%s",
                fecha, cliente.getNombre(), detalles.size(), factura==null ? "PENDIENTE" : factura.getNumero());
    }
}