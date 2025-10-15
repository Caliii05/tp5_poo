package ar.edu.unju.escmi.tp5.dominio;

public abstract class Empleado {
    protected String nombre;
    protected int dni;
    protected String legajo;

    public Empleado(String nombre, int dni, String legajo) {
        this.nombre = nombre;
        this.dni = dni;
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getLegajo() {
        return legajo;
    }

    public abstract void mostrarVentas();
}