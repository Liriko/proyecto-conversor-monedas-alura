package src.main.business.display; // declara el paquete donde estarán ubicadas nuestras pantallas de usuario

import src.main.interfaces.UserInterface;
import src.main.model.temperature.Celsius;
import src.main.model.temperature.Fahrenheit;
import src.main.model.temperature.Kelvin;
import src.main.model.temperature.Temperature;
import src.main.business.logic.GestorTemperatura;
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

/*
    Autor: Jorge Daniel Salgado Pons
	Fecha: 25-02-2023

	Propósito: Esta es la pantalla del conversor de temperaturas, donde el usuario
	podrá cambiar entre temperaturas.
	Esta pantalla, además, cuenta con una barra de menú con varias opciones
	entre las cuales destacan funcionalidades para cambiar el color de la app,
	para cambiar entre distintos conversores e incluso para saber más sobre
	el autor de esta app.

	Nuestra clase ConversorTemperaturas es una clase hija de la clase JFrame e implementa
	la interfaz ActionListener de la librería awt.event.* y también
	implementa una interfaz propia llamada Front que diseñé para mejorar
	las implementaciones de interfaz gráfica.
 */
public class ConversorTemperatura extends JFrame implements ActionListener, UserInterface {
    private final JMenuItem menuItemConversorDivisa;
    private final JMenuItem menuItemAutor;
    private final JMenuItem menuItemColorRojo;
    private final JMenuItem menuItemColorNegro;
    private final JMenuItem menuItemColorMorado;
    private final JMenuItem menuItemNuevo;
    private final JMenuItem menuItemSalir;
    private final JMenuItem menuItemReset;

    // Campos de texto
    private final JTextField txf_nombre;
    private final JTextField txf_valor;
    private final JTextField txf_apellidoPaterno;
    private final JTextField txf_apellidoMaterno;

    // Combobox
    private final JComboBox cbx_temperatura1;
    private final JComboBox cbx_temperatura2;

    // Botón

    private final JButton btn_calcular;

    // Área de texto
    private final JTextArea txa_area_01;

    String nombre;
    GestorTemperatura gestor = new GestorTemperatura();

    public ConversorTemperatura() {

        createFramework(SUB_MENU_TEMPERATURE_CONVERTER, new Color(147, 82, 210));
        stablishIcon(ICONO);

        nombre = Bienvenida.nombre; // obtiene nombre desde bienvenida

        // Inicio configuración de menú ********************************************************************

        // Menu Bar
        JMenuBar barraMenu = creaBarraDeMenu(147, 82, 210);
        // Menu
        JMenu menuOpciones = creaMenu(MENU_OPTIONS, 255, 0, 0,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 255, 255);
        JMenu menuConversores = creaMenu(MENU_CONVERTER, 255, 0, 0,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 255, 255);
        JMenu menuSobreMi = creaMenu(MENU_ABOUT_ME, 255, 0, 0,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 255, 255);
        // Menu items
        JMenuItem menuItemColorFondo = creaMenu(SUB_MENU_COLOR_FONDO, 255, 0, 0,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        this.menuItemConversorDivisa = creaMenuItem(SUB_MENU_CURRENCY_CONVERTER,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        JMenuItem menuItemConversorTemperatura = creaMenuItem(SUB_MENU_TEMPERATURE_CONVERTER,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        menuItemColorRojo = creaMenuItem(SUB_MENU_RED_BACKGROUND,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        menuItemColorNegro = creaMenuItem(SUB_MENU_BLACK_BACKGROUND,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        menuItemColorMorado = creaMenuItem(SUB_MENU_PURPLE_BACKGROUND,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        menuItemNuevo = creaMenuItem(SUB_MENU_NEW,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        menuItemAutor = creaMenuItem(SUB_MENU_AUTHOR,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        menuItemSalir = creaMenuItem(SUB_MENU_EXIT,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        menuItemReset = creaMenuItem(SUB_MENU_LIMPIAR_CAMPOS,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);

        barraMenu.add(menuOpciones); // añade el menu de opciones a la barra de menú
        barraMenu.add(menuConversores); // añade el menu de conversores a la barra de menú
        barraMenu.add(menuSobreMi); // añade el menu "sobre mí" a la barra de menú

        menuOpciones.add(menuItemColorFondo); // añade el menu item de color de fondo al menú de opciones
        menuOpciones.add(menuItemNuevo); // añade el menu item nuevo al menu de opciones
        menuOpciones.add(menuItemSalir); // añade el menu item salir al menu de opciones
        menuOpciones.add(menuItemReset); // añade el menu item reset al menu de opciones

        menuConversores.add(menuItemConversorDivisa); // añade el menu item de conversor de divisa al menu de conversores
        menuConversores.add(menuItemConversorTemperatura); // añade menu item conversor temperatura a menu conversores

        menuSobreMi.add(menuItemAutor); // añade el menu item autor al menu "sobre mi"

        menuItemColorFondo.add(menuItemColorRojo); // añade menu item color rojo a menu item color fondo
        menuItemColorFondo.add(menuItemColorNegro); // añade menu item color negro a menu item color fondo
        menuItemColorFondo.add(menuItemColorMorado); // añade menu item color morado a menu item color fondo

        // Fin configuración de menu ************************************************************************

        // Configuración de etiquetas, botones y otros componentes del Front ********************************

        // Logo
        stablishLogo(LOGO, new PositionInFrame(5, 5), new DimensionInFrame(250, 140));

        // Etiquetas
        stablishLabel(LABEL_VALUE + ":",
                new PositionInFrame(480, 188),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        stablishLabel(LABEL_TITLE + nombre,
                new PositionInFrame(280, 30),
                new DimensionInFrame(300, 50),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 32));

        stablishLabel(LABEL_SUBTITLE,
                new PositionInFrame(45, 140),
                new DimensionInFrame(900, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 24));

        stablishLabel(LABEL_NAME,
                new PositionInFrame(25, 188),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        stablishLabel(LABEL_LASTNAME + ":",
                new PositionInFrame(25, 248),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        stablishLabel(LABEL_SURNAME + ":",
                new PositionInFrame(25, 308),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        stablishLabel(LABEL_TO_CHANGE_FROM + ":",
                new PositionInFrame(220, 188),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        stablishLabel(LABEL_A + ":",
                new PositionInFrame(220, 248),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        stablishLabel(TEXT_FIELD_CALCULATION_RESULT + ":",
                new PositionInFrame(220, 307),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        stablishLabel(LABEL_FOOTER,
                new PositionInFrame(195, 445),
                new DimensionInFrame(500, 30),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        // Campos de texto
        txf_nombre = createTextField(new PositionInFrame(25, 213),
                new DimensionInFrame(150, 25),
                new FontType(FONT_ANDALE_MONO, 14),
                new Color(224, 224, 224),
                new Color(255, 0, 0));

        txf_valor = createTextField(new PositionInFrame(480, 213),
                new DimensionInFrame(125, 25),
                new FontType(FONT_ANDALE_MONO, 14),
                new Color(224, 224, 224),
                new Color(255, 0, 0));

        txf_apellidoPaterno = createTextField(new PositionInFrame(25, 273),
                new DimensionInFrame(150, 25),
                new FontType(FONT_ANDALE_MONO, 14),
                new Color(224, 224, 224),
                new Color(255, 0, 0));

        txf_apellidoMaterno = createTextField(new PositionInFrame(25, 334),
                new DimensionInFrame(150, 25),
                new FontType(FONT_ANDALE_MONO, 14),
                new Color(224, 224, 224),
                new Color(255, 0, 0));

        // Botones
        btn_calcular = creaBoton(BUTTON_CALCULATE,
                480, 258, 125, 45,
                FONT_ANDALE_MONO, Font.BOLD, 20,
                255, 0, 0,
                0, 0, 0, false);

        // ComboBox
        cbx_temperatura1 = creaComboBox(220, 213, 220, 25,
                224, 224, 224,
                255, 0, 0,
                FONT_ANDALE_MONO, Font.BOLD, 14);
        cbx_temperatura2 = creaComboBox(220, 273, 220, 25,
                224, 224, 224,
                255, 0, 0,
                FONT_ANDALE_MONO, Font.BOLD, 14);

        // Area de texto
        txa_area_01 = creaAreaDeTexto(TEXT_FIELD_TEMPERATURE_RESULT, Boolean.FALSE,
                FONT_ANDALE_MONO, Font.BOLD, 11,
                224, 224, 224,
                255, 0, 0);

        // Scroll
        createScroll(txa_area_01,
                new PositionInFrame(220, 333),
                new DimensionInFrame(385, 90));

        // Se añaden las temperaturas a la lista de temperaturas
        this.gestor.agregarTemperatura(ITEM_TEMPERATURE_CELSIUS, new Celsius(ITEM_TEMPERATURE_CELSIUS, 0d));
        this.gestor.agregarTemperatura(ITEM_TEMPERATURE_KELVIN, new Kelvin(ITEM_TEMPERATURE_KELVIN, 273.15d));
        this.gestor.agregarTemperatura(ITEM_TEMPERATURE_FAHRENHEIT, new Fahrenheit(ITEM_TEMPERATURE_FAHRENHEIT, 32d));

        // Poblar ComboBox
        anhiadirTemperaturas(cbx_temperatura1, gestor);
        anhiadirTemperaturas(cbx_temperatura2, gestor);

        // Fin configuración de etiquetas, botones y otros componentes del Front ****************************
    }

    // Método que añade las temperaturas a sus respectivos combobox.
    public void anhiadirTemperaturas(JComboBox combobox, GestorTemperatura gestor) {

        combobox.addItem(ITEM_OPTION_SELECT);

        Set<String> keys = gestor.obtenerMapa().keySet();

        for (String key : keys) {

            Temperature value = gestor.obtenerMapa().get(key);
            combobox.addItem(value.getName());
        }
    }

    public double cambioTemperatura(Temperature temperature1, double valor, Temperature temperature2,
                                    char medida1, char medida2) {

        double resultado = 0;

        switch (medida1) {

            case SYMBOL_CELSIUS -> {

                switch (medida2) {

                    case SYMBOL_FAHRENHEIT ->
                            resultado = Math.round((((valor * 9) / 5) + temperature2.getvalorCelcius()) * 100d) / 100d;

                    case SYMBOL_KELVIN -> resultado = Math.round((temperature2.getvalorCelcius() + valor) * 100d) / 100d;
                }
            }
            case SYMBOL_FAHRENHEIT -> {

                switch (medida2) {

                    case SYMBOL_CELSIUS ->
                            resultado = Math.round((((valor - temperature1.getvalorCelcius()) * 5) / 9) * 100d) / 100d;

                    case SYMBOL_KELVIN -> resultado = Math.round((((valor + 459.67) * 5) / 9) * 100d) / 100d;
                }
            }
            case SYMBOL_KELVIN -> {

                switch (medida2) {

                    case SYMBOL_CELSIUS -> resultado = Math.round((valor - temperature1.getvalorCelcius()) * 100d) / 100d;

                    case SYMBOL_FAHRENHEIT -> resultado = Math.round((valor * 1.8 - 459.67) * 100d) / 100d;
                }
            }
            default ->
                    resultado = Math.round(((valor / temperature1.getvalorCelcius()) * temperature2.getvalorCelcius()) * 100d) / 100d;
        }

        return resultado;
    }

    public void establecerTexto(String nombreTrabajador, String apellidoPaterno, String apellidoMaterno,
                                String temperatura1, String temperatura2, char medida, double valor, double resultado) {

        txa_area_01.setText("\n El usuario " + nombreTrabajador + " " + apellidoPaterno + " " + apellidoMaterno
                + "\n cambió " + valor + " °" + temperatura1
                + "\n por " + temperatura2
                + "\n y recibe a cambio " + resultado + " °" + medida);
    }

    @Override
    public void createFramework(String titulo, Color colorBackground) {

        setLayout(null); // marco de trabajo
        setDefaultCloseOperation(EXIT_ON_CLOSE); // operación de cierre por defecto
        setTitle(titulo); // título
        getContentPane().setBackground(colorBackground); // fondo por defecto
    }

    @Override
    public void stablishIcon(String icono) {

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(icono))).getImage()); // ícono
    }

    /**
     * Establece el logo en una posición y dimensión específicas
     * @param logo              La ruta del logo
     * @param positionInFrame   La posición del logo en el marco, en los ejes X e Y
     * @param dimensionInFrame  La dimensión del logo en el marco, basado en ancho y largo
     */
    @Override
    public void stablishLogo(String logo, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame) {

        // Establece el logo como imagen
        ImageIcon imageIcon = new ImageIcon(logo);

        // Establece etiqueta que contiene el logo
        JLabel jLabel = new JLabel(imageIcon);

        // Establece la posición y la dimensión de la etiqueta
        jLabel.setBounds(new Rectangle(positionInFrame.getX(), positionInFrame.getY(),
                dimensionInFrame.getWidth(), dimensionInFrame.getHeight()));

        // Añade la etiqueta dentro del marco
        add(jLabel);
    }

    /**
     * Establece una etiqueta con su respectiva posición, dimensión, color de fondo, tipo de letra y nombre
     * @param nombre            Nombre de la etiqueta
     * @param positionInFrame   La posición de la etiqueta en el marco, en los ejes X e Y
     * @param dimensionInFrame  La dimensión de la etiqueta en el marco, basado en ancho y largo
     * @param colorBackground   Color de fondo de la etiqueta
     * @param fontType          Tipo de letra o fuente, de la etiqueta
     */
    @Override
    public void stablishLabel(String nombre, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame, Color colorBackground, FontType fontType) {

        // Establece la etiqueta con un nombre específico
        JLabel jLabel = new JLabel(nombre);

        // Establece la posición y la dimensión de la etiqueta
        jLabel.setBounds(new Rectangle(positionInFrame.getX(), positionInFrame.getY(),
                dimensionInFrame.getWidth(), dimensionInFrame.getHeight()));

        // Establece el tipo de letra de la etiqueta
        jLabel.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de fondo de esta etiqueta
        jLabel.setForeground(colorBackground);

        // Añade la etiqueta al marco
        add(jLabel);
    }

    @Override
    public JMenuBar creaBarraDeMenu(int red, int green, int blue) {

        JMenuBar menuBar = new JMenuBar(); // establece barra de menu
        menuBar.setBackground(new Color(red, green, blue)); // color de fondo de la barra
        setJMenuBar(menuBar); // habilita la barra

        return menuBar;
    }

    @Override
    public JMenu creaMenu(String nombre, int red, int green, int blue,
                          String font, int style, int size,
                          int red2, int green2, int blue2) {

        JMenu menu = new JMenu(nombre); // crea menu de opciones
        menu.setBackground(new Color(red, green, blue)); // color de fondo por defecto
        menu.setFont(new Font(font, style, size)); // fuente
        menu.setForeground(new Color(red2, green2, blue2)); // color fuente

        return menu;
    }

    @Override
    public JMenuItem creaMenuItem(String nombre, String font, int style, int size,
                                  int red, int green, int blue) {

        JMenuItem menuItem = new JMenuItem(nombre); // submenu
        menuItem.setFont(new Font(font, style, size)); // fuente
        menuItem.setForeground(new Color(red, green, blue)); // color fuente
        menuItem.addActionListener(this);

        return menuItem;
    }

    @Override
    public JComboBox creaComboBox(int x, int y, int width, int height, int red, int green, int blue, int red2, int green2, int blue2, String font, int style, int size) {

        JComboBox jComboBox = new JComboBox(); // campo desplegable
        jComboBox.setBounds(x, y, width, height); // dimensiones
        jComboBox.setBackground(new Color(red, green, blue)); // color fondo
        jComboBox.setFont(new Font(font, style, size)); // fuente
        jComboBox.setForeground(new Color(red2, green2, blue2)); // color fuente
        add(jComboBox); // añade campo desplegable

        return jComboBox;
    }

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
    @Override
    public JTextField createTextField(PositionInFrame positionInFrame,
                                      DimensionInFrame dimensionInFrame,
                                      FontType fontType,
                                      Color colorBackground,
                                      Color colorFont) {

        // Crea el elemento campo de texto
        JTextField jTextField = new JTextField();

        // Establece la posición y dimensión específicas del campo de texto dentro del marco
        jTextField.setBounds(new Rectangle(positionInFrame.getX(), positionInFrame.getY(),
                dimensionInFrame.getWidth(), dimensionInFrame.getHeight()));

        // Establece el tipo de letra o fuente del campo de texto
        jTextField.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de fondo del campo de texto
        jTextField.setBackground(colorBackground);

        // Establece el color de la letra del campo de texto
        jTextField.setForeground(colorFont);

        // Añade el campo de texto al marco principal
        add(jTextField);

        // Retorna el campo de texto
        return jTextField;
    }

    @Override
    public JButton creaBoton(String nombre, int x, int y, int width, int height, String font, int style, int size, int red, int green, int blue, int red2, int green2, int blue2, boolean valor) {

        JButton jButton = new JButton(nombre);
        jButton.setBounds(x, y, width, height); // dimensiones
        jButton.setFont(new Font(font, style, size));
        jButton.setForeground(new Color(red, green, size));
        jButton.addActionListener(this);
        add(jButton);

        return jButton;
    }

    @Override
    public JTextArea creaAreaDeTexto(String texto, boolean valor,
                                     String font, int style, int size,
                                     int red, int green, int blue,
                                     int red2, int green2, int blue2) {

        JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(valor);
        jTextArea.setBackground(new Color(red, green, blue));
        jTextArea.setFont(new Font(font, style, size));
        jTextArea.setForeground(new Color(red2, green2, blue2));
        jTextArea.setText(texto);

        return jTextArea;
    }

    /**
     * Crea un elemento Scroll dentro un área de texto específico de acuerdo a una posición y dimensión
     * específicas.
     * @param area             El área de texto dentro del marco
     * @param positionInFrame  Posición específica dentro del área de texto
     * @param dimensionInFrame Dimensión específica dentro del área de texto
     */
    @Override
    public void createScroll(JTextArea area, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame) {

        // Crea el elemento Scroll dentro del ámbito del área de texto
        JScrollPane jScrollPane = new JScrollPane(area);

        // Establece la posición y dimensión específicas del elemento Scroll dentro del área
        jScrollPane.setBounds(new Rectangle(positionInFrame.getX(), positionInFrame.getY(),
                dimensionInFrame.getWidth(), dimensionInFrame.getHeight()));

        // Añade el elemento al marco principal
        add(jScrollPane);
    }

    @Override
    public JCheckBox creaCheckbox(String msg, int x, int y, int width, int height) {
        return null;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_calcular) {

            double valor = 0;
            double resultado = 0;
            boolean fail = Boolean.FALSE;
            boolean esMenorCeroAbsoluto = Boolean.FALSE;

            Fahrenheit fahrenheit = (Fahrenheit) gestor.obtenerTemperatura(ITEM_TEMPERATURE_FAHRENHEIT);
            Kelvin kelvin = (Kelvin) gestor.obtenerTemperatura(ITEM_TEMPERATURE_KELVIN);
            Celsius celsius = (Celsius) gestor.obtenerTemperatura(ITEM_TEMPERATURE_CELSIUS);

            String nombreUsuario = this.txf_nombre.getText();
            String apellidoPaternoUsuario = this.txf_apellidoPaterno.getText();
            String apellidoMaternoUsuario = this.txf_apellidoMaterno.getText();

            String temp1 = "";
            String temp2 = "";
            char medida1;
            char medida2 = 'a';

            try {

                if (txf_valor != null) {

                    valor = Double.parseDouble(txf_valor.getText());
                }
            } catch (NumberFormatException err) {

                fail = Boolean.TRUE;
            }

            if (fail) {

                JOptionPane.showMessageDialog(null, MSG_INVALID_VALUE_EMPTY_OR_SPECIAL_CHAR,
                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
            } else {

                if (Objects.equals(cbx_temperatura1.getSelectedItem(), ITEM_OPTION_SELECT) ||
                        Objects.equals(cbx_temperatura2.getSelectedItem(), ITEM_OPTION_SELECT)) {

                    JOptionPane.showMessageDialog(null, MSG_INVALID_EQUAL_TEMPERATURE_PAIR,
                            MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                } else {

                    switch (Objects.requireNonNull(cbx_temperatura1.getSelectedItem()).toString()) {

                        case ITEM_TEMPERATURE_CELSIUS -> {

                            temp1 = celsius.getName();
                            medida1 = celsius.getMedidas();
                            esMenorCeroAbsoluto = esMenorACeroAbsoluto(valor, ITEM_TEMPERATURE_CELSIUS);

                            if (esMenorCeroAbsoluto) {

                                JOptionPane.showMessageDialog(null, MSG_ABS_ZERO_INPUT,
                                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                            } else {

                                switch (Objects.requireNonNull(cbx_temperatura2.getSelectedItem()).toString()) {

                                    case ITEM_TEMPERATURE_FAHRENHEIT -> {

                                        temp2 = fahrenheit.getName();
                                        medida2 = fahrenheit.getMedida();

                                        resultado = this.cambioTemperatura(celsius,
                                                valor, fahrenheit, medida1, medida2);

                                    }
                                    case ITEM_TEMPERATURE_KELVIN -> {

                                        temp2 = kelvin.getName();
                                        medida2 = kelvin.getMedida();

                                        resultado = this.cambioTemperatura(celsius,
                                                valor, kelvin, medida1, medida2);
                                    }
                                    default -> fail = Boolean.TRUE;
                                }
                            }

                        }
                        case ITEM_TEMPERATURE_FAHRENHEIT -> {

                            temp1 = fahrenheit.getName();
                            medida1 = fahrenheit.getMedida();
                            esMenorCeroAbsoluto = esMenorACeroAbsoluto(valor, ITEM_TEMPERATURE_FAHRENHEIT);

                            if (esMenorCeroAbsoluto) {

                                JOptionPane.showMessageDialog(null, MSG_ABS_ZERO_INPUT,
                                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                            } else {

                                switch (Objects.requireNonNull(cbx_temperatura2.getSelectedItem()).toString()) {

                                    case ITEM_TEMPERATURE_CELSIUS -> {

                                        temp2 = celsius.getName();
                                        medida2 = celsius.getMedidas();

                                        resultado = this.cambioTemperatura(fahrenheit,
                                                valor, celsius, medida1, medida2);
                                    }
                                    case ITEM_TEMPERATURE_KELVIN -> {

                                        temp2 = kelvin.getName();
                                        medida2 = kelvin.getMedida();

                                        resultado = this.cambioTemperatura(fahrenheit,
                                                valor, kelvin, medida1, medida2);
                                    }
                                    default -> fail = Boolean.TRUE;
                                }
                            }
                        }
                        case ITEM_TEMPERATURE_KELVIN -> {

                            temp1 = kelvin.getName();
                            medida1 = kelvin.getMedida();
                            esMenorCeroAbsoluto = esMenorACeroAbsoluto(valor, ITEM_TEMPERATURE_KELVIN);

                            if (esMenorCeroAbsoluto) {

                                JOptionPane.showMessageDialog(null, MSG_ABS_ZERO_INPUT,
                                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                            } else {

                                switch (Objects.requireNonNull(cbx_temperatura2.getSelectedItem()).toString()) {

                                    case ITEM_TEMPERATURE_FAHRENHEIT -> {

                                        temp2 = fahrenheit.getName();
                                        medida2 = fahrenheit.getMedida();

                                        resultado = this.cambioTemperatura(kelvin,
                                                valor, fahrenheit, medida1, medida2);
                                    }
                                    case ITEM_TEMPERATURE_CELSIUS -> {

                                        temp2 = celsius.getName();
                                        medida2 = celsius.getMedidas();

                                        resultado = this.cambioTemperatura(kelvin,
                                                valor, celsius, medida1, medida2);
                                    }
                                    default -> fail = Boolean.TRUE;
                                }
                            }
                        }
                    }

                    if(esMenorCeroAbsoluto){

                        JOptionPane.showMessageDialog(null, "Favor vuelva a intentarlo");
                    } else {

                        if (fail) {
                            JOptionPane.showMessageDialog(null, MSG_INVALID_EQUAL_TEMPERATURE_PAIR,
                                    MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                        } else {
                            establecerTexto(nombreUsuario, apellidoPaternoUsuario, apellidoMaternoUsuario, temp1, temp2,
                                    medida2, valor, resultado);
                        }
                    }
                }
            }
        }


        if (e.getSource() == menuItemConversorDivisa) {
            ConversorDivisas ventanaConversorDivisa = new ConversorDivisas(); // instancia principal
            ventanaConversorDivisa.setBounds(0, 0, 640, 535); // dimensiones
            ventanaConversorDivisa.setVisible(true); // principal visible
            ventanaConversorDivisa.setResizable(false); // ventana redimensionable
            ventanaConversorDivisa.setLocationRelativeTo(null); // posición relativa
            this.setVisible(false); // esconde la pantalla de licencia
        }

        if (e.getSource() == menuItemAutor) {

            JOptionPane.showMessageDialog(null, MSG_INFO_APP + "\n"
                    + MSG_EMAIL + "\n"
                    + MSG_INFO_EDUCATION);
        }

        if (e.getSource() == menuItemColorMorado) {

            getContentPane().setBackground(new Color(51, 0, 51));
        }

        if (e.getSource() == menuItemColorNegro) {

            getContentPane().setBackground(new Color(0, 0, 0));
        }

        if (e.getSource() == menuItemColorRojo) {

            getContentPane().setBackground(new Color(255, 0, 0));
        }

        if (e.getSource() == menuItemNuevo) {

            Bienvenida ventanaBienvenida = new Bienvenida();
            ventanaBienvenida.setBounds(0, 0, 350, 450);
            ventanaBienvenida.setVisible(true);
            ventanaBienvenida.setLocationRelativeTo(null);
            ventanaBienvenida.setResizable(false);
            this.setVisible(false);

        }

        if (e.getSource() == menuItemSalir) {

            System.exit(0);
        }

        if (e.getSource() == menuItemReset) {

            txf_nombre.setText("");
            txf_apellidoPaterno.setText("");
            txf_apellidoMaterno.setText("");
            cbx_temperatura2.setSelectedIndex(0);
            cbx_temperatura1.setSelectedIndex(0);
            assert txf_valor != null;
            txf_valor.setText("");
            txa_area_01.setText(TEXT_FIELD_TEMPERATURE_RESULT);
        }
    }

    public boolean esMenorACeroAbsoluto(double valor, String medida) {

        boolean esMenor;

        esMenor = switch (medida) {
            case ITEM_TEMPERATURE_CELSIUS -> (-273.15d > valor) ? Boolean.TRUE : Boolean.FALSE;
            case ITEM_TEMPERATURE_FAHRENHEIT -> (-459.67d > valor) ? Boolean.TRUE : Boolean.FALSE;
            case ITEM_TEMPERATURE_KELVIN -> (0 > valor) ? Boolean.TRUE : Boolean.FALSE;
            default -> Boolean.FALSE;
        };

        return esMenor;
    }

    public static void main(String[] args) {

        ConversorTemperatura ventanaConversorTemperatura = new ConversorTemperatura();
        ventanaConversorTemperatura.setBounds(0, 0, 640, 535);
        ventanaConversorTemperatura.setVisible(true);
        ventanaConversorTemperatura.setResizable(false);
        ventanaConversorTemperatura.setLocationRelativeTo(null);
    }
}