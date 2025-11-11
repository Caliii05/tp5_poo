package ar.edu.unju.escmi.tp5.dominio;

public class AgenteAdministrativo extends Empleado {
    public AgenteAdministrativo(String nombre) {
        super(nombre, "Agente Administrativo");
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("1. Alta de producto");
        System.out.println("2. Realizar venta");
    }
}