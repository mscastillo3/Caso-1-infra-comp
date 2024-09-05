import java.util.Scanner;

public class Fabrica {
    private static Productor productorunoA;
    private static Productor productorunoB;
    private static Productor productordosA;
    private static Productor productordosB;
    private static Distribuidor distribuidorunoA;
    private static Distribuidor distribuidorunoB;
    private static Distribuidor distribuidordosA;
    private static Distribuidor distribuidordosB;
    private static OperarioIternoProductor operarioIternoProductor;
    private static OperarioInternoDristribuidor operarioInternoDristribuidor;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int capDepProd = input("Capacidad del deposito de productos: ");
        int capDepDist = input("Capacidad del deposito de distribucion: ");
        int numProductos = input("Cantidad de productos que cada productor va a producir: ");
        DepositoD depositoD = new DepositoD(capDepDist);
        DepositoP depositoP = new DepositoP(capDepProd);
        Cinta cinta = new Cinta();
        Fabrica.productorunoA = new Productor("A", numProductos, depositoP);
        Fabrica.productorunoB = new Productor("B", numProductos, depositoP);
        Fabrica.productordosA = new Productor("A", numProductos, depositoP);
        Fabrica.productordosB = new Productor("B", numProductos, depositoP);
        Fabrica.operarioIternoProductor = new OperarioIternoProductor(cinta, depositoP);
        Fabrica.operarioInternoDristribuidor = new OperarioInternoDristribuidor(cinta, depositoD);
        Fabrica.distribuidorunoA = new Distribuidor("A", depositoD);
        Fabrica.distribuidorunoB = new Distribuidor("B", depositoD);
        Fabrica.distribuidordosA = new Distribuidor("A", depositoD);
        Fabrica.distribuidordosB = new Distribuidor("B", depositoD);

        productorunoA.start();
        productorunoB.start();
        productordosA.start();
        productordosB.start();
        distribuidorunoA.start();
        distribuidorunoB.start();
        distribuidordosA.start();
        distribuidordosB.start();
        operarioIternoProductor.start();
        operarioInternoDristribuidor.start();
    }
    public static int input(String pregunta) {
        System.out.println(pregunta);
        int value = Integer.valueOf(scanner.nextLine());
        return value;
    }
}
