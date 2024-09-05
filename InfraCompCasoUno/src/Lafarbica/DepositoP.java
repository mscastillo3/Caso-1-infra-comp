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

public synchronized boolean poner(Producto p) {
    if (productos.size() +1< capDeProd ){
        return false;
    }
    else {
    productos.add(p);
    return true;
    }
}

public synchronized Producto sacar(){
    if (productos.isEmpty()  ){
        return null ;
    }
    else {
    return productos.poll();
    }
}

}
