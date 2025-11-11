package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private String codigoCliente;

    public ClienteMayorista(String apellido, String nombre, String direccion, String codigoCliente) {
        super(apellido, nombre, direccion);
        this.codigoCliente = codigoCliente;
    }

    @Override
    public double calcularDescuento(double total) {
        return total; // no tiene descuento
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    @Override
    public String toString() {
        return super.toString() + " - Código: " + codigoCliente + " (Mayorista)";
    }
}