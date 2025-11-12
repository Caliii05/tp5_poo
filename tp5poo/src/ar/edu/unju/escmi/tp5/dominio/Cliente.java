package ar.edu.unju.escmi.tp5.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    protected String nombre;
    protected String domicilio;
    protected int dni;
    protected int telefono;
    protected List<Factura> facturas;

    public Cliente(String nombre, String domicilio, int dni, int telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.telefono = telefono;
        this.facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura f) {
        this.facturas.add(f);
    }

    public Factura buscarFactura(int nroFactura) {
        for (Factura f : facturas) {
            if (f.getNumero() == nroFactura) return f;
        }
        return null;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " - Domicilio: " + domicilio + " - DNI: " + dni);
    }

    public abstract double aplicarDescuentoCliente(double total);

    public double realizarPago(double monto, double totalFactura) {
        if (monto < totalFactura) {
            System.out.println("Pago insuficiente. Faltan: $" + (totalFactura - monto));
            return -1;
        }
        double cambio = monto - totalFactura;
        System.out.println("Pago recibido. Cambio: $" + cambio);
        return cambio;
    }

    public int getDni() { return dni; }
    public String getNombre() { return nombre; }
}