public class Distribuidor extends Thread {
    private String tipo;
    private DepositoD depositoD;

    public Distribuidor(String tipo, DepositoD depositoD) {
        this.tipo = tipo;
        this.depositoD = depositoD;
    }
    public synchronized Producto sacar() throws InterruptedException {
        Producto producto = depositoD.sacar();  //
        System.out.println("Producto sacado: " + producto.getTipo() + " por distribuidor de tipo: " + tipo);
        return producto;}

    @Override
    public void run() {
        try {
            boolean a=true;
            while (a==true) {
                Producto producto = sacar(); 
                if (producto.getTipo().equals("FIN_" + tipo)) {
                    System.out.println("Se acabo la distribucion para el tipo: " + tipo);
                    a = false;
                }
                System.out.println("Distribuido: " + producto.getTipo());
               //simular tiempo con sleep?
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}