package src.main.business.logic; // declara el paquete donde estará ubicada mi lógica de src.main.negocio

import src.main.model.temperature.Temperature;

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
    private final Map<String, Temperature> temperaturas;

    public GestorTemperatura() {
        this.temperaturas = new HashMap<>();
    }

    public void agregarTemperatura(String nombreTemperatura, Temperature temperature) {
        this.temperaturas.put(nombreTemperatura, temperature);
    }

    public Object obtenerTemperatura(String nombreTemperatura) {
        return this.temperaturas.get(nombreTemperatura);
    }

    public Map<String, Temperature> obtenerMapa(){

        // Este TreeMap ordena mi mapa alfabéticamente
        return new TreeMap<>(this.temperaturas);
    }
}
