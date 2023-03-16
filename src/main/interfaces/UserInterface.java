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
    JCheckBox createCheckBox(String msg, PositionInFrame position,
                             DimensionInFrame dimension);

    // Combobox
    JComboBox createComboBox(PositionInFrame position,
                             DimensionInFrame dimension,
                             Color textColor,
                             Color backgroundColor,
                             FontType fontType);

    // Barra de menu
    JMenuBar createMenuBar(Color backgroundColor);

    // Menu
    JMenu createMenu(String name,
                     Color textColor,
                     Color backgroundColor,
                     FontType fontType);

    // Menu item
    JMenuItem createItemMenu(String name,
                             FontType fontType,
                             Color textColor);

}
