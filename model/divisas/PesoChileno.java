package model.divisas;

import static constantes.Constantes.*; // importa mis constantes para su libre uso en esta clase
public class PesoChileno extends Divisa {

    private final char ccy;
    public PesoChileno(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = PESO_CHILENO_S;
    }

    public char getCcy() {
        return ccy;
    }
}
