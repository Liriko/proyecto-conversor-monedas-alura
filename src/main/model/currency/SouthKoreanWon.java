package src.main.model.currency;

import static src.main.constants.Constant.SYMBOL_KRW;

/**
 * Clase que representa la divisa Won Surcoreano, heredando de la clase Currency.
 */
public class SouthKoreanWon extends Currency {

    private final char currencySymbol;

    /**
     * Constructor que inicializa el nombre y el valor en dólares estadounidenses (USD),
     * y asigna el símbolo de la divisa Won Surcoreano.
     *
     * @param name       El nombre de la divisa
     * @param valueInUSD El valor de la divisa en dólares estadounidenses (USD)
     */
    public SouthKoreanWon(String name, double valueInUSD) {
        super(name, valueInUSD);
        this.currencySymbol = SYMBOL_KRW;
    }

    /**
     * Obtiene el símbolo de la divisa Won Surcoreano.
     * @return el símbolo de la divisa Won Surcoreano
     */
    public char getCurrencySymbol() {
        return currencySymbol;
    }
}
