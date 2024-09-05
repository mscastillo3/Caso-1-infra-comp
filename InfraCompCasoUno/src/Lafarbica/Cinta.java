public class Cinta {
    private Producto producto;

    public Cinta() {
    }

    public synchronized Producto sacar() {
       
        producto = null;
        return producto;
    }

    public synchronized void meter(Producto producto) {

        this.producto = producto;
        
    }

    public synchronized boolean vacia() {
        return producto == null;
    }

}
