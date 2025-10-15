package ar.edu.unju.escmi.tp5.dominio;

public class Detalle {
    private String descripcion;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public Detalle(String descripcion, int cantidad, double precioUnitario) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        this.subtotal = cantidad * precioUnitario;
    }

    public void aplicarDescuento(int porcentaje) {
        if (porcentaje > 0) {
            double factor = (100 - porcentaje) / 100.0;
            this.subtotal = cantidad * precioUnitario * factor;
        } else {
            calcularSubtotal();
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return String.format("%s x%d @ $%.2f = $%.2f", descripcion, cantidad, precioUnitario, subtotal);
    }
}