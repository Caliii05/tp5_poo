package ar.edu.unju.escmi.tp5.dominio;

public class DetalleFactura {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public DetalleFactura(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double calcularImporte() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return cantidad + " x " + producto.getDescripcion() + " = $" + calcularImporte();
    }
}