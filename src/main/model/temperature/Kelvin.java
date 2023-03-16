package src.main.model.temperature;

import static src.main.constants.Constant.SYMBOL_KELVIN;

public class Kelvin extends Temperature {
    private final char medida;
    public Kelvin(String nombre, double valorCelcius) {
        super(nombre, valorCelcius);
        this.medida = SYMBOL_KELVIN;
    }

    public char getMedida() {
        return medida;
    }

}
