package src.main.model.currency;

import static src.main.constants.Constant.SYMBOL_CLP;

/**
 * Clase que representa la divisa Peso Chileno, heredando de la clase Currency.
 */
public class ChileanPeso extends Currency {

    private final char currencySymbol;

    /**
     * Constructor que inicializa el nombre y el valor en dólares estadounidenses (USD),
     * y asigna el símbolo de la divisa Peso Chileno.
     *
     * @param name       El nombre de la divisa
     * @param valueInUSD El valor de la divisa en dólares estadounidenses (USD)
     */
    public ChileanPeso(String name, double valueInUSD) {
        super(name, valueInUSD);
        this.currencySymbol = SYMBOL_CLP;
    }

    /**
     * Obtiene el símbolo de la divisa Peso Chileno.
     * @return el símbolo de la divisa Peso Chileno
     */
    public char getCurrencySymbol() {
        return currencySymbol;
    }
}
