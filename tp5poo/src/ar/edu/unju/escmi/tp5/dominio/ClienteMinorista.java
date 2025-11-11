package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private String dni;
    private boolean tienePAMI;

    public ClienteMinorista(String apellido, String nombre, String direccion, String dni, boolean tienePAMI) {
        super(apellido, nombre, direccion);
        this.dni = dni;
        this.tienePAMI = tienePAMI;
    }

    @Override
    public double calcularDescuento(double total) {
        if (tienePAMI) {
            return total * 0.9; // 10% descuento
        }
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + " - DNI: " + dni + " (Minorista, PAMI=" + tienePAMI + ")";
    }
}