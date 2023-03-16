package src.main.model.temperature;

import static src.main.constants.Constant.SYMBOL_KELVIN;

/**
 * Clase que representa una temperatura en grados Kelvin,
 * heredando de la clase Temperature.
 */
public class Kelvin extends Temperature {
    private final char unit;

    /**
     * Constructor que inicializa el nombre y el valor en grados Celsius,
     * y asigna el símbolo de la unidad Kelvin.
     *
     * @param name           El nombre de la temperatura
     * @param valueInCelsius El valor de la temperatura en grados Celsius
     */
    public Kelvin(String name, double valueInCelsius) {
        super(name, valueInCelsius);
        this.unit = SYMBOL_KELVIN;
    }

    /**
     * Obtiene el símbolo de la unidad de medida Kelvin.
     * @return el símbolo de la unidad Kelvin
     */
    public char getUnit() {
        return unit;
    }

}
