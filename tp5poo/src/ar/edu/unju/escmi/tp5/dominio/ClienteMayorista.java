package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private int codigoCliente;

    public ClienteMayorista(String nombre, String domicilio, int dni, String telefono, int codigoCliente) {
        super(nombre, domicilio, dni, telefono);
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    @Override
    public void mostrarDatos() {
        System.out.printf("Mayorista: %s - DNI: %d - Codigo: %d - Domicilio: %s - Tel: %s%n",
                nombre, dni, codigoCliente, domicilio, telefono);
    }
}