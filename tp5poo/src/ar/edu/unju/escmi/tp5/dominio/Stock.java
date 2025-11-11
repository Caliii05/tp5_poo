package ar.edu.unju.escmi.tp5.dominio;

public class Stock {
    private Producto producto;
    private int cantidad;

    public Stock(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void actualizarStock(int cantidadVendida) {
        cantidad -= cantidadVendida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        return producto.getDescripcion() + " - Stock: " + cantidad;
    }
}