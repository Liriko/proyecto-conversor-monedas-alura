package model.divisas;

import static constantes.Constantes.*; // importa mis constantes para su libre uso en esta clase
public class Euro extends Divisa {

    private final char ccy;
    public Euro(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = EURO_S;
    }

    public char getCcy() {
        return ccy;
    }
}