public class Distribuidor extends Thread {
    private String tipo;
    private DepositoD depositoD;

    public Distribuidor(String tipo, DepositoD depositoD) {
        this.tipo = tipo;
        this.depositoD = depositoD;
    }

    public void run() {
            boolean a=true;
            while (a) {
                Producto producto = null;
                while( producto== null){
                    producto = depositoD.sacar(tipo);
                    if (producto ==null){
                    try {
                        depositoD.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
                if (producto.getTipo().equals("FIN_" + tipo)) {
                    System.out.println("Se acabo una de las distribucion para el tipo: " + tipo);
                    a = false;
                }
                else {
                System.out.println("Distribuido: " + producto.getTipo());
            }
            }
        }
        
}
