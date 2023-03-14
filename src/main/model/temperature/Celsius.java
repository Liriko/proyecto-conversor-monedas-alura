package src.main.model.temperature;

import static src.main.constants.Constant.SYMBOL_CELSIUS;

public class Celsius extends Temperatura{
    private final char medida;
    public Celsius(String nombre, double valorCelsius) {
        super(nombre, valorCelsius);
        this.medida = SYMBOL_CELSIUS;
    }

    public char getMedidas() {
        return medida;
    }
}
