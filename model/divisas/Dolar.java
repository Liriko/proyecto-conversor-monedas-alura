package model.divisas;

import static constantes.Constantes.*; // importa mis constantes para su libre uso en esta clase

public class Dolar extends Divisa {

    private final char ccy;
    public Dolar(String nombre, double valorUSD){
        super(nombre, valorUSD);
        this.ccy = DOLAR_S;
    }

    public char getCcy() {
        return ccy;
    }
}
