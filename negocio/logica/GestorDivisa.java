package negocio.logica; // declara el paquete donde estará ubicada mi lógica de negocio

import model.divisas.Divisa;

import java.util.*;

/*
    Clase encargada de gestionar las divisas.
    A través de esta clase se podrán incorporar nuevas divisas
    a través del Java Collection Map
 */
public class GestorDivisa {

    // Declara lista de divisas
    private final Map<String, Divisa> divisas;

    public GestorDivisa() {
        this.divisas = new HashMap<>();
    }

    public void addDivisa(String key, Divisa value) {
        this.divisas.put(key, value);
    }

    public Object getDivisa(String key) {
        return this.divisas.get(key);
    }

    public Map<String, Divisa> getMap(){

        return new TreeMap<>(this.divisas);
    }
}
