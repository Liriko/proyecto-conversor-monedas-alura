package src.main.model.currency;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase
public class Euro extends Divisa {

    private final char ccy;
    public Euro(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = SYMBOL_EUR;
    }

    public char getCcy() {
        return ccy;
    }
}
