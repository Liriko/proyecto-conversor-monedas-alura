package src.main.utils;

/**
 * Clase para representar y configurar un tipo de letra o fuente.
 */
public class FontType {

    // Atributos 'final' para garantizar la inmutabilidad
    private final String fontName;
    private final int fontSize;

    /**
     * Constructor que inicializa los atributos
     *
     * @param fontName Nombre de la fuente
     * @param fontSize Tamaño de la fuente
     */
    public FontType(String fontName, int fontSize) {
        this.fontName = fontName;
        this.fontSize = fontSize;
    }

    /**
     * Obtiene el nombre de la fuente
     * @return el nombre de la fuente
     */
    public String getFontName() {
        return fontName;
    }


    /**
     * Obtiene el tamaño de la fuente
     * @return el tamaño de la fuente
     */
    public int getFontSize() {
        return fontSize;
    }
}
