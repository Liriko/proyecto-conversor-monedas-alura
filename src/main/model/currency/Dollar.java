package src.main.model.currency;

import static src.main.constants.Constant.SYMBOL_USD;

/**
 * Clase que representa la divisa Dólar, heredando de la clase Currency.
 */
public class Dollar extends Currency {

    private final char currencySymbol;

    /**
     * Constructor que inicializa el nombre y el valor en dólares estadounidenses (USD),
     * y asigna el símbolo de la divisa Dólar.
     *
     * @param name       El nombre de la divisa
     * @param valueInUSD El valor de la divisa en dólares estadounidenses (USD)
     */
    public Dollar(String name, double valueInUSD){
        super(name, valueInUSD);
        this.currencySymbol = SYMBOL_USD;
    }

    /**
     * Obtiene el símbolo de la divisa Dólar.
     * @return el símbolo de la divisa Dólar
     */
    public char getCurrencySymbol() {
        return currencySymbol;
    }
}
