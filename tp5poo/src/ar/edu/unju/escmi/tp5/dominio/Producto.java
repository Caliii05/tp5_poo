package ar.edu.unju.escmi.tp5.dominio;

public class Producto {
    private int codigoProducto;
    private String descripcion;
    private double precioUnitario;
    private int descuento;
    private int stock;

    public Producto(int codigoProducto, String descripcion, double precioUnitario, int descuento, int stock) {
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.stock = stock;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getDescuento() {
        return descuento;
    }

    public int getStock() {
        return stock;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente");
        }
    }

    public void aumentarStock(int cantidad) {
        stock += cantidad;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - $%.2f - Desc: %d%% - Stock: %d",
                codigoProducto, descripcion, precioUnitario, descuento, stock);
    }
}