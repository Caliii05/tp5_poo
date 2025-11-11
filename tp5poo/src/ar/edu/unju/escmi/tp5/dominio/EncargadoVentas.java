package ar.edu.unju.escmi.tp5.dominio;

public class EncargadoVentas extends Empleado {
    public EncargadoVentas(String nombre) {
        super(nombre, "Encargado de Ventas");
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("1. Mostrar ventas");
        System.out.println("2. Total de ventas");
        System.out.println("3. Verificar stock");
    }
}