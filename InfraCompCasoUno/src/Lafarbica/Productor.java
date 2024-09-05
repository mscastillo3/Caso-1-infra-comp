public class Productor extends Thread {
    private String tipo;
    private int cantidadP;
    private DepositoP depositoP;

    public Productor(String tipo, int cantidadP, DepositoP depositoP) {
        this.tipo = tipo;
        this.cantidadP = cantidadP;
        this.depositoP = depositoP;
    }
    public void producir() throws InterruptedException {
        //produce un producto del tipo especificado 
        Producto producto = new Producto(tipo);
        System.out.println("Producto producido: " + producto.getTipo());}
    public void almacenar(Producto producto) {
        depositoP.poner(producto);
        System.out.println("Producto almacenado: " + producto.getTipo()); }

        public void run()  { //es sync?
            try { for (int i = 0; i < cantidadP; i++) {
                producir(); 
                //hacemos sleep?
            }
            //producto fin
            Producto Productofin = new Producto("FIN_" + tipo);
            almacenar(Productofin);} catch (InterruptedException e) {
                e.printStackTrace(); }
    }}
