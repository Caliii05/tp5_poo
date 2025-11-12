package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private boolean pami;
    private double descuento; // 10%

    public ClienteMinorista(String nombre, String domicilio, int dni, int telefono, boolean pami, double descuento) {
        super(nombre, domicilio, dni, telefono);
        this.pami = pami;
        this.descuento = descuento;
    }

    @Override
    public double aplicarDescuentoCliente(double total) {
        if (pami) {
            return total * (1 - descuento/100.0);
        }
        return total;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("[Minorista] " + nombre + " - DNI: " + dni + " - PAMI: " + pami);
    }
}