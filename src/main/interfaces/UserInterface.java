package src.main.interfaces;

import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import javax.swing.*;
import java.awt.*;

public interface UserInterface {

    // Interface encargada de configurar la interfaz de usuario en las clases que la implementen.

    void createFrame(String title, Color colorBackground);

    void setIcon(String imagePath);

    void setLogo(String logoPath, PositionInFrame position, DimensionInFrame dimension);

    void setLabel(String name, PositionInFrame position, DimensionInFrame dimension,
                  Color backgroundColor, FontType fontType);

    void createScrollPane(JTextArea textArea, PositionInFrame position, DimensionInFrame dimension);

    JTextField createTextField(PositionInFrame position,
                               DimensionInFrame dimension,
                               FontType fontType,
                               Color backgroundColor,
                               Color fontColor);

    JButton createButton(String name, PositionInFrame position, DimensionInFrame dimension,
                         FontType fontType, Color backgroundColor, Color textColor, boolean isEnabled);

    // Area de texto
    JTextArea createTextArea(String text, boolean isEnabled,
                             FontType fontType,
                             Color textColor,
                             Color backgroundColor);

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
