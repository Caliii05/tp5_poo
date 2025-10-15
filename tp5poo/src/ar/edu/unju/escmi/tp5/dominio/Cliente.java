package ar.edu.unju.escmi.tp5.dominio;

public abstract class Cliente {
    protected String nombre;
    protected String domicilio;
    protected int dni;
    protected String telefono;

    public Cliente(String nombre, String domicilio, int dni, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.telefono = telefono;
    }

    public abstract void mostrarDatos();

    public void realizarPago(double monto) {
        
        System.out.printf("Cliente %s pagó $%.2f en efectivo.%n", nombre, monto);
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTelefono() {
        return telefono;
    }
}