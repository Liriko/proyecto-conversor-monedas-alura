package model.divisas;

import static constantes.Constantes.*; // importa mis constantes para su libre uso en esta clase
public class LibraEsterlina extends Divisa {

    private final char ccy;
    public LibraEsterlina(String nombre, double valorUSD) {
        super(nombre, valorUSD);
        this.ccy = LIBRA_ESTERLINA_S;
    }

    public char getCcy() {
        return ccy;
    }
}
