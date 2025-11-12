package ar.edu.unju.escmi.tp5.dominio;

public class Detalle {
    private String descripcion;
    private int cantidad;
    private double precio; // precio unitario aplicado en la venta
    private double subtotal;
    private Producto producto;

    public Detalle(Producto producto, int cantidad, double precio) {
        this.producto = producto;
        this.descripcion = producto.getDescripcion();
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = calcularSubtotal();
    }

    public double calcularSubtotal() {
        return cantidad * precio;
    }

    public double aplicarDescuento(double porcentaje) {
        double nuevoPrecio = precio * (1 - porcentaje/100.0);
        return cantidad * nuevoPrecio;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }
    public double getSubtotal() { return subtotal; }

    @Override
    public String toString() {
        return cantidad + " x " + descripcion + " @ $" + precio + " = $" + calcularSubtotal();
    }
}