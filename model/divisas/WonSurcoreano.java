package model.divisas;

import static constantes.Constantes.*; // importa mis constantes para su libre uso en esta clase
public class WonSurcoreano extends Divisa {

    private final char ccy;
    public WonSurcoreano(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = WON_SURCOREANO_S;
    }

    public char getCcy() {
        return ccy;
    }
}
