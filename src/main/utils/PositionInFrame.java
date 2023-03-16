package src.main.utils;

/**
 * Clase utilitaria para representar posiciones basadas en los ejes X y Y.
 */
public class PositionInFrame {

    // Atributos 'final' para garantizar la inmutabilidad
    private final int x;
    private final int y;

    /**
     * Crea una nueva posición con los ejes x e y especificados.
     *
     * @param x Coordenada del eje X
     * @param y Coordenada del eje Y
     * @throws IllegalArgumentException si x o y son negativos
     */
    public PositionInFrame(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Las coordenadas no pueden ser negativas");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene la coordenada del eje X
     * @return la coordenada del eje X
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene la coordenada del eje Y
     * @return la coordenada del eje Y
     */
    public int getY() {
        return y;
    }
}
