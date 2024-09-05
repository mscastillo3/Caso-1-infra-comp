public class OperarioIternoProductor extends Thread{
    private Cinta cinta;
    private DepositoP deposito; 

    public OperarioIternoProductor(Cinta cinta, DepositoP deposito) {
        this.cinta = cinta;
        this.deposito = deposito;
    }

    public void run(){
        while(!cinta.vacia()&& deposito.vacio()){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Producto producto = deposito.sacar();
        cinta.meter(producto);
    }
    
}
