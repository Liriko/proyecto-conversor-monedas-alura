package src.main.model.temperature;

/**
 * Clase abstracta que define una temperatura genérica en grados Celsius,
 * permitiendo la implementación de distintas temperaturas específicas a través
 * de herencia y polimorfismo.
 */
public abstract class Temperature {

    private final String name;
    private final double valueInCelsius;

    /**
     * Constructor que inicializa el nombre y el valor en grados Celsius.
     *
     * @param name             El nombre de la temperatura
     * @param valueInCelsius   El valor de la temperatura en grados Celsius
     */
    public Temperature(String name, double valueInCelsius) {
        this.name = name;
        this.valueInCelsius = valueInCelsius;
    }

    /**
     * Obtiene el nombre de la temperatura.
     * @return el nombre de la temperatura
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el valor de la temperatura en grados Celsius.
     * @return el valor de la temperatura en grados Celsius
     */
    public double getvalorCelcius() {
        return valueInCelsius;
    }
}
