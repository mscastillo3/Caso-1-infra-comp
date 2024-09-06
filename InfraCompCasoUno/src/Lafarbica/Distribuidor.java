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
                synchronized (depositoD) {
                while( depositoD.vacio()|| !depositoD.tipo().contains(tipo)){
                    try {
                         depositoD.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Producto producto = depositoD.sacar();
                System.out.println("Producto sacado: " + producto.getTipo() + " por distribuidor de tipo: " + tipo);

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
}
