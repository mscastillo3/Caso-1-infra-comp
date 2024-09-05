public class Cinta {
    private Producto producto;

    public Cinta() {
        producto = null;
    }

    public synchronized Producto sacar() {
    
        return producto;
    }

    public synchronized void meter(Producto producto) {

        this.producto = producto;
        
    }

    public synchronized boolean vacia() {
        return producto == null;
    }

}
