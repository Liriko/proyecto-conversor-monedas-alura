package src.main.model.currency;

/**
 * Clase abstracta que define una divisa genérica en términos de su valor en dólares estadounidenses (USD),
 * permitiendo la implementación de distintas divisas específicas a través de herencia y polimorfismo.
 */
public abstract class Currency {

    private final String name;
    private final double valueInUSD;

    /**
     * Constructor que inicializa el nombre y el valor en dólares estadounidenses (USD).
     *
     * @param name       El nombre de la divisa
     * @param valueInUSD El valor de la divisa en dólares estadounidenses (USD)
     */
    public Currency(String name, double valueInUSD) {
        this.name = name;
        this.valueInUSD = valueInUSD;
    }

    /**
     * Obtiene el nombre de la divisa.
     * @return el nombre de la divisa
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el valor de la divisa en dólares estadounidenses (USD).
     * @return el valor de la divisa en dólares estadounidenses (USD)
     */
    public double getValueInUSD() {
        return valueInUSD;
    }

}
