package src.main.model.currency;

import static src.main.constants.Constant.SYMBOL_GBP;
public class PoundSterling extends Currency {

    private final char currencySymbol;

    /**
     * Constructor que inicializa el nombre y el valor en dólares estadounidenses (USD),
     * y asigna el símbolo de la divisa Libra Esterlina.
     *
     * @param name       El nombre de la divisa
     * @param valueInUSD El valor de la divisa en dólares estadounidenses (USD)
     */
    public PoundSterling(String name, double valueInUSD) {
        super(name, valueInUSD);
        this.currencySymbol = SYMBOL_GBP;
    }

    /**
     * Obtiene el símbolo de la divisa Libra Esterlina.
     * @return el símbolo de la divisa Libra Esterlina
     */
    public char getCurrencySymbol() {
        return currencySymbol;
    }
}
