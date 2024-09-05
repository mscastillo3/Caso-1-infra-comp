import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DepositoD {
private int capDeDis;
private Queue<Producto> productos;

public DepositoD(int capDeDis) {
    this.capDeDis = capDeDis;
    this.productos = new LinkedList<Producto>();
}

public synchronized boolean lleno() {
    return productos.size() +1< capDeDis; 
}

public synchronized void poner(Producto p) {
    productos.add(p);
}

public synchronized String tipo(){
    if (productos.isEmpty()){
        return "c";
    }
    return productos.peek().getTipo();
}

public synchronized Producto sacar(){
    return productos.poll();
}

public synchronized boolean vacio() {
    return productos.isEmpty();
}

}
