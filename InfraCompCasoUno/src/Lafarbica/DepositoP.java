import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DepositoP {
private int capDeProd;
private Queue<Producto> productos;

public DepositoP(int capDeProd) {
    this.capDeProd = capDeProd;
    this.productos = new LinkedList<Producto>();
}

public synchronized boolean lleno() {
    return productos.size() < capDeProd;
}

public synchronized void poner(Producto p) {
    productos.add(p);
}

public synchronized Producto sacar(){
    return productos.poll();
}

public synchronized boolean vacio() {
    return productos.isEmpty();
}

}
