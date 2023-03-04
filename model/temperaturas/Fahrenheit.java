package model.temperaturas;

import static constantes.Constantes.FAHRENHEIT_S;

public class Fahrenheit extends Temperatura{

    private final char medida;
    public Fahrenheit(String nombre, double valorCelcius) {
        super(nombre, valorCelcius);
        this.medida = FAHRENHEIT_S;
    }

    public char getMedida() {
        return medida;
    }
}
