package src.main.business.logic; // declara el paquete donde estará ubicada mi lógica de src.main.negocio

import src.main.model.currency.Currency;

import java.util.*;

/*
    Clase encargada de gestionar las divisas.
    A través de esta clase se podrán incorporar nuevas divisas
    a través del Java Collection Map
 */
public class GestorDivisa {

    // Declara lista de divisas
    private final Map<String, Currency> divisas;

    public GestorDivisa() {
        this.divisas = new HashMap<>();
    }

    public void agregarDivisa(String nombreDivisa, Currency currency) {
        this.divisas.put(nombreDivisa, currency);
    }

    public Currency obtenerDivisa(String nombreDivisa) {
        return this.divisas.get(nombreDivisa);
    }

    public Map<String, Currency> obtenerMapa(){

        // el TreeMap ordenada mi mapa alfabéticamente
        return new TreeMap<>(this.divisas);
    }
}
