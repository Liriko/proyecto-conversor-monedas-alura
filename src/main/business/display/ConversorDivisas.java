package src.main.business.display; // declara el paquete donde estarán ubicadas nuestras pantallas de usuario

import src.main.interfaces.UserInterface; // importa mi interfaz Front para implementarla en esta clase
import src.main.model.currency.*;
import src.main.business.logic.GestorDivisa; // importa gestor de divisas para el cambio de moneda
import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase

import javax.swing.*; // importa librería gráfica para configurar la pantalla
import java.awt.event.*; // importa librería para implementer interfaz ActionListener
import java.awt.*; // importa librería para manipular eventos
import java.util.Objects; // importa librería util.Objects para usar requireNonNull
import java.util.Set;

/*
    Autor: Jorge Daniel Salgado Pons
	Fecha: 25-02-2023

	Propósito: Esta es la pantalla del conversor de divisas, donde el usuario
	podrá cambiar divisas.
	Esta pantalla, además, cuenta con una barra de menú con varias opciones
	entre las cuales destacan funcionalidades para cambiar el color de la app,
	para cambiar entre distintos conversores e incluso para saber más sobre
	el autor de esta app.

	Nuestra clase ConversorDivisas es una clase hija de la clase JFrame e implementa
	la interfaz ActionListener de la librería awt.event.* y también
	implementa una interfaz propia llamada Front que diseñé para mejorar
	las implementaciones de interfaz gráfica.
 */
public class ConversorDivisas extends JFrame implements ActionListener, UserInterface {

    private final JMenuItem menuItemConversorTemperatura;
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
    private final JComboBox cbx_divisa1;
    private final JComboBox cbx_divisa2;

    // Botón

    private final JButton btn_calcular;

    // Área de texto
    private final JTextArea txa_area_01;

    String nombre;
    GestorDivisa gestor = new GestorDivisa();

    public ConversorDivisas() {

        createFrame(SUB_MENU_CURRENCY_CONVERTER, new Color(147, 82, 210));
        setIcon(ICONO);

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
        JMenuItem menuItemConversorDivisa = creaMenuItem(SUB_MENU_CURRENCY_CONVERTER,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 0);
        menuItemConversorTemperatura = creaMenuItem(SUB_MENU_TEMPERATURE_CONVERTER,
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
        setLogo(LOGO, new PositionInFrame(5, 5), new DimensionInFrame(250, 140));

        // Etiquetas
        setLabel(LABEL_VALUE + ":",
                new PositionInFrame(480, 188),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        setLabel(LABEL_TITLE + nombre,
                new PositionInFrame(280, 30),
                new DimensionInFrame(300, 50),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 32));

        setLabel(LABEL_SUBTITLE,
                new PositionInFrame(45, 140),
                new DimensionInFrame(900, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 24));

        setLabel(LABEL_NAME,
                new PositionInFrame(25, 188),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        setLabel(LABEL_LASTNAME + ":",
                new PositionInFrame(25, 248),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO,12));

        setLabel(LABEL_SURNAME + ":",
                new PositionInFrame(25, 308),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        setLabel(LABEL_TO_CHANGE_FROM + ":",
                new PositionInFrame(220, 188),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        setLabel(LABEL_A + ":",
                new PositionInFrame(220, 248),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        setLabel(TEXT_FIELD_CALCULATION_RESULT + ":",
                new PositionInFrame(220, 307),
                new DimensionInFrame(180, 25),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        setLabel(LABEL_FOOTER,
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
        btn_calcular = createButton(BUTTON_CALCULATE,
                new PositionInFrame(480, 258),
                new DimensionInFrame(125, 45),
                new FontType(FONT_ANDALE_MONO, 20),
                new Color(255, 0, 0),
                new Color(0, 0, 0),
                Boolean.FALSE);

        // ComboBox
        cbx_divisa1 = creaComboBox(220, 213, 220, 25,
                224, 224, 224,
                255, 0, 0,
                FONT_ANDALE_MONO, Font.BOLD, 14);
        cbx_divisa2 = creaComboBox(220, 273, 220, 25,
                224, 224, 224,
                255, 0, 0,
                FONT_ANDALE_MONO, Font.BOLD, 14);

        // Area de texto
        txa_area_01 = createTextArea(TEXT_FIELD_CURRENCY_RESULT, Boolean.FALSE,
                new FontType(FONT_ANDALE_MONO, 11),
                new Color(255, 0, 0),
                new Color(224, 224, 224));

        // Scroll
        createScrollPane(txa_area_01,
                new PositionInFrame(220, 333),
                new DimensionInFrame(385, 90));

        // Se añaden las divisas a la lista de divisas
        this.gestor.agregarDivisa(ITEM_CURRENCY_USD, new Dollar(ITEM_CURRENCY_USD, 1.00d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_EUR, new Euro(ITEM_CURRENCY_EUR, 0.94d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_GBP, new PoundSterling(ITEM_CURRENCY_GBP, 0.84d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_CLP, new ChileanPeso(ITEM_CURRENCY_CLP, 802.50d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_KRW, new SouthKoreanWon(ITEM_CURRENCY_KRW, 1306.03d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_JPY, new JapaneseYen(ITEM_CURRENCY_JPY, 136.53d));

        // Poblar ComboBox
        anhiadirMonedas(cbx_divisa1, gestor);
        anhiadirMonedas(cbx_divisa2, gestor);

        // Fin configuración de etiquetas, botones y otros componentes del Front ****************************
    }

    // Método que añade las divisas a sus respectivos combobox.
    public void anhiadirMonedas(JComboBox combobox, GestorDivisa gestor) {

        combobox.addItem(ITEM_OPTION_SELECT);

        Set<String> keys = gestor.obtenerMapa().keySet();

        for (String key : keys) {

            Currency value = gestor.obtenerMapa().get(key);
            combobox.addItem(value.getName());
        }
    }

    public double cambioDivisa(Currency temperatura1, double valor, Currency temperatura2, char ccy) {

        double resultado;

        if (ccy == SYMBOL_USD) resultado = temperatura2.getValueInUSD() * valor;
        else resultado = Math.round(((valor / temperatura1.getValueInUSD()) * temperatura2.getValueInUSD()) * 100d) / 100d;

        return resultado;
    }

    public void establecerTexto(String nombreTrabajador, String apellidoPaterno, String apellidoMaterno,
                                String divisa1, String divisa2, char ccy, double valor, double resultado) {

        txa_area_01.setText("\n El usuario " + nombreTrabajador + " " + apellidoPaterno + " " + apellidoMaterno
                + "\n cambió " + valor + " " + divisa1
                + "\n por " + divisa2
                + "\n y recibe a cambio " + ccy + "" + resultado);
    }

    @Override
    public void createFrame(String titulo, Color colorBackground) {

        setLayout(null); // marco de trabajo
        setDefaultCloseOperation(EXIT_ON_CLOSE); // operación de cierre por defecto
        setTitle(titulo); // título
        getContentPane().setBackground(colorBackground); // fondo por defecto
    }

    @Override
    public void setIcon(String imagePath) {

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath))).getImage()); // ícono
    }

    /**
     * Establece el logo dentro del marco específicado
     * @param logoPath              La ruta del logo
     * @param position   La posición del logo en el marco, en los ejes X e Y
     * @param dimension  La dimensión del logo en el marco, basado en ancho y largo
     */
    @Override
    public void setLogo(String logoPath, PositionInFrame position, DimensionInFrame dimension) {

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
     * @param name            Nombre de la etiqueta
     * @param position   La posición de la etiqueta en el marco, en los ejes X e Y
     * @param dimension  La dimensión de la etiqueta en el marco, basado en ancho y largo
     * @param backgroundColor   Color de fondo de la etiqueta
     * @param fontType          Tipo de letra o fuente, de la etiqueta
     */
    @Override
    public void setLabel(String name, PositionInFrame position, DimensionInFrame dimension, Color backgroundColor, FontType fontType) {

        // Establece la etiqueta con un nombre específico
        JLabel jLabel = new JLabel(name);

        // Establece la posición y la dimensión de la etiqueta
        jLabel.setBounds(position.getX(), position.getY(), dimension.getWidth(),
                dimension.getHeight());

        // Establece el tipo de letra de la etiqueta
        jLabel.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de fondo de esta etiqueta
        jLabel.setForeground(backgroundColor);

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
     * @param position   Posición del campo de texto en el marco
     * @param dimension  Dimensión del campo de texto en el marco
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
        textField.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

        // Establece el tipo de letra o fuente del campo de texto
        textField.setFont(new Font(fontType.getFontName(), Font.BOLD, fontType.getFontSize()));

        // Establece el color de fondo del campo de texto
        textField.setBackground(backgroundColor);

        // Establece el color de la letra del campo de texto
        textField.setForeground(fontColor);

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
     * @param text Texto que mostrará el área de texto
     * @param isEnabled Estado del área de texto
     * @param fontType Tipo de letra del texto del área de texto
     * @param textColor Color de la letra del texto del área de texto
     * @param backgroundColor Color de fondo del área de texto
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
     * @param textArea             El área de texto dentro del marco
     * @param position  Posición específica dentro del área de texto
     * @param dimension Dimensión específica dentro del área de texto
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
     * @param msg Mensaje que mostrará el checkbox.
     * @param position Posición del checkbox en coordenadas X y Y
     * @param dimension Dimensión del checkbox según base y altura
     * @return el checkbox
     */
    @Override
    public JCheckBox createCheckBox(String msg, PositionInFrame position,
                                    DimensionInFrame dimension) {
        return null;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_calcular) {

            double valor = 0;
            double resultado = 0;
            boolean fail = Boolean.FALSE;

            Dollar dollar = (Dollar) gestor.obtenerDivisa(ITEM_CURRENCY_USD);
            Euro euro = (Euro) gestor.obtenerDivisa(ITEM_CURRENCY_EUR);
            PoundSterling libra = (PoundSterling) gestor.obtenerDivisa(ITEM_CURRENCY_GBP);
            ChileanPeso peso = (ChileanPeso) gestor.obtenerDivisa(ITEM_CURRENCY_CLP);
            SouthKoreanWon won = (SouthKoreanWon) gestor.obtenerDivisa(ITEM_CURRENCY_KRW);
            JapaneseYen yen = (JapaneseYen) gestor.obtenerDivisa(ITEM_CURRENCY_JPY);

            String nombreUsuario = this.txf_nombre.getText();
            String apellidoPaternoUsuario = this.txf_apellidoPaterno.getText();
            String apellidoMaternoUsuario = this.txf_apellidoMaterno.getText();

            String div1 = "";
            String div2 = "";
            char ccy1;
            char ccy2 = 'a';

            try {

                if (txf_valor != null){

                    valor = Double.parseDouble(txf_valor.getText());
                }
            } catch (NumberFormatException err) {

                fail = Boolean.TRUE;
            }

            if (fail) {

                JOptionPane.showMessageDialog(null, MSG_INVALID_VALUE_EMPTY_OR_SPECIAL_CHAR,
                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
            } else {

                if (valor < 0) {

                    JOptionPane.showMessageDialog(null, MSG_INVALID_VALUE_LOWER_THAN_ZERO,
                            MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                } else {

                    if (Objects.equals(cbx_divisa1.getSelectedItem(), ITEM_OPTION_SELECT) ||
                            Objects.equals(cbx_divisa2.getSelectedItem(), ITEM_OPTION_SELECT)) {

                        JOptionPane.showMessageDialog(null, MSG_INVALID_CURRENCY_PAIR,
                                MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                    } else {

                        switch (Objects.requireNonNull(cbx_divisa1.getSelectedItem()).toString()) {

                            case ITEM_CURRENCY_USD -> {

                                div1 = dollar.getName();
                                ccy1 = dollar.getCurrencySymbol();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getName();
                                        ccy2 = euro.getCurrencySymbol();

                                        resultado = this.cambioDivisa(dollar,
                                                valor, euro, ccy1);

                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getName();
                                        ccy2 = libra.getCurrencySymbol();

                                        resultado = this.cambioDivisa(dollar,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getName();
                                        ccy2 = peso.getCurrencySymbol();

                                        resultado = this.cambioDivisa(dollar,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getName();
                                        ccy2 = won.getCurrencySymbol();

                                        resultado = this.cambioDivisa(dollar,
                                                valor, won, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getName();
                                        ccy2 = yen.getCurrencySymbol();

                                        resultado = this.cambioDivisa(dollar,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_EUR -> {

                                div1 = euro.getName();
                                ccy1 = euro.getCurrencySymbol();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dollar.getName();
                                        ccy2 = dollar.getCurrencySymbol();

                                        resultado = this.cambioDivisa(euro,
                                                valor, dollar, ccy1);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getName();
                                        ccy2 = libra.getCurrencySymbol();

                                        resultado = this.cambioDivisa(euro,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getName();
                                        ccy2 = peso.getCurrencySymbol();

                                        resultado = this.cambioDivisa(euro,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getName();
                                        ccy2 = won.getCurrencySymbol();

                                        resultado = this.cambioDivisa(euro,
                                                valor, won, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getName();
                                        ccy2 = yen.getCurrencySymbol();

                                        resultado = this.cambioDivisa(euro,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_GBP -> {

                                div1 = libra.getName();
                                ccy1 = libra.getCurrencySymbol();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dollar.getName();
                                        ccy2 = dollar.getCurrencySymbol();

                                        resultado = this.cambioDivisa(libra,
                                                valor, dollar, ccy1);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getName();
                                        ccy2 = euro.getCurrencySymbol();

                                        resultado = this.cambioDivisa(libra,
                                                valor, euro, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getName();
                                        ccy2 = peso.getCurrencySymbol();

                                        resultado = this.cambioDivisa(libra,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getName();
                                        ccy2 = won.getCurrencySymbol();

                                        resultado = this.cambioDivisa(libra,
                                                valor, won, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getName();
                                        ccy2 = yen.getCurrencySymbol();

                                        resultado = this.cambioDivisa(libra,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_CLP -> {

                                div1 = peso.getName();
                                ccy1 = libra.getCurrencySymbol(); // Esto no es un error, es un control de daños.

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dollar.getName();
                                        ccy2 = dollar.getCurrencySymbol();

                                        resultado = this.cambioDivisa(peso,
                                                valor, dollar, ccy1);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getName();
                                        ccy2 = euro.getCurrencySymbol();

                                        resultado = this.cambioDivisa(peso,
                                                valor, euro, ccy1);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getName();
                                        ccy2 = libra.getCurrencySymbol();

                                        resultado = this.cambioDivisa(peso,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getName();
                                        ccy2 = won.getCurrencySymbol();

                                        resultado = this.cambioDivisa(peso,
                                                valor, won, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getName();
                                        ccy2 = yen.getCurrencySymbol();

                                        resultado = this.cambioDivisa(peso,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_KRW -> {

                                div1 = won.getName();
                                ccy1 = won.getCurrencySymbol();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dollar.getName();
                                        ccy2 = dollar.getCurrencySymbol();

                                        resultado = this.cambioDivisa(won,
                                                valor, dollar, ccy1);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getName();
                                        ccy2 = euro.getCurrencySymbol();

                                        resultado = this.cambioDivisa(won,
                                                valor, euro, ccy1);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getName();
                                        ccy2 = libra.getCurrencySymbol();

                                        resultado = this.cambioDivisa(won,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getName();
                                        ccy2 = peso.getCurrencySymbol();

                                        resultado = this.cambioDivisa(won,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getName();
                                        ccy2 = yen.getCurrencySymbol();

                                        resultado = this.cambioDivisa(won,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_JPY -> {

                                div1 = yen.getName();
                                ccy1 = yen.getCurrencySymbol();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dollar.getName();
                                        ccy2 = dollar.getCurrencySymbol();

                                        resultado = this.cambioDivisa(yen,
                                                valor, dollar, ccy1);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getName();
                                        ccy2 = euro.getCurrencySymbol();

                                        resultado = this.cambioDivisa(yen,
                                                valor, euro, ccy1);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getName();
                                        ccy2 = libra.getCurrencySymbol();

                                        resultado = this.cambioDivisa(yen,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getName();
                                        ccy2 = peso.getCurrencySymbol();

                                        resultado = this.cambioDivisa(yen,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getName();
                                        ccy2 = won.getCurrencySymbol();

                                        resultado = this.cambioDivisa(yen,
                                                valor, won, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                        }

                        if (fail){
                            JOptionPane.showMessageDialog(null, MSG_INVALID_EQUAL_CURRENCY_PAIR,
                                    MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                        } else {
                            establecerTexto(nombreUsuario, apellidoPaternoUsuario, apellidoMaternoUsuario, div1, div2,
                                    ccy2, valor, resultado);
                        }
                    }
                }
            }
        }

        if (e.getSource() == menuItemConversorTemperatura) {
            ConversorTemperatura ventanaConversorTemperatura = new ConversorTemperatura(); // instancia principal
            ventanaConversorTemperatura.setBounds(0, 0, 640, 535); // dimensiones
            ventanaConversorTemperatura.setVisible(true); // principal visible
            ventanaConversorTemperatura.setResizable(false); // ventana redimensionable
            ventanaConversorTemperatura.setLocationRelativeTo(null); // posición relativa
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

            assert txf_nombre != null;
            txf_nombre.setText("");
            assert txf_apellidoPaterno != null;
            txf_apellidoPaterno.setText("");
            assert txf_apellidoMaterno != null;
            txf_apellidoMaterno.setText("");
            cbx_divisa2.setSelectedIndex(0);
            cbx_divisa1.setSelectedIndex(0);
            assert txf_valor != null;
            txf_valor.setText("");
            txa_area_01.setText(TEXT_FIELD_CURRENCY_RESULT);
        }
    }


    public static void main(String[] args) {

        ConversorDivisas ventanaConversorDivisas = new ConversorDivisas();
        ventanaConversorDivisas.setBounds(0, 0, 640, 535);
        ventanaConversorDivisas.setVisible(true);
        ventanaConversorDivisas.setResizable(false);
        ventanaConversorDivisas.setLocationRelativeTo(null);
    }
}