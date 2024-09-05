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

public synchronized boolean poner(Producto p) {
    if (productos.size() +1< capDeDis ){
        return false;
    }
    else {
    productos.add(p);
    return true;
    }
}


public synchronized Producto sacar(String tipo){
    if (productos.isEmpty() && !productos.peek().getTipo().equals(tipo) ){
        return null ;
    }
    else {
    return productos.poll();
    }
}

}
