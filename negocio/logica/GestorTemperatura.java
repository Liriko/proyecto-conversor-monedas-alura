package negocio.logica; // declara el paquete donde estará ubicada mi lógica de negocio

import model.temperaturas.Temperatura;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
    Clase encargada de gestionar las divisas.
    A través de esta clase se podrán incorporar nuevas divisas
    a través del Java Collection Map
 */
public class GestorTemperatura {

    // Declara lista de temperaturas
    private final Map<String, Temperatura> temperaturas;

    public GestorTemperatura() {
        this.temperaturas = new HashMap<>();
    }

    public void addTemperatura(String key, Temperatura value) {
        this.temperaturas.put(key, value);
    }

    public Object getTemperatura(String key) {
        return this.temperaturas.get(key);
    }

    public Map<String, Temperatura> getMap(){

        return new TreeMap<>(this.temperaturas);
    }
}
