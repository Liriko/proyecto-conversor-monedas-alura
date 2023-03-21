package src.main.business.display;

import src.main.interfaces.UserInterface;
import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import static src.main.constants.Constant.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Objects;

public class Welcome extends JFrame implements ActionListener, UserInterface {

    private JTextField textFieldName;
    private JButton buttonEnter;
    public static String name = "";

    public Welcome() {

        loadUserInterface();
    }

    /**
     * Crea un elemento de campo de texto según una posición, dimensión, tipo de letra, color de fondo y
     * color de letra específicos
     *
     * @param position          Posición del campo de texto en el marco
     * @param dimension         Dimensión del campo de texto en el marco
     * @param fontType          Tipo de letra del campo de texto
     * @param backgroundColor   Color de fondo del campo de texto
     * @param fontColor         Color de letra del campo de texto
     * @return                  El campo de texto
     */
    @Override
    public JTextField createTextField(PositionInFrame position,
                                      DimensionInFrame dimension,
                                      FontType fontType,
                                      Color backgroundColor,
                                      Color fontColor) {

        // Crea el elemento campo de texto
        JTextField textField = new JTextField();

        // Establece la posición y dimensión específicas del campo de texto dentro del marco
        textField.setBounds(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight());

        // Establece el tipo de letra o fuente del campo de texto
        textField.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de la letra del campo de texto
        textField.setForeground(fontColor);

        // Establece el color de fondo del campo de texto
        textField.setBackground(backgroundColor);

        // Añade el campo de texto al marco principal
        add(textField);

        // Retorna el campo de texto
        return textField;
    }

    /**
     * Crea un elemento botón según una posición, dimensión, tipo de letra, color de fondo,
     * color de letra y estado específicos.
     *
     * @param name              Nombre del botón
     * @param position          Posición del botón en el marco sobre coordenadas del eje X e Y
     * @param dimension         Dimensión del botón en el marco según base y altura
     * @param fontType          Tipo de fuente del botón
     * @param backgroundColor   Color de fondo del botón
     * @param textColor         Color de la fuente del botón
     * @param isEnabled         Estado del botón, 1 = activo, 0 = inactivo
     * @return el botón
     */
    @Override
    public JButton createButton(String name,
                                PositionInFrame position,
                                DimensionInFrame dimension,
                                FontType fontType,
                                Color textColor,
                                Color backgroundColor,
                                boolean isEnabled) {

        // Crea el botón con un nombre específico
        JButton jButton = new JButton(name);

        // Establece la posición y dimensión específica del botón en el marco
        jButton.setBounds(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight());

        // Establece el tipo de fuente que tendrá el botón
        jButton.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de la fuente del botón
        jButton.setForeground(textColor);

        // Establece el color de fondo del botón
        jButton.setBackground(backgroundColor);

        // Añade un evento al botón cuando se le haga referencia
        jButton.addActionListener(this);

        // Añade el botón al marco
        add(jButton);

        // retorna el botón
        return jButton;
    }

    /**
     * Crea un elemento área de texto según un texto, tipo de letra, color de fondo,
     * color de letra y estado específicos. En esta clase no tiene uso.
     *
     * @param text                  Texto que mostrará el área de texto
     * @param isEnabled             Estado del área de texto
     * @param fontType              Tipo de letra del texto del área de texto
     * @param textColor             Color de la letra del texto del área de texto
     * @param backgroundColor       Color de fondo del área de texto
     * @return el área de texto
     */
    @Override
    public JTextArea createTextArea(String text,
                                    boolean isEnabled,
                                    FontType fontType,
                                    Color textColor,
                                    Color backgroundColor) {
        return null;
    }

    /**
     * Crea un elemento Scroll dentro de un área de texto específico de acuerdo a una posición y dimensión
     * específicas. En esta clase no tiene uso.
     *
     * @param textArea      El área de texto dentro del marco
     * @param position      Posición específica dentro del área de texto
     * @param dimension     Dimensión específica dentro del área de texto
     */
    @Override
    public void createScrollPane(JTextArea textArea,
                                 PositionInFrame position,
                                 DimensionInFrame dimension) {
    }


    /**
     * Crea un elemento checkBox con una posición y dimensión específica.
     * En esta clase no tiene uso.
     *
     * @param msg               Mensaje que mostrará el checkbox.
     * @param position          Posición del checkbox en coordenadas X e Y
     * @param dimension         Dimensión del checkbox según base y altura
     * @return el checkbox
     */
    @Override
    public JCheckBox createCheckBox(String msg,
                                    PositionInFrame position,
                                    DimensionInFrame dimension) {
        return null;
    }

    /**
     * Establece una etiqueta con su respectiva posición, dimensión, color de fondo, tipo de letra y nombre
     *
     * @param name              Nombre de la etiqueta
     * @param position          La posición de la etiqueta en el marco, en los ejes X e Y
     * @param dimension         La dimensión de la etiqueta en el marco, basado en ancho y largo
     * @param backgroundColor   Color de fondo de la etiqueta
     * @param fontType          Tipo de letra o fuente, de la etiqueta
     */
    @Override
    public void setLabel(String name,
                         PositionInFrame position,
                         DimensionInFrame dimension,
                         Color backgroundColor,
                         FontType fontType) {

        int font = (SUB_MENU_CURRENCY_CONVERTER.equals(name)) ? Font.ITALIC : Font.BOLD;

        // Establece la etiqueta con un nombre específico
        JLabel jLabel = new JLabel(name);

        // Establece la posición y la dimensión de la etiqueta
        jLabel.setBounds(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight());

        // Establece el tipo de letra de la etiqueta
        jLabel.setFont(new Font(fontType.getFontName(), font, fontType.getFontSize()));

        // Establece el color de fondo de esta etiqueta
        jLabel.setForeground(backgroundColor);

        // Añade la etiqueta al marco
        add(jLabel);
    }

    /**
     * Crea una barra de menú dentro del marco
     * No tiene uso en esta clase.
     *
     * @param backgroundColor       Color de fondo de la barra de menú
     * @return la barra de menú
     */
    @Override
    public JMenuBar createMenuBar(Color backgroundColor) {
        return null;
    }

    /**
     * Crea un menú para el marco actual
     * No tiene uso en esta clase.
     *
     * @param name              Nombre del menú
     * @param textColor         Color del texto del menú
     * @param backgroundColor   Color de fondo del menú
     * @param fontType          Tipo de letra del menú
     * @return el menú
     */
    @Override
    public JMenu createMenu(String name,
                            Color textColor,
                            Color backgroundColor,
                            FontType fontType) {
        return null;
    }

    /**
     * Crea items para el menú
     * En esta clase no tiene uso.
     *
     * @param name          Nombre del ítem
     * @param fontType      Tipo de letra del ítem
     * @param textColor     Color de texto del ítem
     * @return el ítem
     */
    @Override
    public JMenuItem createItemMenu(String name,
                                    FontType fontType,
                                    Color textColor) {
        return null;
    }

    /**
     * Crea un ComboBox en una posición y dimensión, con un texto, color de letra y color de fondo específicos.
     * En esta clase no tiene uso.
     *
     * @param position          Posición del ComboBox en coordenadas X e Y específicas
     * @param dimension         Dimensión del ComboBox de acuerdo a una base y altura específicas
     * @param textColor         Color del texto del ComboBox
     * @param backgroundColor   Color de fondo del ComboBox
     * @param fontType          Tipo de letra del texto del ComboBox
     * @return el ComboBox
     */
    @Override
    public JComboBox createComboBox(PositionInFrame position,
                                    DimensionInFrame dimension,
                                    Color textColor,
                                    Color backgroundColor,
                                    FontType fontType) {
        return null;
    }


    /**
     * Crea el Frame principal sobre el que se dispondrán el resto de los elementos.
     *
     * @param title             Título del Frame
     * @param colorBackground   Color de fondo del Frame
     */
    @Override
    public void createFrame(String title,
                            Color colorBackground) {

        // Establece el layout para el marco en nulo, para controlar las dimensiones.
        setLayout(null);

        // Establece operación de cierre de la app por defecto
        setDefaultCloseOperation(EXIT_ON_CLOSE); // definir operación de cierre de app por defecto

        // Establece título del Frame
        setTitle(title);

        // Establece el color de fondo del Frame
        getContentPane().setBackground(colorBackground); //
    }


    /**
     * Establece el ícono del Frame según una ruta específica
     *
     * @param imagePath Ruta de la imagen específica
     */
    @Override
    public void setIcon(String imagePath) {

        setIconImage(new ImageIcon(Objects
                .requireNonNull(getClass()
                .getResource(imagePath)))
                .getImage());
    }

    /**
     * Establece el logo en una posición y dimensión específicas
     *
     * @param logoPath   La ruta del logo
     * @param position   La posición del logo en el marco, en los ejes X e Y
     * @param dimension  La dimensión del logo en el marco, basado en ancho y largo
     */
    @Override
    public void createLogoLabel(String logoPath,
                                PositionInFrame position,
                                DimensionInFrame dimension) {

        // Crea el logo
        ImageIcon imageIcon = new ImageIcon(logoPath);

        // Crea la etiqueta que contendrá el logo
        JLabel jLabel = new JLabel(imageIcon);

        // Establece posición y dimensión de la etiqueta según parámetro
        jLabel.setBounds(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight());

        // Añade la etiqueta al marco
        add(jLabel);
    }

    /**
     * Evento del botón 'Ingresar'
     *
     * @param e el evento a ser procesado
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonEnter) {

            name = this.textFieldName.getText().trim(); // no se usa .this porque se hace una referencia estática

            // validación nombre vacío
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, MSG_INPUT_NAME);
            } else {

                // Instancia un objeto de la clase Licencia
                License ventanaLicencia = new License();

                // Establece las dimensiones de la nueva ventana.
                ventanaLicencia.setBounds(COORDENATE_X_LICENSE_WINDOW,
                        COORDENATE_Y_LICENSE_WINDOW,
                        WIDTH_LICENSE_WINDOW,
                        HEIGHT_LICENSE_WINDOW);

                // Cambia la visibilidad de la ventana
                ventanaLicencia.setVisible(true);

                // Establece la ventana como no reajustable
                ventanaLicencia.setResizable(false);

                // Establece la posición relativa en nulo
                ventanaLicencia.setLocationRelativeTo(null);

                // Elimina la visibilidad del Frame Welcome
                this.setVisible(false);
            }
        }
    }

    /**
     * Método principal que sirve como punto de entrada para esta aplicación.
     *
     * @param args standard param por main method
     */
    public static void main(String[] args) {

        // Crea una instancia de esta clase
        Welcome ventanaWelcome = new Welcome();

        // Establece la posición y dimensión de la clase
        ventanaWelcome.setBounds(COORDENATE_X_WELCOME_WINDOW,
                COORDENATE_Y_WELCOME_WINDOW,
                WIDTH_WELCOME_WINDOW,
                HEIGHT_WELCOME_WINDOW);

        // Establece la visibilidad del objeto
        ventanaWelcome.setVisible(true);

        // Establece la posición relativa del objeto
        ventanaWelcome.setLocationRelativeTo(null);

        // Establece la propiedad de reajustable del objeto
        ventanaWelcome.setResizable(false);
    }

    public void loadUserInterface(){

        // Configurar el FRAME
        createFrame(HEADER_WELCOME,
                COLOR_BACKGROUND_FRAME);

        setIcon(ICON);

        // Configurar el LOGO
        createLogoLabel(LOGO,
                POSITION_LABEL_LOGO,
                DIMENSION_LABEL_LOGO);

        // Configurar LABELS
        setLabel(SUB_MENU_CURRENCY_CONVERTER,
                POSITION_SUB_MENU_CURRENCY,
                DIMENSION_SUB_MENU_CURRENCY,
                COLOR_BACKGROUND_SUB_MENU_CURRENCY,
                FONT_SUB_MENU_CURRENCY);

        setLabel(LABEL_INPUT_NAME,
                POSITION_LABEL_INPUT_NAME,
                DIMENSION_LABEL_INPUT_NAME,
                COLOR_BACKGROUND_LABEL_INPUT_NAME,
                FONT_LABEL_INPUT_NAME);

        setLabel(LABEL_FOOTER,
                POSITION_LABEL_FOOTER,
                DIMENSION_LABEL_FOOTER,
                COLOR_BACKGROUND_LABEL_FOOTER,
                FONT_LABEL_FOOTER);

        // Configurar TEXTFIELDS
        this.textFieldName = createTextField(
                POSITION_TEXT_FIELD_NAME,
                DIMENSION_TEXT_FIELD_NAME,
                FONT_TEXT_FIELD_NAME,
                COLOR_FONT_TEXT_FIELD_NAME,
                COLOR_BACKGROUND_TEXT_FIELD_NAME);

        // Configurar BUTTONS
        this.buttonEnter = createButton(
                BUTTON_ENTER,
                POSITION_BUTTON_ENTER,
                DIMENSION_BUTTON_ENTER,
                FONT_BUTTON_ENTER,
                COLOR_FONT_BUTTON_ENTER,
                COLOR_BACKGROUND_BUTTON_ENTER,
                Boolean.FALSE);
    }
}