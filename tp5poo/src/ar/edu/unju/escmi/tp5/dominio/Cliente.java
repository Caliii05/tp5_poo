package ar.edu.unju.escmi.tp5.dominio;

public abstract class Cliente {
    protected String apellido;
    protected String nombre;
    protected String direccion;

    public Cliente(String apellido, String nombre, String direccion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public abstract double calcularDescuento(double total);

    public String getNombreCompleto() {
        return apellido + ", " + nombre;
    }

    @Override
    public String toString() {
        return "Cliente: " + getNombreCompleto() + " - Dirección: " + direccion;
    }
}