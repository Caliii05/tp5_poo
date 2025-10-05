package ar.edu.unju.escmi.tp5.dominio;

public class Detalle {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public Detalle(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = precioUnitario * cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getSubtotal() { return subtotal; }

    @Override
    public String toString() {
        return String.format("%s | Cant:%d | PrecioUnit: $%.2f | Importe: $%.2f",
                producto.getDescripcion(), cantidad, precioUnitario, subtotal);
    }
}