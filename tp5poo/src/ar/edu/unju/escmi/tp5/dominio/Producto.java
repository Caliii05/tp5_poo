package ar.edu.unju.escmi.tp5.dominio;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precioUnitario;
    private int descuento; // 0, 25 o 30 %

    public Producto(int codigo, String descripcion, double precioUnitario, int descuento) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
    }

    public double obtenerPrecioConDescuento() {
        return precioUnitario * (1 - descuento / 100.0);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public String toString() {
        return codigo + " - " + descripcion + " ($" + precioUnitario + ", desc=" + descuento + "%)";
    }
}