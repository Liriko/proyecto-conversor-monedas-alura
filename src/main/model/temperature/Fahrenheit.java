package src.main.model.temperature;

import static src.main.constants.Constant.SYMBOL_FAHRENHEIT;

public class Fahrenheit extends Temperature {

    private final char medida;
    public Fahrenheit(String nombre, double valorCelcius) {
        super(nombre, valorCelcius);
        this.medida = SYMBOL_FAHRENHEIT;
    }

    public char getMedida() {
        return medida;
    }
}
