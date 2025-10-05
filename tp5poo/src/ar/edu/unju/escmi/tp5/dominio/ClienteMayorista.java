package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private int codigoCliente;

    public ClienteMayorista(String nombre, String domicilio, int dni, int codigoCliente) {
        super(nombre, domicilio, dni);
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCliente() { return codigoCliente; }

    @Override
    public double aplicarDescuentoGlobal(double total) {
    
        return total;
    }

    @Override
    public String mostrarDatos() {
        return "Mayorista - Código: " + codigoCliente + " - " + nombre + " - " + domicilio + " - DNI: " + dni;
    }
}