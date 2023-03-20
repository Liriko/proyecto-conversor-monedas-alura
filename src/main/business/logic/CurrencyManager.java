package src.main.business.logic; // declara el paquete donde estará ubicada mi lógica de src.main.negocio

import src.main.model.currency.Currency;

import java.util.*;

/*
    Clase encargada de gestionar las divisas.
    A través de esta clase se podrán incorporar nuevas divisas
    a través del Java Collection Map
 */
public class CurrencyManager {

    // Declara lista de divisas
    private final Map<String, Currency> currencies;

    public CurrencyManager() {
        this.currencies = new HashMap<>();
    }

    public void addCurrency(String currencyName, Currency currency) {
        this.currencies.put(currencyName, currency);
    }

    public Currency getCurrency(String currencyName) {
        return this.currencies.get(currencyName);
    }

    public Map<String, Currency> getMap(){

        // el TreeMap ordenada mi mapa alfabéticamente
        return new TreeMap<>(this.currencies);
    }
}
