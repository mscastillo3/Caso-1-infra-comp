public class OperarioInternoDristribuidor extends Thread{
    private Cinta cinta;
    private DepositoD deposito; 

    public OperarioInternoDristribuidor(Cinta cinta, DepositoD deposito) {
        this.cinta = cinta;
        this.deposito = deposito;
    }
    
    public void run(){
        boolean seguir = true;
        while(seguir){
        while(cinta.vacia()&& deposito.lleno()){

            System.out.println("Esperando a que haya algo en la cinta o que el deposito de distribuidores este vacio");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("revicion " + cinta.vacia()+ " " + deposito.lleno());

        Producto producto = cinta.sacar();
        System.out.println("Producto sacado de la cinta: " + producto.getTipo());
        seguir = producto.acabo();
        deposito.poner(producto);
        System.out.println("Producto almacenado en el deposito de distribuidores: " + producto.getTipo());
        deposito.notifyAll();
    

    }}



}
