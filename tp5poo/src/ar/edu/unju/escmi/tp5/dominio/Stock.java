package ar.edu.unju.escmi.tp5.dominio;

public class Stock {
    private Producto producto;
    private int cantidad;

    public Stock(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    public void actualizarStock(int cantVendida) {
        this.cantidad -= cantVendida;
        if (this.cantidad < 0) this.cantidad = 0;
        // también sincronizamos con el producto si es necesario
        producto.actualizarStock(cantVendida);
    }

    @Override
    public String toString() {
        return producto.getDescripcion() + " (cod:" + producto.getCodigoProducto() + ") - Stock: " + cantidad;
    }
}