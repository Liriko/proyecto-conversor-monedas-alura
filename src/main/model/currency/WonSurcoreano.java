package src.main.model.currency;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase
public class WonSurcoreano extends Divisa {

    private final char ccy;
    public WonSurcoreano(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = SYMBOL_KRW;
    }

    public char getCcy() {
        return ccy;
    }
}
