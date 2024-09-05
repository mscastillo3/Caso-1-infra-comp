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
            while (!depositoP.poner( producto)){
                try {
                    depositoP.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Producto almacenado: " + producto.getTipo());

        }
        Producto Productofin = new Producto("FIN_" + tipo);
        
        while (depositoP.poner(Productofin)){
            try {
                depositoP.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //producto fin
        
        System.out.println("Un de los productores " + tipo + " finaliso");
    }
}
