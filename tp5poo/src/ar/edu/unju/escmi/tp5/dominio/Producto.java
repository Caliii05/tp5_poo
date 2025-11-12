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

    public double calcularPrecioConDescuento() {
        return precioUnitario * (1 - descuento / 100.0);
    }

    // permite calcular precio si se aplica porcentaje adicional
    public double calcularDescuento(double porcentaje) {
        return precioUnitario * (1 - porcentaje/100.0);
    }

    public void actualizarStock(int cantidad) {
        this.stock -= cantidad;
        if (this.stock < 0) this.stock = 0;
    }

    public int getCodigoProducto() { return codigoProducto; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getDescuento() { return descuento; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return codigoProducto + " - " + descripcion + " - $"+ precioUnitario + " - desc: " + descuento + "% - stock: " + stock;
    }
}