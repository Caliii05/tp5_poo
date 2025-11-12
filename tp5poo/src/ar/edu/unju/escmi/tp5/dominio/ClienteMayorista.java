package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private int codigoCliente;
    private int cantBultos;

    public ClienteMayorista(String nombre, String domicilio, int dni, int telefono, int codigoCliente, int cantBultos) {
        super(nombre, domicilio, dni, telefono);
        this.codigoCliente = codigoCliente;
        this.cantBultos = cantBultos;
    }

    @Override
    public double aplicarDescuentoCliente(double total) {
        
        return total;
    }

    public int getCodigoCliente() { return codigoCliente; }
    public int getCantBultos() { return cantBultos; }

    @Override
    public void mostrarDatos() {
        System.out.println("[Mayorista] " + nombre + " - Código: " + codigoCliente + " - Domicilio: " + domicilio);
    }
}