package src.main.business.display; // declara el paquete donde estarán ubicadas nuestras pantallas de usuario

import src.main.interfaces.UserInterface;
import src.main.model.currency.*;
import src.main.model.temperature.Celsius;
import src.main.model.temperature.Fahrenheit;
import src.main.model.temperature.Kelvin;
import src.main.model.temperature.Temperature;
import src.main.business.logic.TemperatureManager;
import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Set;

import static src.main.constants.Constant.*;

public class TemperatureConverter extends JFrame implements ActionListener, UserInterface {
    private JMenuItem menuItemCurrencyConverter;
    private JMenuItem menuItemAuthor;
    private JMenuItem menuItemRedColorBackground;
    private JMenuItem menuItemBlackColorBackground;
    private JMenuItem menuItemPurpleColorBackground;
    private JMenuItem menuItemNew;
    private JMenuItem menuItemExit;
    private JMenuItem menuItemReset;

    // Campos de texto
    private JTextField textFieldName;
    private JTextField textFieldValue;
    private JTextField textFieldLastName;
    private JTextField textFieldSurName;

    // Combobox
    private JComboBox comboBoxTemperature;
    private JComboBox comboBoxTemperaturePair;

    // Botón

    private JButton buttonCalculate;

    // Área de texto
    private JTextArea textArea;

    String name;
    TemperatureManager temperatureManager = new TemperatureManager();

    /**
     * Constructor que carga la interfaz de usuario a través del método loadUserInterface.
     */
    public TemperatureConverter() {

        loadUserInterface();
    }

    /**
     * Método que carga los combobox de datos.
     *
     * @param combobox  Componenente de la clase JComboBox
     * @param manager   Gestor encargado del manejo de objetos que se listarán en el compontente JComboBox
     */
    public void addTemperature(JComboBox combobox, TemperatureManager manager) {

        combobox.addItem(ITEM_OPTION_SELECT);

        Set<String> keys = manager.getMap().keySet();

        for (String key : keys) {

            Temperature value = manager.getMap().get(key);
            combobox.addItem(value.getName());
        }
    }

    /**
     * Método encargado del cambio de divisas
     *
     * @param temperature       Temperatura a cambiar
     * @param value             Valor a cambiar
     * @param temperaturePair   Temperatura a obtener
     * @param grade             Grado de la temperatura
     * @param gradePair         Grado de la temperatura par
     * @return valor de retorno correspondiente al cambio de divisas
     */
    public double cambioTemperatura(Temperature temperature, double value, Temperature temperaturePair,
                                    char grade, char gradePair) {

        double result = 0;

        switch (grade) {

            case SYMBOL_CELSIUS -> {

                switch (gradePair) {

                    case SYMBOL_FAHRENHEIT ->
                            result = Math.round((((value * 9) / 5) + temperaturePair.getvalorCelcius()) * 100d) / 100d;

                    case SYMBOL_KELVIN -> result = Math.round((temperaturePair.getvalorCelcius() + value) * 100d) / 100d;
                }
            }
            case SYMBOL_FAHRENHEIT -> {

                switch (gradePair) {

                    case SYMBOL_CELSIUS ->
                            result = Math.round((((value - temperature.getvalorCelcius()) * 5) / 9) * 100d) / 100d;

                    case SYMBOL_KELVIN -> result = Math.round((((value + 459.67) * 5) / 9) * 100d) / 100d;
                }
            }
            case SYMBOL_KELVIN -> {

                switch (gradePair) {

                    case SYMBOL_CELSIUS -> result = Math.round((value - temperature.getvalorCelcius()) * 100d) / 100d;

                    case SYMBOL_FAHRENHEIT -> result = Math.round((value * 1.8 - 459.67) * 100d) / 100d;
                }
            }
            default ->
                    result = Math.round(((value / temperature.getvalorCelcius()) * temperaturePair.getvalorCelcius()) * 100d) / 100d;
        }

        return result;
    }

    /**
     * Método encargado de preparar el mensaje de respuesta.
     *
     * @param userName          Nombre del usuario
     * @param userLastName      Apellido paterno del usuario
     * @param userSurName       Apellido materno del usuario
     * @param temperature       Temperatura a cambiar
     * @param temperaturePair   Temperatura a obtener
     * @param grade             Grado de la temperatura
     * @param value             Valor de la temperatura a cambiar
     * @param result            Resultado de la operación de cambio de temperatura
     */
    public void setText(String userName, String userLastName, String userSurName,
                        String temperature, String temperaturePair, char grade, double value, double result) {

        textArea.setText("\n El usuario " + userName + " " + userLastName + " " + userSurName
                + "\n cambió " + value + " °" + temperature
                + "\n por " + temperaturePair
                + "\n y recibe a cambio " + result + " °" + grade);
    }

    /**
     * Método encargado de la creación del frame de la app
     *
     * @param title             Título del frame de la app
     * @param colorBackground   Color de fondo del frame de la app
     */
    @Override
    public void createFrame(String title, Color colorBackground) {

        setLayout(null); // marco de trabajo
        setDefaultCloseOperation(EXIT_ON_CLOSE); // operación de cierre por defecto
        setTitle(title); // título
        getContentPane().setBackground(colorBackground); // fondo por defecto
    }

    /**
     * Método encargado de establecer el ícono de la app
     *
     * @param imagePath Ruta de la imagen que se utilizará como ícono para el frame de la app
     */
    @Override
    public void setIcon(String imagePath) {

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath))).getImage()); // ícono
    }

    /**
     * Establece el logo dentro del marco específico
     *
     * @param logoPath   La ruta del logo
     * @param position   La posición del logo en el marco, en los ejes X e Y
     * @param dimension  La dimensión del logo en el marco, basado en ancho y largo
     */
    @Override
    public void createLogoLabel(String logoPath, PositionInFrame position, DimensionInFrame dimension) {

        // Establece el logo como imagen
        ImageIcon imageIcon = new ImageIcon(logoPath);

        // Establece etiqueta que contiene el logo
        JLabel jLabel = new JLabel(imageIcon);

        // Establece la posición y la dimensión de la etiqueta
        jLabel.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

        // Añade la etiqueta dentro del marco
        add(jLabel);
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
    public void setLabel(String name, PositionInFrame position, DimensionInFrame dimension, Color backgroundColor, FontType fontType) {

        // Establece la etiqueta con un nombre específico
        JLabel jLabel = new JLabel(name);

        // Establece la posición y la dimensión de la etiqueta
        jLabel.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

        // Establece el tipo de letra de la etiqueta
        jLabel.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de fondo de esta etiqueta
        jLabel.setForeground(backgroundColor);

        // Añade la etiqueta al marco
        add(jLabel);
    }

    /**
     * Crea una barra de menú dentro del marco
     *
     * @param backgroundColor Color de fondo de la barra de menú
     * @return la barra de menú
     */
    @Override
    public JMenuBar createMenuBar(Color backgroundColor) {

        // Crea la barra de menú
        JMenuBar jMenuBar = new JMenuBar();

        // Establece el color de fondo de la barra de menú
        jMenuBar.setBackground(backgroundColor);

        // Añade la barra de menú al marco
        setJMenuBar(jMenuBar);

        // Retorna la barra de menú
        return jMenuBar;
    }

    /**
     * Crea un menú para el marco actual
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

        // Crea el menú
        JMenu jMenu = new JMenu(name);

        // Establece el color de la letra del menú
        jMenu.setForeground(textColor); // color fuente

        // Establece el color de fondo del menú
        jMenu.setBackground(backgroundColor);

        // Establece el tipo de letra del menú
        jMenu.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Retorna el menú
        return jMenu;
    }

    /**
     * Crea items para el menú
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

        // Crea el ítem del menú
        JMenuItem jMenuItem = new JMenuItem(name);

        // Establece el tipo de letra para el ítem
        jMenuItem.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de la letra del ítem
        jMenuItem.setForeground(textColor);

        // Añade un evento a este ítem
        jMenuItem.addActionListener(this);

        // Retorna el ítem
        return jMenuItem;
    }

    /**
     * Crea un ComboBox en una posición y dimensión, con un texto, color de letra y color de fondo específicos.
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

        // Crea el componente ComboBox
        JComboBox jComboBox = new JComboBox();

        // Establece la posición y dimensión del ComboBox dentro del marco
        jComboBox.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

        // Establece el color de letra del texto del ComboBox
        jComboBox.setForeground(textColor);

        // Establece el color de fondo del ComboBox
        jComboBox.setBackground(backgroundColor);

        // Establece el tipo de letra del ComboBox
        jComboBox.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Añade el ComboBox al marco
        add(jComboBox);

        // Retorna el ComboBox
        return jComboBox;
    }

    /**
     * Crea un elemento de campo de texto según una posición, dimensión, tipo de letra, color de fondo y
     * color de letra específicos
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
        JTextField jTextField = new JTextField();

        // Establece la posición y dimensión específicas del campo de texto dentro del marco
        jTextField.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

        // Establece el tipo de letra o fuente del campo de texto
        jTextField.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de fondo del campo de texto
        jTextField.setBackground(backgroundColor);

        // Establece el color de la letra del campo de texto
        jTextField.setForeground(fontColor);

        // Añade el campo de texto al marco principal
        add(jTextField);

        // Retorna el campo de texto
        return jTextField;
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
    public JButton createButton(String name, PositionInFrame position, DimensionInFrame dimension,
                                FontType fontType, Color textColor, Color backgroundColor, boolean isEnabled) {

        // Crea el botón con un nombre específico
        JButton jButton = new JButton(name);

        // Establece la posición y dimensión específica del botón en el marco
        jButton.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

        // Establece el tipo de fuente que tendrá el botón
        jButton.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de la fuente del botón
        jButton.setForeground(textColor);

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
     * @param text              Texto que mostrará el área de texto
     * @param isEnabled         Estado del área de texto
     * @param fontType          Tipo de letra del texto del área de texto
     * @param textColor         Color de la letra del texto del área de texto
     * @param backgroundColor   Color de fondo del área de texto
     * @return el área de texto
     */
    @Override
    public JTextArea createTextArea(String text, boolean isEnabled,
                                    FontType fontType,
                                    Color textColor,
                                    Color backgroundColor) {

        // Crea el componente de área de texto
        JTextArea jTextArea = new JTextArea();

        // Establece el estado del componente según parámetro
        jTextArea.setEditable(isEnabled);

        // Establece color de letra del texto
        jTextArea.setForeground(textColor);

        // Establece color de fondo del área de texto
        jTextArea.setBackground(backgroundColor);

        // Establece la fuente del texto
        jTextArea.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el texto según parámetro
        jTextArea.setText(text);

        // Retorna el área de texto
        return jTextArea;
    }

    /**
     * Crea un elemento Scroll dentro un área de texto específico de acuerdo a una posición y dimensión
     * específicas.
     * @param textArea      El área de texto dentro del marco
     * @param position      Posición específica dentro del área de texto
     * @param dimension     Dimensión específica dentro del área de texto
     */
    @Override
    public void createScrollPane(JTextArea textArea, PositionInFrame position, DimensionInFrame dimension) {

        // Crea el elemento Scroll dentro del ámbito del área de texto
        JScrollPane jScrollPane = new JScrollPane(textArea);

        // Establece la posición y dimensión específicas del elemento Scroll dentro del área
        jScrollPane.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

        // Añade el elemento al marco principal
        add(jScrollPane);
    }

    /**
     * Crea un elemento checkBox con una posición y dimensión específica.
     * En esta clase no tiene uso.
     *
     * @param msg       Mensaje que mostrará el checkbox.
     * @param position  Posición del checkbox en coordenadas X y Y
     * @param dimension Dimensión del checkbox según base y altura
     * @return el checkbox
     */
    @Override
    public JCheckBox createCheckBox(String msg, PositionInFrame position,
                                    DimensionInFrame dimension) {
        return null;
    }

    /**
     * Método encargado de los eventos a ejecutarse por el usuario
     * @param e el evento a ser procesado
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonCalculate) {

            double value = 0;
            double result = 0;
            boolean fail = Boolean.FALSE;
            boolean isAbsoluteZero = Boolean.FALSE;

            Fahrenheit fahrenheit = (Fahrenheit) temperatureManager.getTemperature(ITEM_TEMPERATURE_FAHRENHEIT);
            Kelvin kelvin = (Kelvin) temperatureManager.getTemperature(ITEM_TEMPERATURE_KELVIN);
            Celsius celsius = (Celsius) temperatureManager.getTemperature(ITEM_TEMPERATURE_CELSIUS);

            String userName = this.textFieldName.getText();
            String userLastName = this.textFieldLastName.getText();
            String userSurName = this.textFieldSurName.getText();

            String temperature = "";
            String temperaturePair = "";
            char grade;
            char gradePair = 'a';

            try {

                if (textFieldValue != null) {

                    value = Double.parseDouble(textFieldValue.getText());
                }
            } catch (NumberFormatException err) {

                fail = Boolean.TRUE;
            }

            if (fail) {

                JOptionPane.showMessageDialog(null, MSG_INVALID_VALUE_EMPTY_OR_SPECIAL_CHAR,
                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
            } else {

                if (Objects.equals(comboBoxTemperature.getSelectedItem(), ITEM_OPTION_SELECT) ||
                        Objects.equals(comboBoxTemperaturePair.getSelectedItem(), ITEM_OPTION_SELECT)) {

                    JOptionPane.showMessageDialog(null, MSG_INVALID_EQUAL_TEMPERATURE_PAIR,
                            MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                } else {

                    switch (Objects.requireNonNull(comboBoxTemperature.getSelectedItem()).toString()) {

                        case ITEM_TEMPERATURE_CELSIUS -> {

                            temperature = celsius.getName();
                            grade = celsius.getUnit();
                            isAbsoluteZero = isLowerThanAbsoluteZero(value, ITEM_TEMPERATURE_CELSIUS);

                            if (isAbsoluteZero) {

                                JOptionPane.showMessageDialog(null, MSG_ABS_ZERO_INPUT,
                                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                            } else {

                                switch (Objects.requireNonNull(comboBoxTemperaturePair.getSelectedItem()).toString()) {

                                    case ITEM_TEMPERATURE_FAHRENHEIT -> {

                                        temperaturePair = fahrenheit.getName();
                                        gradePair = fahrenheit.getUnit();

                                        result = this.cambioTemperatura(celsius,
                                                value, fahrenheit, grade, gradePair);

                                    }
                                    case ITEM_TEMPERATURE_KELVIN -> {

                                        temperaturePair = kelvin.getName();
                                        gradePair = kelvin.getUnit();

                                        result = this.cambioTemperatura(celsius,
                                                value, kelvin, grade, gradePair);
                                    }
                                    default -> fail = Boolean.TRUE;
                                }
                            }

                        }
                        case ITEM_TEMPERATURE_FAHRENHEIT -> {

                            temperature = fahrenheit.getName();
                            grade = fahrenheit.getUnit();
                            isAbsoluteZero = isLowerThanAbsoluteZero(value, ITEM_TEMPERATURE_FAHRENHEIT);

                            if (isAbsoluteZero) {

                                JOptionPane.showMessageDialog(null, MSG_ABS_ZERO_INPUT,
                                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                            } else {

                                switch (Objects.requireNonNull(comboBoxTemperaturePair.getSelectedItem()).toString()) {

                                    case ITEM_TEMPERATURE_CELSIUS -> {

                                        temperaturePair = celsius.getName();
                                        gradePair = celsius.getUnit();

                                        result = this.cambioTemperatura(fahrenheit,
                                                value, celsius, grade, gradePair);
                                    }
                                    case ITEM_TEMPERATURE_KELVIN -> {

                                        temperaturePair = kelvin.getName();
                                        gradePair = kelvin.getUnit();

                                        result = this.cambioTemperatura(fahrenheit,
                                                value, kelvin, grade, gradePair);
                                    }
                                    default -> fail = Boolean.TRUE;
                                }
                            }
                        }
                        case ITEM_TEMPERATURE_KELVIN -> {

                            temperature = kelvin.getName();
                            grade = kelvin.getUnit();
                            isAbsoluteZero = isLowerThanAbsoluteZero(value, ITEM_TEMPERATURE_KELVIN);

                            if (isAbsoluteZero) {

                                JOptionPane.showMessageDialog(null, MSG_ABS_ZERO_INPUT,
                                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                            } else {

                                switch (Objects.requireNonNull(comboBoxTemperaturePair.getSelectedItem()).toString()) {

                                    case ITEM_TEMPERATURE_FAHRENHEIT -> {

                                        temperaturePair = fahrenheit.getName();
                                        gradePair = fahrenheit.getUnit();

                                        result = this.cambioTemperatura(kelvin,
                                                value, fahrenheit, grade, gradePair);
                                    }
                                    case ITEM_TEMPERATURE_CELSIUS -> {

                                        temperaturePair = celsius.getName();
                                        gradePair = celsius.getUnit();

                                        result = this.cambioTemperatura(kelvin,
                                                value, celsius, grade, gradePair);
                                    }
                                    default -> fail = Boolean.TRUE;
                                }
                            }
                        }
                    }

                    if(isAbsoluteZero){

                        JOptionPane.showMessageDialog(null, ABSOLUTE_ZERO_ERROR_MSG);
                    } else {

                        if (fail) {
                            JOptionPane.showMessageDialog(null, MSG_INVALID_EQUAL_TEMPERATURE_PAIR,
                                    MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                        } else {
                            setText(userName, userLastName, userSurName, temperature, temperaturePair,
                                    gradePair, value, result);
                        }
                    }
                }
            }
        }


        if (e.getSource() == menuItemCurrencyConverter) {
            CurrencyConverter ventanaConversorDivisa = new CurrencyConverter(); // instancia principal
            ventanaConversorDivisa.setBounds(
                    COORDENATE_X_CURRENCY_WINDOW,
                    COORDENATE_Y_CURRENCY_WINDOW,
                    WIDTH_CURRENCY_WINDOW,
                    HEIGHT_CURRENCY_WINDOW); // dimensiones
            ventanaConversorDivisa.setVisible(true); // principal visible
            ventanaConversorDivisa.setResizable(false); // ventana redimensionable
            ventanaConversorDivisa.setLocationRelativeTo(null); // posición relativa
            this.setVisible(false); // esconde la pantalla de licencia
        }

        if (e.getSource() == menuItemAuthor) {

            JOptionPane.showMessageDialog(null, MSG_INFO_APP + "\n"
                    + MSG_EMAIL + "\n"
                    + MSG_INFO_EDUCATION);
        }

        if (e.getSource() == menuItemPurpleColorBackground) {

            getContentPane().setBackground(COLOR_BACKGROUND_PURPLE);
        }

        if (e.getSource() == menuItemBlackColorBackground) {

            getContentPane().setBackground(COLOR_BACKGROUND_BLACK);
        }

        if (e.getSource() == menuItemRedColorBackground) {

            getContentPane().setBackground(COLOR_BACKGROUND_RED);
        }

        if (e.getSource() == menuItemNew) {

            Welcome ventanaWelcome = new Welcome();
            ventanaWelcome.setBounds(
                    COORDENATE_X_WELCOME_WINDOW,
                    COORDENATE_Y_WELCOME_WINDOW,
                    WIDTH_WELCOME_WINDOW,
                    HEIGHT_WELCOME_WINDOW);
            ventanaWelcome.setVisible(true);
            ventanaWelcome.setLocationRelativeTo(null);
            ventanaWelcome.setResizable(false);
            this.setVisible(false);

        }

        if (e.getSource() == menuItemExit) {

            System.exit(0);
        }

        if (e.getSource() == menuItemReset) {

            textFieldName.setText("");
            textFieldLastName.setText("");
            textFieldSurName.setText("");
            comboBoxTemperaturePair.setSelectedIndex(0);
            comboBoxTemperature.setSelectedIndex(0);
            assert textFieldValue != null;
            textFieldValue.setText("");
            textArea.setText(TEXT_FIELD_TEMPERATURE_RESULT);
        }
    }


    /**
     * Método responsable de validar si el valor es menor que el cero absoluto
     *
     * @param value Valor a validar
     * @param grade Símbolo correspondiente al tipo de temperatura
     * @return valor booleano, es más bajo que el creo absoluto o no
     */
    public boolean isLowerThanAbsoluteZero(double value, String grade) {

        boolean isLower;

        isLower = switch (grade) {
            case ITEM_TEMPERATURE_CELSIUS -> (-273.15d > value) ? Boolean.TRUE : Boolean.FALSE;
            case ITEM_TEMPERATURE_FAHRENHEIT -> (-459.67d > value) ? Boolean.TRUE : Boolean.FALSE;
            case ITEM_TEMPERATURE_KELVIN -> (0 > value) ? Boolean.TRUE : Boolean.FALSE;
            default -> Boolean.FALSE;
        };

        return isLower;
    }

    /**
     * Método responsable de la carga de la interfaz de usuario
     */
    public void loadUserInterface(){

        createFrame(SUB_MENU_CURRENCY_CONVERTER, COLOR_BACKGROUND_FRAME);
        setIcon(ICON);

        name = Welcome.name; // obtiene nombre desde Welcome

        // Menu Bar
        JMenuBar jMenuBar = createMenuBar(COLOR_BACKGROUND_MENU_BAR);

        // Menu
        JMenu jMenuOptions = createMenu(
                MENU_OPTIONS,
                COLOR_FONT_MENU_OPTIONS,
                COLOR_BACKGROUND_MENU_OPTIONS,
                FONT_MENU_OPTIONS);

        JMenu jMenuConverters = createMenu(
                MENU_CONVERTER,
                COLOR_FONT_MENU_CONVERTERS,
                COLOR_BACKGROUND_MENU_CONVERTERS,
                FONT_MENU_CONVERTERS);

        JMenu jMenuAboutMe = createMenu(
                MENU_ABOUT_ME,
                COLOR_FONT_MENU_ABOUT_ME,
                COLOR_BACKGROUND_MENU_ABOUT_ME,
                FONT_MENU_ABOUT_ME);

        // Menu items
        JMenuItem jMenuItemBackgroundColor = createMenu(
                SUB_MENU_COLOR_FONDO,
                COLOR_FONT_MENU_ITEM_BACKGROUND_COLOR,
                COLOR_BACKGROUND_MENU_ITEM_BACKGROUND_COLOR,
                FONT_MENU_ITEM_BACKGROUND_COLOR);

        JMenuItem jMenuItemTemperatureConverter = createItemMenu(
                SUB_MENU_TEMPERATURE_CONVERTER,
                FONT_MENU_ITEM_TEMPERATURE_CONVERTER,
                COLOR_BACKGROUND_MENU_ITEM_TEMPERATURE_CONVERTER);

        menuItemCurrencyConverter = createItemMenu(
                SUB_MENU_CURRENCY_CONVERTER,
                FONT_MENU_ITEM_CURRENCY_CONVERTER,
                COLOR_BACKGROUND_MENU_ITEM_CURRENCY_CONVERTER);

        menuItemRedColorBackground = createItemMenu(
                SUB_MENU_RED_BACKGROUND,
                FONT_SUB_MENU_RED_BACKGROUND,
                COLOR_FONT_SUB_MENU_RED_BACKGROUND);

        menuItemBlackColorBackground = createItemMenu(
                SUB_MENU_BLACK_BACKGROUND,
                FONT_SUB_MENU_BLACK_BACKGROUND,
                COLOR_FONT_SUB_MENU_BLACK_BACKGROUND);

        menuItemPurpleColorBackground = createItemMenu(
                SUB_MENU_PURPLE_BACKGROUND,
                FONT_SUB_MENU_PURPLE_BACKGROUND,
                COLOR_FONT_SUB_MENU_PURPLE_BACKGROUND);

        menuItemNew = createItemMenu(
                SUB_MENU_NEW,
                FONT_SUB_MENU_NEW,
                COLOR_FONT_SUB_MENU_NEW);

        menuItemAuthor = createItemMenu(
                SUB_MENU_AUTHOR,
                FONT_SUB_MENU_AUTHOR,
                COLOR_FONT_SUB_MENU_AUTHOR);

        menuItemExit = createItemMenu(
                SUB_MENU_EXIT,
                FONT_SUB_MENU_EXIT,
                COLOR_FONT_SUB_MENU_EXIT);

        menuItemReset = createItemMenu(
                SUB_MENU_LIMPIAR_CAMPOS,
                FONT_SUB_MENU_LIMPIAR_CAMPOS,
                COLOR_FONT_SUB_MENU_LIMPIAR_CAMPOS);

        jMenuBar.add(jMenuOptions); // añade el menu de opciones a la barra de menú
        jMenuBar.add(jMenuConverters); // añade el menu de conversores a la barra de menú
        jMenuBar.add(jMenuAboutMe); // añade el menu "sobre mí" a la barra de menú

        jMenuOptions.add(jMenuItemBackgroundColor); // añade el menu item de color de fondo al menú de opciones
        jMenuOptions.add(menuItemNew); // añade el menu item nuevo al menu de opciones
        jMenuOptions.add(menuItemExit); // añade el menu item salir al menu de opciones
        jMenuOptions.add(menuItemReset); // añade el menu item reset al menu de opciones

        jMenuConverters.add(jMenuItemTemperatureConverter); // añade el menu item de conversor de temperaturas al menu de conversores
        jMenuConverters.add(menuItemCurrencyConverter); // añade menu item conversor de divisa a menu conversores

        jMenuAboutMe.add(menuItemAuthor); // añade el menu item autor al menu "sobre mi"

        jMenuItemBackgroundColor.add(menuItemRedColorBackground); // añade menu item color rojo a menu item color fondo
        jMenuItemBackgroundColor.add(menuItemBlackColorBackground); // añade menu item color negro a menu item color fondo
        jMenuItemBackgroundColor.add(menuItemPurpleColorBackground); // añade menu item color morado a menu item color fondo

        // Logo
        createLogoLabel(
                LOGO,
                POSITION_LOGO,
                DIMENSION_LOGO);

        // Etiquetas
        setLabel(LABEL_VALUE + ":",
                POSITION_LABEL_VALUE,
                DIMENSION_LABEL_VALUE,
                COLOR_BACKGROUND_LABEL_VALUE,
                FONT_LABEL_VALUE);

        setLabel(LABEL_TITLE + name,
                POSITION_LABEL_TITLE,
                DIMENSION_LABEL_TITLE,
                COLOR_BACKGROUND_LABEL_TITLE,
                FONT_LABEL_TITLE);

        setLabel(LABEL_SUBTITLE,
                POSITION_LABEL_SUBTITLE,
                DIMENSION_LABEL_SUBTITLE,
                COLOR_BACKGROUND_LABEL_SUBTITLE,
                FONT_LABEL_SUBTITLE);

        setLabel(LABEL_NAME,
                POSITION_LABEL_NAME,
                DIMENSION_LABEL_NAME,
                COLOR_BACKGROUND_LABEL_NAME,
                FONT_LABEL_NAME);

        setLabel(LABEL_LASTNAME + ":",
                POSITION_LABEL_LASTNAME,
                DIMENSION_LABEL_LASTNAME,
                COLOR_BACKGROUND_LABEL_LASTNAME,
                FONT_LABEL_LASTNAME);

        setLabel(LABEL_SURNAME + ":",
                POSITION_LABEL_SURNAME,
                DIMENSION_LABEL_SURNAME,
                COLOR_BACKGROUND_LABEL_SURNAME,
                FONT_LABEL_SURNAME);

        setLabel(LABEL_TO_CHANGE_FROM + ":",
                POSITION_LABEL_TO_CHANGE_FROM,
                DIMENSION_LABEL_TO_CHANGE_FROM,
                COLOR_BACKGROUND_LABEL_TO_CHANGE_FROM,
                FONT_LABEL_TO_CHANGE_FROM);

        setLabel(LABEL_TO_CHANGE_TO + ":",
                POSITION_LABEL_TO_CHANGE_TO,
                DIMENSION_LABEL_TO_CHANGE_TO,
                COLOR_BACKGROUND_LABEL_TO_CHANGE_TO,
                FONT_LABEL_TO_CHANGE_TO);

        setLabel(TEXT_FIELD_CALCULATION_RESULT + ":",
                POSITION_TEXT_FIELD_CALCULATION_RESULT,
                DIMENSION_TEXT_FIELD_CALCULATION_RESULT,
                COLOR_BACKGROUND_TEXT_FIELD_CALCULATION_RESULT,
                FONT_TEXT_FIELD_CALCULATION_RESULT);

        setLabel(LABEL_FOOTER,
                POSITION_LABEL_CONVERTER_FOOTER,
                DIMENSION_LABEL_CONVERTER_FOOTER,
                COLOR_BACKGROUND_LABEL_CONVERTER_FOOTER,
                FONT_LABEL_CONVERTER_FOOTER);

        // Campos de texto
        textFieldName = createTextField(
                POSITION_TEXTFIELD_NAME,
                DIMENSION_TEXTFIELD_NAME,
                FONT_TEXTFIELD_NAME,
                COLOR_BACKGROUND_TEXTFIELD_NAME,
                COLOR_FONT_TEXTFIELD_NAME);

        textFieldValue = createTextField(
                POSITION_TEXTFIELD_VALUE,
                DIMENSION_TEXTFIELD_VALUE,
                FONT_TEXTFIELD_VALUE,
                COLOR_BACKGROUND_TEXTFIELD_VALUE,
                COLOR_FONT_TEXTFIELD_VALUE);

        textFieldLastName = createTextField(
                POSITION_TEXTFIELD_LASTNAME,
                DIMENSION_TEXTFIELD_LASTNAME,
                FONT_TEXTFIELD_LASTNAME,
                COLOR_BACKGROUND_TEXTFIELD_LASTNAME,
                COLOR_FONT_TEXTFIELD_LASTNAME);

        textFieldSurName = createTextField(
                POSITION_TEXTFIELD_SURNAME,
                DIMENSION_TEXTFIELD_SURNAME,
                FONT_TEXTFIELD_SURNAME,
                COLOR_BACKGROUND_TEXTFIELD_SURNAME,
                COLOR_FONT_TEXTFIELD_SURNAME);

        // Botones
        buttonCalculate = createButton(
                BUTTON_CALCULATE,
                POSITION_BUTTON_CALCULATE,
                DIMENSION_BUTTON_CALCULATE,
                FONT_BUTTON_CALCULATE,
                COLOR_BACKGROUND_BUTTON_CALCULATE,
                COLOR_FONT_BUTTON_CALCULATE,
                Boolean.FALSE);

        // ComboBox
        comboBoxTemperature = createComboBox(
                POSITION_COMBOBOX_CONVERTER,
                DIMENSION_COMBOBOX_CONVERTER,
                COLOR_BACKGROUND_COMBOBOX_CONVERTER,
                COLOR_FONT_COMBOBOX_CONVERTER,
                FONT_COMBOBOX_CONVERTER);

        comboBoxTemperaturePair = createComboBox(
                POSITION_COMBOBOX_CONVERTER_PAIR,
                DIMENSION_COMBOBOX_CONVERTER_PAIR,
                COLOR_BACKGROUND_COMBOBOX_CONVERTER_PAIR,
                COLOR_FONT_COMBOBOX_CONVERTER_PAIR,
                FONT_COMBOBOX_CONVERTER_PAIR);

        // Area de texto
        textArea = createTextArea(
                TEXT_FIELD_CURRENCY_RESULT,
                Boolean.FALSE,
                FONT_TEXT_FIELD_CURRENCY_RESULT,
                COLOR_FONT_TEXT_FIELD_CURRENCY_RESULT,
                COLOR_BACKGROUND_TEXT_FIELD_CURRENCY_RESULT);

        // Scroll
        createScrollPane(textArea,
                POSITION_SCROLL_PANE,
                DIMENSION_SCROLL_PANE);

        // Se añaden las temperaturas a la lista de temperaturas
        this.temperatureManager.addTemperature(ITEM_TEMPERATURE_CELSIUS, new Celsius(ITEM_TEMPERATURE_CELSIUS, 0d));
        this.temperatureManager.addTemperature(ITEM_TEMPERATURE_KELVIN, new Kelvin(ITEM_TEMPERATURE_KELVIN, 273.15d));
        this.temperatureManager.addTemperature(ITEM_TEMPERATURE_FAHRENHEIT, new Fahrenheit(ITEM_TEMPERATURE_FAHRENHEIT, 32d));

        // Poblar ComboBox
        addTemperature(comboBoxTemperature, temperatureManager);
        addTemperature(comboBoxTemperaturePair, temperatureManager);
    }

    /**
     * Método que sirve como punto de entrada para la ejecución de la aplicación.
     *
     * @param args parámetro por defecto del método main
     */
    public static void main(String[] args) {

        TemperatureConverter ventanaTemperatureConverter = new TemperatureConverter();
        ventanaTemperatureConverter.setBounds(0, 0, 640, 535);
        ventanaTemperatureConverter.setVisible(true);
        ventanaTemperatureConverter.setResizable(false);
        ventanaTemperatureConverter.setLocationRelativeTo(null);
    }
}