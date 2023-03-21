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
public class TemperatureManager {

    // Declara lista de temperaturas
    private final Map<String, Temperature> temperature;

    public TemperatureManager() {
        this.temperature = new HashMap<>();
    }

    public void addTemperature(String temperatureName, Temperature temperature) {
        this.temperature.put(temperatureName, temperature);
    }

    public Object getTemperature(String temperatureName) {
        return this.temperature.get(temperatureName);
    }

    public Map<String, Temperature> getMap(){

        // Este TreeMap ordena mi mapa alfabéticamente
        return new TreeMap<>(this.temperature);
    }
}
