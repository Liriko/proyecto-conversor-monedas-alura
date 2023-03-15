package src.main.utils;

/**
 * Clase responsable de configurar el tipo de letra o fuente.
 */
public class FontType {

    // Atributos final para conseguir la inmutabilidad
    private final String font;
    private final int size;

    /**
     * Constructor que inicializa los atributos
     * @param font El nombre de la fuente
     * @param size El tamaño de la fuente
     */
    public FontType(String font, int size) {
        this.font = font;
        this.size = size;
    }

    /**
     * Obtiene la fuente
     * @return la fuente
     */
    public String getFont() {
        return font;
    }


    /**
     * Obtiene el tamaño de la fuente
     * @return el tamaño
     */
    public int getSize() {
        return size;
    }
}
