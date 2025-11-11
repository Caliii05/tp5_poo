package ar.edu.unju.escmi.tp5.dominio;

public abstract class Empleado {
    protected String nombre;
    protected String rol;

    public Empleado(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public abstract void mostrarOpciones();
}