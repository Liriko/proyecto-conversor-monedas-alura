package src.main.model.temperature;

/*
    Clase abstracta que le da forma a las distintas temperaturas del proyecto,
    a través de la Herencia y Polimorfismo.
 */
public abstract class Temperatura {

    private final String nombre;
    private final double valorCelcius;

    public Temperatura(String nombre, double valorCelcius) {
        this.nombre = nombre;
        this.valorCelcius = valorCelcius;
    }

    public String getNombre() {
        return nombre;
    }

    public double getvalorCelcius() {
        return valorCelcius;
    }
}
