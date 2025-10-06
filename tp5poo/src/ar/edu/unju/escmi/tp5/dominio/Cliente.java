package ar.edu.unju.escmi.tp5.dominio;

public abstract class Cliente {
    protected String nombre;
    protected String domicilio;
    protected int dni;

    public Cliente(String nombre, String domicilio, int dni) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
    }

    public String getNombre() { return nombre; }
    public String getDomicilio() { return domicilio; }
    public int getDni() { return dni; }

    public abstract double aplicarDescuentoGlobal(double total);
    public abstract String mostrarDatos();
}