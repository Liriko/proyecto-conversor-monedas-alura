package src.main.model.temperature;

import static src.main.constants.Constant.SYMBOL_FAHRENHEIT;

/**
 * Clase que representa una temperatura en grados Fahrenheit,
 * heredando de la clase Temperature.
 */
public class Fahrenheit extends Temperature {

    private final char unit;

    /**
     * Constructor que inicializa el nombre y el valor en grados Celsius,
     * y asigna el símbolo de la unidad Fahrenheit.
     *
     * @param name           El nombre de la temperatura
     * @param valueInCelsius El valor de la temperatura en grados Celsius
     */
    public Fahrenheit(String name, double valueInCelsius) {
        super(name, valueInCelsius);
        this.unit = SYMBOL_FAHRENHEIT;
    }

    /**
     * Obtiene el símbolo de la unidad de medida Fahrenheit.
     * @return el símbolo de la unidad Fahrenheit
     */
    public char getUnit() {
        return unit;
    }
}
