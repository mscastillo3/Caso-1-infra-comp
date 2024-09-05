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
        while((!cinta.vacia())&& deposito.vacio()){
            System.out.println("Esperando a que la cinta este vacia o que el deposito de productos tenga productos");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("revicion " + !cinta.vacia()+ " " + deposito.vacio());
        Producto producto = deposito.sacar();
        System.out.println("Producto sacado del deposito de productos: " + producto.getTipo());
        seguir = producto.acabo();
        cinta.meter(producto);
        System.out.println("Producto almacenado en la cinta: " + producto.getTipo());
        deposito.notify();
    }}
    
}
