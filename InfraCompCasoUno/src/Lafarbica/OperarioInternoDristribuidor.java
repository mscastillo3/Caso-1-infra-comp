public class OperarioInternoDristribuidor extends Thread{
    private Cinta cinta;
    private DepositoD deposito; 

    public OperarioInternoDristribuidor(Cinta cinta, DepositoD deposito) {
        this.cinta = cinta;
        this.deposito = deposito;
    }
    
    public void run(){
        while(cinta.vacia()&& deposito.lleno()){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Producto producto = cinta.sacar();
        deposito.poner(producto);
    }



}
