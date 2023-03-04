package model.divisas;

import static constantes.Constantes.*; // importa mis constantes para su libre uso en esta clase
public class YenJapones extends Divisa {

    private final char ccy;
    public YenJapones(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = YEN_JAPONES_S;
    }

    public char getCcy() {
        return ccy;
    }
}
