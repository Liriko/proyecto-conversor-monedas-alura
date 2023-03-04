package model.temperaturas;

import static constantes.Constantes.KELVIN_S;

public class Kelvin extends Temperatura{
    private final char medida;
    public Kelvin(String nombre, double valorCelcius) {
        super(nombre, valorCelcius);
        this.medida = KELVIN_S;
    }

    public char getMedida() {
        return medida;
    }

}
