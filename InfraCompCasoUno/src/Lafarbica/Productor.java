public class Productor extends Thread {
    private String tipo;
    private int numProductos;
    private DepositoP depositoP;

    public Productor(String tipo, int numProductos, DepositoP depositoP) {
        this.tipo = tipo;
        this.numProductos = numProductos;
        this.depositoP = depositoP;
    }



    public void run()  { //es sync?
        for (int i = 0; i < numProductos; i++) {
            Producto producto = new Producto(tipo);
            System.out.println("Producto producido: " + producto.getTipo());
            //hacemos sleep?
            synchronized (depositoP) {
            if (depositoP.lleno()){
                try {
                    synchronized (depositoP) {
                    depositoP.wait();}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            depositoP.poner(producto);
            System.out.println("Producto almacenado: " + producto.getTipo());

        }}
        synchronized (depositoP) {
        if (depositoP.lleno()){
            try {
                
                depositoP.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //producto fin
        Producto Productofin = new Producto("FIN_" + tipo);
        depositoP.poner(Productofin);
        System.out.println("Un de los productores " + tipo + " finaliso");
    }
    }
}
