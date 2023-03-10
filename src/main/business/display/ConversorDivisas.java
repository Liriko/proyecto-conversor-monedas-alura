package src.main.business.display; // declara el paquete donde estarán ubicadas nuestras pantallas de usuario

import src.main.interfaces.UserInterface; // importa mi interfaz Front para implementarla en esta clase
import src.main.model.currency.*;
import src.main.business.logic.GestorDivisa; // importa gestor de divisas para el cambio de moneda
import src.main.utils.DimensionInFrame;
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

        createFramework(SUB_MENU_CURRENCY_CONVERTER, new Color(147, 82, 210));
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
        stablishLogo(LOGO, new PositionInFrame(5, 5), new DimensionInFrame(250, 140));

        // Etiquetas
        estableceEtiqueta(LABEL_VALUE + ":",
                480, 188, 180, 25,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 12);
        estableceEtiqueta(LABEL_TITLE + nombre,
                280, 30, 300, 50,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 32);
        estableceEtiqueta(LABEL_SUBTITLE,
                45, 140, 900, 25,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 24);
        estableceEtiqueta(LABEL_NAME,
                25, 188, 180, 25,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 12);
        estableceEtiqueta(LABEL_LASTNAME + ":",
                25, 248, 180, 25,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 12);
        estableceEtiqueta(LABEL_SURNAME + ":",
                25, 308, 180, 25,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 12);
        estableceEtiqueta(LABEL_TO_CHANGE_FROM + ":",
                220, 188, 180, 25,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 12);
        estableceEtiqueta(LABEL_A + ":",
                220, 248, 180, 25,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 12);
        estableceEtiqueta(TEXT_FIELD_CALCULATION_RESULT + ":",
                220, 307, 180, 25,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 12);
        estableceEtiqueta(LABEL_FOOTER, 195, 445, 500, 30,
                255, 255, 255,
                FONT_ANDALE_MONO, Font.BOLD, 12);

        // Campos de texto
        txf_nombre = creaCampoDeTexto(25, 213, 150, 25,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                224, 224, 224,
                255, 0, 0);
        txf_valor = creaCampoDeTexto(480, 213, 125, 25,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                224, 224, 224,
                255, 0, 0);
        txf_apellidoPaterno = creaCampoDeTexto(25, 273, 150, 25,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                224, 224, 224,
                255, 0, 0);
        txf_apellidoMaterno = creaCampoDeTexto(25, 334, 150, 25,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                224, 224, 224,
                255, 0, 0);

        // Botones
        btn_calcular = creaBoton(BUTTON_CALCULATE,
                480, 258, 125, 45,
                FONT_ANDALE_MONO, Font.BOLD, 20,
                255, 0, 0,
                0, 0, 0, false);

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
        txa_area_01 = creaAreaDeTexto(TEXT_FIELD_CURRENCY_RESULT, Boolean.FALSE,
                FONT_ANDALE_MONO, Font.BOLD, 11,
                224, 224, 224,
                255, 0, 0);

        // Scroll
        estableceScroll(txa_area_01, 220, 333, 385, 90);

        // Se añaden las divisas a la lista de divisas
        this.gestor.agregarDivisa(ITEM_CURRENCY_USD, new Dolar(ITEM_CURRENCY_USD, 1.00d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_EUR, new Euro(ITEM_CURRENCY_EUR, 0.94d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_GBP, new LibraEsterlina(ITEM_CURRENCY_GBP, 0.84d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_CLP, new PesoChileno(ITEM_CURRENCY_CLP, 802.50d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_KRW, new WonSurcoreano(ITEM_CURRENCY_KRW, 1306.03d));
        this.gestor.agregarDivisa(ITEM_CURRENCY_JPY, new YenJapones(ITEM_CURRENCY_JPY, 136.53d));

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

            Divisa value = gestor.obtenerMapa().get(key);
            combobox.addItem(value.getNombre());
        }
    }

    public double cambioDivisa(Divisa temperatura1, double valor, Divisa temperatura2, char ccy) {

        double resultado;

        if (ccy == SYMBOL_USD) resultado = temperatura2.getValorUSD() * valor;
        else resultado = Math.round(((valor / temperatura1.getValorUSD()) * temperatura2.getValorUSD()) * 100d) / 100d;

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
     * Establece el logo dentro del marco específicado
     * @param logo
     * @param positionInFrame
     * @param dimensionInFrame
     */
    @Override
    public void stablishLogo(String logo, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame) {

        // Establece el logo como imagen
        ImageIcon imagen = new ImageIcon(logo);

        // Establece etiqueta que contiene el logo
        JLabel lbl_logo = new JLabel(imagen);

        // Establece la posición y la dimensión de la etiqueta
        lbl_logo.setBounds(positionInFrame.getX(), positionInFrame.getY(),
                dimensionInFrame.getWidth(), dimensionInFrame.getHeight());

        // Añade la etiqueta dentro del marco
        add(lbl_logo);
    }

    @Override
    public void estableceEtiqueta(String nombre, int x, int y, int width, int height, int red, int green, int blue, String font, int style, int size) {

        JLabel jLabel = new JLabel(nombre); // título
        jLabel.setBounds(x, y, width, height); // dimensinoes
        jLabel.setFont(new Font(font, style, size)); // fuente
        jLabel.setForeground(new Color(red, green, blue)); // letra fuente
        add(jLabel); // añade título
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

    @Override
    public JTextField creaCampoDeTexto(int x, int y, int width, int height, String font, int style, int size, int red, int green, int blue, int red2, int green2, int blue2) {

        JTextField jTextField = new JTextField(); // campo de texto
        jTextField.setBounds(x, y, width, height); // dimensiones
        jTextField.setBackground(new Color(red, green, blue)); // color fondo
        jTextField.setFont(new Font(font, style, size)); // fuente
        jTextField.setForeground(new Color(red2, green2, blue2)); // color fuente
        add(jTextField); // añade campo de texto

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

    @Override
    public void estableceScroll(JTextArea area, int x, int y, int width, int height) {

        JScrollPane jScrollPane = new JScrollPane(area);
        jScrollPane.setBounds(x, y, width, height);
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

            Dolar dolar = (Dolar) gestor.obtenerDivisa(ITEM_CURRENCY_USD);
            Euro euro = (Euro) gestor.obtenerDivisa(ITEM_CURRENCY_EUR);
            LibraEsterlina libra = (LibraEsterlina) gestor.obtenerDivisa(ITEM_CURRENCY_GBP);
            PesoChileno peso = (PesoChileno) gestor.obtenerDivisa(ITEM_CURRENCY_CLP);
            WonSurcoreano won = (WonSurcoreano) gestor.obtenerDivisa(ITEM_CURRENCY_KRW);
            YenJapones yen = (YenJapones) gestor.obtenerDivisa(ITEM_CURRENCY_JPY);

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

                                div1 = dolar.getNombre();
                                ccy1 = dolar.getCcy();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getNombre();
                                        ccy2 = euro.getCcy();

                                        resultado = this.cambioDivisa(dolar,
                                                valor, euro, ccy1);

                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getNombre();
                                        ccy2 = libra.getCcy();

                                        resultado = this.cambioDivisa(dolar,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getNombre();
                                        ccy2 = peso.getCcy();

                                        resultado = this.cambioDivisa(dolar,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getNombre();
                                        ccy2 = won.getCcy();

                                        resultado = this.cambioDivisa(dolar,
                                                valor, won, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getNombre();
                                        ccy2 = yen.getCcy();

                                        resultado = this.cambioDivisa(dolar,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_EUR -> {

                                div1 = euro.getNombre();
                                ccy1 = euro.getCcy();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dolar.getNombre();
                                        ccy2 = dolar.getCcy();

                                        resultado = this.cambioDivisa(euro,
                                                valor, dolar, ccy1);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getNombre();
                                        ccy2 = libra.getCcy();

                                        resultado = this.cambioDivisa(euro,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getNombre();
                                        ccy2 = peso.getCcy();

                                        resultado = this.cambioDivisa(euro,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getNombre();
                                        ccy2 = won.getCcy();

                                        resultado = this.cambioDivisa(euro,
                                                valor, won, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getNombre();
                                        ccy2 = yen.getCcy();

                                        resultado = this.cambioDivisa(euro,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_GBP -> {

                                div1 = libra.getNombre();
                                ccy1 = libra.getCcy();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dolar.getNombre();
                                        ccy2 = dolar.getCcy();

                                        resultado = this.cambioDivisa(libra,
                                                valor, dolar, ccy1);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getNombre();
                                        ccy2 = euro.getCcy();

                                        resultado = this.cambioDivisa(libra,
                                                valor, euro, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getNombre();
                                        ccy2 = peso.getCcy();

                                        resultado = this.cambioDivisa(libra,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getNombre();
                                        ccy2 = won.getCcy();

                                        resultado = this.cambioDivisa(libra,
                                                valor, won, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getNombre();
                                        ccy2 = yen.getCcy();

                                        resultado = this.cambioDivisa(libra,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_CLP -> {

                                div1 = peso.getNombre();
                                ccy1 = libra.getCcy(); // Esto no es un error, es un control de daños.

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dolar.getNombre();
                                        ccy2 = dolar.getCcy();

                                        resultado = this.cambioDivisa(peso,
                                                valor, dolar, ccy1);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getNombre();
                                        ccy2 = euro.getCcy();

                                        resultado = this.cambioDivisa(peso,
                                                valor, euro, ccy1);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getNombre();
                                        ccy2 = libra.getCcy();

                                        resultado = this.cambioDivisa(peso,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getNombre();
                                        ccy2 = won.getCcy();

                                        resultado = this.cambioDivisa(peso,
                                                valor, won, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getNombre();
                                        ccy2 = yen.getCcy();

                                        resultado = this.cambioDivisa(peso,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_KRW -> {

                                div1 = won.getNombre();
                                ccy1 = won.getCcy();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dolar.getNombre();
                                        ccy2 = dolar.getCcy();

                                        resultado = this.cambioDivisa(won,
                                                valor, dolar, ccy1);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getNombre();
                                        ccy2 = euro.getCcy();

                                        resultado = this.cambioDivisa(won,
                                                valor, euro, ccy1);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getNombre();
                                        ccy2 = libra.getCcy();

                                        resultado = this.cambioDivisa(won,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getNombre();
                                        ccy2 = peso.getCcy();

                                        resultado = this.cambioDivisa(won,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        div2 = yen.getNombre();
                                        ccy2 = yen.getCcy();

                                        resultado = this.cambioDivisa(won,
                                                valor, yen, ccy1);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_JPY -> {

                                div1 = yen.getNombre();
                                ccy1 = yen.getCcy();

                                switch (Objects.requireNonNull(cbx_divisa2.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        div2 = dolar.getNombre();
                                        ccy2 = dolar.getCcy();

                                        resultado = this.cambioDivisa(yen,
                                                valor, dolar, ccy1);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        div2 = euro.getNombre();
                                        ccy2 = euro.getCcy();

                                        resultado = this.cambioDivisa(yen,
                                                valor, euro, ccy1);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        div2 = libra.getNombre();
                                        ccy2 = libra.getCcy();

                                        resultado = this.cambioDivisa(yen,
                                                valor, libra, ccy1);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        div2 = peso.getNombre();
                                        ccy2 = peso.getCcy();

                                        resultado = this.cambioDivisa(yen,
                                                valor, peso, ccy1);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        div2 = won.getNombre();
                                        ccy2 = won.getCcy();

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