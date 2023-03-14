package src.main.model.currency;

/*
    Clase abstracta que le da forma a las distintas divisas de la aplicación
    a través de Herencia y Polimorfismo
 */
public abstract class Divisa {

    private final String nombre;
    private final double valorUSD;

    public Divisa(String nombre, double valorUSD) {
        this.nombre = nombre;
        this.valorUSD = valorUSD;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorUSD() {
        return valorUSD;
    }

}
