public class Producto {
    private String tipo;  //tipo a o b 
    public Producto(String tipo) {
        this.tipo = tipo;}

    public String getTipo() {

        return tipo;}


    public boolean acabo(){
        return tipo.equals("FIN_A") || tipo.equals("FIN_B");
    }
}
