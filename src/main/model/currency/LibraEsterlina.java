package src.main.model.currency;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase
public class LibraEsterlina extends Divisa {

    private final char ccy;
    public LibraEsterlina(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = SYMBOL_GBP;
    }

    public char getCcy() {
        return ccy;
    }
}
