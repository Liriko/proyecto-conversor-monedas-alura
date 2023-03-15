package src.main.interfaces;

import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import javax.swing.*;
import java.awt.*;

public interface UserInterface {

    // Interface encargada de configurar la interfaz de usuario en las clases que la implementen.

    /**
     * Crea el marco principal de la aplicación
     * @param title             Título de la aplicación
     * @param colorBackground   Color de fondo de la aplicación por defecto
     */
    void createFramework(String title, Color colorBackground);

    /**
     * Establece el ícono de la aplicación
     * @param route     Ruta de la imagen
     */
    void stablishIcon(String route);

    /**
     * Establece el logo en una posición y dimensión específicas
     * @param logo              La ruta del logo
     * @param positionInFrame   La posición del logo en el marco, en los ejes X e Y
     * @param dimensionInFrame  La dimensión del logo en el marco, basado en ancho y largo
     */
    void stablishLogo(String logo, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame);

    /**
     * Establece una etiqueta con su respectiva posición, dimensión, color de fondo, tipo de letra y nombre
     * @param nombre            Nombre de la etiqueta
     * @param positionInFrame   La posición de la etiqueta en el marco, en los ejes X e Y
     * @param dimensionInFrame  La dimensión de la etiqueta en el marco, basado en ancho y largo
     * @param colorBackground   Color de fondo de la etiqueta
     * @param fontType          Tipo de letra o fuente, de la etiqueta
     */
    void stablishLabel(String nombre, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame,
                       Color colorBackground, FontType fontType);

    /**
     * Crea un elemento Scroll dentro un área de texto específico de acuerdo a una posición y dimensión
     * específicas.
     * @param area              El área de texto dentro del marco
     * @param positionInFrame   Posición específica dentro del área de texto
     * @param dimensionInFrame  Dimensión específica dentro del área de texto
     */
    void createScroll(JTextArea area, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame);

    /**
     * Crea un elemento de campo de texto según una posición, dimensión, tipo de letra, color de fondo y
     * color de letra específicos
     * @param positionInFrame   Posición del campo de texto en el marco
     * @param dimensionInFrame  Dimensión del campo de texto en el marco
     * @param fontType          Tipo de letra del campo de texto
     * @param colorBackground   Color de fondo del campo de texto
     * @param colorFont         Color de letra del campo de texto
     * @return                  El campo de texto
     */
    JTextField createTextField(PositionInFrame positionInFrame,
                               DimensionInFrame dimensionInFrame,
                               FontType fontType,
                               Color colorBackground,
                               Color colorFont);

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
