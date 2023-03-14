package src.main.model.currency;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase
public class YenJapones extends Divisa {

    private final char ccy;
    public YenJapones(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = SYMBOL_JPY;
    }

    public char getCcy() {
        return ccy;
    }
}
