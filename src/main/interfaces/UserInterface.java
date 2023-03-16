package src.main.interfaces;

import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import javax.swing.*;
import java.awt.*;

public interface UserInterface {

    // Interface encargada de configurar la interfaz de usuario en las clases que la implementen.

    /**
     * Crea un nuevo JFrame con un título y color de fondo específico.
     */
    void createFrame(String title, Color colorBackground);

    /**
     * Establece el ícono del JFrame a una imagen según una ruta o dirección específica
     */
    void setIcon(String imagePath);

    /**
     * Crea un JLabel con una imagen de logo, posición y dimensión específica
     */
    void createLogoLabel(String logoPath, PositionInFrame position, DimensionInFrame dimension);

    /**
     * Crea un JLabel con un texto, posición, dimensión, color de fondo, y tipo de letra específicos.
     */
    void setLabel(String name, PositionInFrame position, DimensionInFrame dimension,
                  Color backgroundColor, FontType fontType);

    /**
     * Crea un JScrollPane con un JTextArea, posición y dimensiòn específicos
     */
    void createScrollPane(JTextArea textArea, PositionInFrame position, DimensionInFrame dimension);

    /**
     * Crea un JTextField con una posición, dimensión, tipo de letra, color de fondo y color de letra específicos.
     */
    JTextField createTextField(PositionInFrame position,
                               DimensionInFrame dimension,
                               FontType fontType,
                               Color backgroundColor,
                               Color fontColor);

    /**
     * Crea un JButton con un texto, posición, dimensión, tipo de letra, color de fondo, color de letra y estado
     * específicos.
     */
    JButton createButton(String name, PositionInFrame position, DimensionInFrame dimension,
                         FontType fontType, Color backgroundColor, Color textColor, boolean isEnabled);

    /**
     * Crea un JTextArea con un texto, estado, tipo de letra, color de letra y color de fondo específicos.
     */
    JTextArea createTextArea(String text, boolean isEnabled,
                             FontType fontType,
                             Color textColor,
                             Color backgroundColor);

    /**
     * Crea un JCheckBox con un texto, posición y dimensión específicos.
     */
    JCheckBox createCheckBox(String msg, PositionInFrame position,
                             DimensionInFrame dimension);

    /**
     * Crea un JComboBox con una posición, dimensión, color de texto, color de fondo y tipo de letra específicos.
     */
    JComboBox createComboBox(PositionInFrame position,
                             DimensionInFrame dimension,
                             Color textColor,
                             Color backgroundColor,
                             FontType fontType);

    /**
     * Crea un JMenuBar con un color de fondo específico.
     */
    JMenuBar createMenuBar(Color backgroundColor);

    /**
     * Crea un JMenu con un nombre, color de texto, color de fondo y tipo de letra específicos.
     */
    JMenu createMenu(String name,
                     Color textColor,
                     Color backgroundColor,
                     FontType fontType);

    /**
     * Crea un JMenuItem con un nombre, tipo de letra y color de letra específicos.
     */
    JMenuItem createItemMenu(String name,
                             FontType fontType,
                             Color textColor);

}
