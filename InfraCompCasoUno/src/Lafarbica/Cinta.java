public class Cinta {
    private Producto producto;

    public Cinta() {
    }

    public synchronized Producto sacar() {
       
        
        return producto;
    }

    public synchronized void meter(Producto producto) {

        this.producto = producto;
        
    }


}
