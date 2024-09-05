public class OperarioIternoProductor extends Thread{
    private Cinta cinta;
    private DepositoP deposito; 

    public OperarioIternoProductor(Cinta cinta, DepositoP deposito) {
        this.cinta = cinta;
        this.deposito = deposito;
    }

    public void run(){
        boolean seguir = true;
        while(seguir){
        while(!cinta.vacia()&& deposito.vacio()){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Producto producto = deposito.sacar();
        seguir = producto.acabo();
        cinta.meter(producto);
    }}
    
}
