package model.temperaturas;

import static constantes.Constantes.CELSIUS_S;

public class Celsius extends Temperatura{
    private final char medida;
    public Celsius(String nombre, double valorCelsius) {
        super(nombre, valorCelsius);
        this.medida = CELSIUS_S;
    }

    public char getMedidas() {
        return medida;
    }
}
