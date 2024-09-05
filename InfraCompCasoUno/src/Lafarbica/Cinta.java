public class Cinta {
    private Producto producto;

    public Cinta() {
    }

    public synchronized Producto sacar() {
       
        
        return producto;
    }

}
