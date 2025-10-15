package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private boolean pami;

    public ClienteMinorista(String nombre, String domicilio, int dni, String telefono, boolean pami) {
        super(nombre, domicilio, dni, telefono);
        this.pami = pami;
    }

    public boolean isPami() {
        return pami;
    }

    @Override
    public void mostrarDatos() {
        System.out.printf("Minorista: %s - DNI: %d - PAMI: %s - Domicilio: %s - Tel: %s%n",
                nombre, dni, pami ? "Sí" : "No", domicilio, telefono);
    }
}