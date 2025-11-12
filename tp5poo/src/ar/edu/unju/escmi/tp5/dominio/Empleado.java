package ar.edu.unju.escmi.tp5.dominio;

public abstract class Empleado {
    protected String nombre;
    protected int dni;
    protected String legajo;
    protected int idEmpleado;

    public Empleado(String nombre, int dni, String legajo, int idEmpleado) {
        this.nombre = nombre;
        this.dni = dni;
        this.legajo = legajo;
        this.idEmpleado = idEmpleado;
    }

    public void mostrarDatos() {
        System.out.println("Empleado: " + nombre + " - Legajo: " + legajo + " - ID: " + idEmpleado);
    }

    public int getIdEmpleado() {
        return idEmpleado;
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
}