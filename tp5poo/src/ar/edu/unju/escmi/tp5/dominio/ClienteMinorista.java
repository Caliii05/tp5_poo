package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private boolean tienePami;

    public ClienteMinorista(String nombre, String domicilio, int dni, boolean tienePami) {
        super(nombre, domicilio, dni);
        this.tienePami = tienePami;
    }

    public boolean isTienePami() { return tienePami; }

    @Override
    public double aplicarDescuentoGlobal(double total) {
        
        if (tienePami) {
            return total * 0.90;
        }
        return total;
    }

    @Override
    public String mostrarDatos() {
        return "Minorista - " + nombre + " - " + domicilio + " - DNI: " + dni + " - PAMI: " + (tienePami ? "SI" : "NO");
    }
}