package src.main.model.currency;

import static src.main.constants.Constant.SYMBOL_JPY;

/**
 * Clase que representa la divisa Yen Japonés, heredando de la clase Currency.
 */
public class JapaneseYen extends Currency {

    private final char currencySymbol;

    /**
     * Constructor que inicializa el nombre y el valor en dólares estadounidenses (USD),
     * y asigna el símbolo de la divisa Yen Japonés.
     *
     * @param name       El nombre de la divisa
     * @param valueInUSD El valor de la divisa en dólares estadounidenses (USD)
     */
    public JapaneseYen(String name, double valueInUSD) {
        super(name, valueInUSD);
        this.currencySymbol = SYMBOL_JPY;
    }

    /**
     * Obtiene el símbolo de la divisa Yen Japonés.
     * @return el símbolo de la divisa Yen Japonés
     */
    public char getCurrencySymbol() {
        return currencySymbol;
    }
}
