package src.main.utils;

/**
 * Clase responsable de crear dimensiones en base a distancia y altura.
 */
public class DimensionInFrame {

    // Atributos declarados final para conseguir inmutabilidad
    private final int width;
    private final int height;

    /**
     * Crea una nueva dimensión con el ancho y la altura especificados.
     * @param width el ancho de la dimensión
     * @param height la altura de la dimensión
     * @throws IllegalArgumentException si el ancho o la altura son negativos
     */
    public DimensionInFrame(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Las dimensiones no pueden ser negativas");
        }
        this.width = width;
        this.height = height;
    }

    /**
     * Obtiene el ancho de la dimensión
     * @return el ancho
     */
    public int getWidth() {
        return width;
    }

    /**
     * Obtiene el larcho de la dimensión
     * @return el largo
     */
    public int getHeight() {
        return height;
    }
}
