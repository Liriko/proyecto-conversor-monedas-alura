package src.main.model.temperature;

import static src.main.constants.Constant.SYMBOL_CELSIUS;

/**
 * Clase que representa una temperatura en grados Celsius,
 * heredando de la clase Temperature.
 */
public class Celsius extends Temperature {
    private final char unit;

    /**
     * Constructor que inicializa el nombre y el valor en grados Celsius,
     * y asigna el símbolo de la unidad Fahrenheit.
     *
     * @param name           El nombre de la temperatura
     * @param valueInCelsius El valor de la temperatura en grados Celsius
     */
    public Celsius(String name, double valueInCelsius) {
        super(name, valueInCelsius);
        this.unit = SYMBOL_CELSIUS;
    }

    /**
     * Obtiene el símbolo de la unidad de medida Celsius.
     * @return el símbolo de la unidad Celsius
     */
    public char getUnit() {
        return unit;
    }
}
