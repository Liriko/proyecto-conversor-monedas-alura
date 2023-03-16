package src.main.utils;

/**
 * Clase responsable de crear dimensiones en base a distancia y altura.
 */
public class DimensionInFrame {

    // Atributos 'final' para garantizar la inmutabilidad
    private final int width;
    private final int height;

    /**
     * Crea una nueva dimensión con el ancho y la altura especificados.
     *
     * @param width Ancho de la dimensión, debe ser mayor que 0
     * @param height Altura de la dimensión, debe ser mayor que 0
     * @throws IllegalArgumentException Si el ancho o la altura son menores o iguales a 0
     */
    public DimensionInFrame(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Las dimensiones no pueden ser negativas ni iguales a 0");
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
     * Obtiene la altura de la dimensión
     * @return la altura
     */
    public int getHeight() {
        return height;
    }
}
