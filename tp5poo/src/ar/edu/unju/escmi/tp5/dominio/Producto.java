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

    public int getCodigoProducto() { return codigoProducto; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getDescuento() { return descuento; }
    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }
    public void reducirStock(int cantidad) { this.stock -= cantidad; }
    public void aumentarStock(int cantidad) { this.stock += cantidad; }

    public double precioConDescuentoUnitario() {
        if (descuento > 0) {
            return precioUnitario * (1 - descuento / 100.0);
        }
        return precioUnitario;
    }

    @Override
    public String toString() {
        return String.format("Codigo:%d - %s - $%.2f - Desc:%d%% - Stock:%d",
                codigoProducto, descripcion, precioUnitario, descuento, stock);
    }
}