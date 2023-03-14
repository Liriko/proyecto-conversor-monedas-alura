package src.main.model.currency;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase
public class PesoChileno extends Divisa {

    private final char ccy;
    public PesoChileno(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = SYMBOL_CLP;
    }

    public char getCcy() {
        return ccy;
    }
}
