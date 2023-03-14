package src.main.interfaces;

import src.main.utils.DimensionInFrame;
import src.main.utils.PositionInFrame;

import javax.swing.*;
import java.awt.*;

public interface UserInterface {

    // Interface encargada de estructurar el Front en las clases que la implementen.

    /**
     * Crea el marco principal de la aplicación
     * @param title
     * @param colorBackground
     */
    void createFramework(String title, Color colorBackground);

    /**
     * Establece el ícono de la aplicación
     * @param route
     */
    void stablishIcon(String route);

    /**
     * Establece el logo en una posición y dimensión específicas
     * @param logo
     * @param positionInFrame
     * @param dimensionInFrame
     */
    void stablishLogo(String logo, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame);

    // Etiqueta
    void estableceEtiqueta(String nombre, int x, int y, int width, int height,
                                    int red, int green, int blue, String font, int style, int size);

    // Scroll
    void estableceScroll(JTextArea area, int x, int y, int width, int height);

    // Campo de texto
    JTextField creaCampoDeTexto(int x, int y, int width, int height,
                                String font, int style, int size,
                                int red, int green, int blue,
                                int red2, int green2, int blue2);

    // Boton
    JButton creaBoton(String nombre, int x, int y, int width, int height,
                                  String font, int style, int size,
                                  int red, int green, int blue,
                                  int red2, int green2, int blue2,
                                  boolean valor);

    // Area de texto
    JTextArea creaAreaDeTexto(String texto, boolean valor,
                              String font, int style, int size,
                              int red, int green, int blue,
                              int red2, int green2, int blue2);

    // Checkbox
    JCheckBox creaCheckbox(String msg, int x, int y, int width, int height);

    // Combobox
    JComboBox creaComboBox(int x, int y, int width, int height,
                           int red, int green, int blue,
                           int red2, int green2, int blue2,
                           String font, int style, int size);

    // Barra de menu
    JMenuBar creaBarraDeMenu(int red, int green, int blue);

    // Menu
    JMenu creaMenu(String nombre, int red, int green, int blue, String font, int style, int size,
                   int red2, int green2, int blue2);

    // Menu item
    JMenuItem creaMenuItem(String nombre, String font, int style, int size,
                           int red, int green, int blue);

}
