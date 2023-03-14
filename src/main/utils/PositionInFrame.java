package src.main.utils;

/**
 * Clase utilitaria diseñada para la creación de posiciones basadas en los ejes X y Y
 */
public class PositionInFrame {

    // Atributos declarados finales para conseguir inmutabilidad
    private final int x;
    private final int y;

    /**
     * Crea una nueva posición con los ejes x e y especificados.
     * @param x el eje X de posición
     * @param y el eje Y de la posición
     * @throws IllegalArgumentException si x o y son negativos
     */
    public PositionInFrame(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Las coordenadas no pueden ser negativas");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene el eje X de la posición
     * @return el eje X
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene el eje Y de la posición
     * @return el eje Y
     */
    public int getY() {
        return y;
    }
}
