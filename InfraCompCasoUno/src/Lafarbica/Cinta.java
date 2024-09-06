public class Cinta {
    private Producto producto;
    private Boolean vacia ;

    public Cinta() {
        vacia = true;
        producto = null;
    }

    public synchronized Producto sacar() {
        vacia = true;
        return producto;
    }

    public synchronized void meter(Producto producto) {
        vacia = false;
        this.producto = producto;
        
        
    }

    public synchronized boolean vacia() {
        return vacia;
    }

}
