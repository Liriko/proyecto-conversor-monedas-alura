package src.main.business.display; // declara el paquete donde estarán ubicadas nuestras pantallas de usuario

import src.main.interfaces.UserInterface; // importa mi interfaz Front para implementarla en esta clase
import src.main.model.currency.*;
import src.main.business.logic.CurrencyManager; // importa gestor de divisas para el cambio de moneda
import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase

import javax.swing.*; // importa librería gráfica para configurar la pantalla
import java.awt.event.*; // importa librería para implementer interfaz ActionListener
import java.awt.*; // importa librería para manipular eventos
import java.util.Objects; // importa librería util.Objects para usar requireNonNull
import java.util.Set;

public class CurrencyConverter extends JFrame implements ActionListener, UserInterface {

    private JMenuItem menuItemTemperatureConverter;
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
    private JComboBox comboBoxCurrency;
    private JComboBox comboBoxCurrencyPair;

    // Botón

    private JButton buttonCalculate;

    // Área de texto
    private JTextArea textArea;

    String name;
    CurrencyManager currencyManager = new CurrencyManager();

    /**
     * Constructor que carga la interfaz de usuario a través del método loadUserInterface.
     */
    public CurrencyConverter() {

        loadUserInterace();
    }

    /**
     * Método que carga los combobox de datos.
     *
     * @param combobox  Componenente de la clase JComboBox
     * @param manager   Gestor encargado del manejo de objetos que se listarán en el compontente JComboBox
     */
    public void addCurrency(JComboBox combobox, CurrencyManager manager) {

        combobox.addItem(ITEM_OPTION_SELECT);

        Set<String> keys = manager.getMap().keySet();

        for (String key : keys) {

            Currency value = manager.getMap().get(key);
            combobox.addItem(value.getName());
        }
    }

    /**
     * Método encargado del cambio de divisas
     *
     * @param currency      Divisa a cambiar
     * @param value         Valor a cambiar
     * @param currencyPair  Divisa a obtener
     * @param ccy           Símbolo de la divisa
     * @return valor de retorno correspondinte al cambio de divisas
     */
    public double currencyChange(Currency currency, double value, Currency currencyPair, char ccy) {

        double result;

        if (ccy == SYMBOL_USD) result = currencyPair.getValueInUSD() * value;
        else result = Math.round(((value / currency.getValueInUSD()) * currencyPair.getValueInUSD()) * 100d) / 100d;

        return result;
    }

    /**
     * Método encargado de preparar el mensaje de respuesta.
     *
     * @param userName      Nombre del usuario
     * @param userLastName  Apellido paterno del usuario
     * @param userSurName   Apellido materno del usuario
     * @param currency      Divisa a cambiar
     * @param currencyPair  Divisa a obtener
     * @param ccy           Símbolo de la divisa
     * @param value         Valor de la divisa a cambiar
     * @param result        Resultado de la operación de cambio de divisas
     */
    public void setText(String userName, String userLastName, String userSurName,
                        String currency, String currencyPair, char ccy, double value, double result) {

        textArea.setText("\n El usuario " + userName + " " + userLastName + " " + userSurName
                + "\n cambió " + value + " " + currency
                + "\n por " + currencyPair
                + "\n y recibe a cambio " + ccy + "" + result);
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
        jLabel.setBounds(position.getX(), position.getY(), dimension.getWidth(),
                dimension.getHeight());

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

            Dollar dollar = (Dollar) currencyManager.getCurrency(ITEM_CURRENCY_USD);
            Euro euro = (Euro) currencyManager.getCurrency(ITEM_CURRENCY_EUR);
            PoundSterling libra = (PoundSterling) currencyManager.getCurrency(ITEM_CURRENCY_GBP);
            ChileanPeso peso = (ChileanPeso) currencyManager.getCurrency(ITEM_CURRENCY_CLP);
            SouthKoreanWon won = (SouthKoreanWon) currencyManager.getCurrency(ITEM_CURRENCY_KRW);
            JapaneseYen yen = (JapaneseYen) currencyManager.getCurrency(ITEM_CURRENCY_JPY);

            String userName = this.textFieldName.getText();
            String userLastName = this.textFieldLastName.getText();
            String userSurName = this.textFieldSurName.getText();

            String currency = "";
            String currencyPair = "";
            char ccy;
            char ccyPair = 'a';

            try {

                if (textFieldValue != null){

                    value = Double.parseDouble(textFieldValue.getText());
                }
            } catch (NumberFormatException err) {

                fail = Boolean.TRUE;
            }

            if (fail) {

                JOptionPane.showMessageDialog(null, MSG_INVALID_VALUE_EMPTY_OR_SPECIAL_CHAR,
                        MSG_ERROR, JOptionPane.ERROR_MESSAGE);
            } else {

                if (value < 0) {

                    JOptionPane.showMessageDialog(null, MSG_INVALID_VALUE_LOWER_THAN_ZERO,
                            MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                } else {

                    if (Objects.equals(comboBoxCurrency.getSelectedItem(), ITEM_OPTION_SELECT) ||
                            Objects.equals(comboBoxCurrencyPair.getSelectedItem(), ITEM_OPTION_SELECT)) {

                        JOptionPane.showMessageDialog(null, MSG_INVALID_CURRENCY_PAIR,
                                MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                    } else {

                        switch (Objects.requireNonNull(comboBoxCurrency.getSelectedItem()).toString()) {

                            case ITEM_CURRENCY_USD -> {

                                currency = dollar.getName();
                                ccy = dollar.getCurrencySymbol();

                                switch (Objects.requireNonNull(comboBoxCurrencyPair.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_EUR -> {

                                        currencyPair = euro.getName();
                                        ccyPair = euro.getCurrencySymbol();

                                        result = this.currencyChange(dollar,
                                                value, euro, ccy);

                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        currencyPair = libra.getName();
                                        ccyPair = libra.getCurrencySymbol();

                                        result = this.currencyChange(dollar,
                                                value, libra, ccy);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        currencyPair = peso.getName();
                                        ccyPair = peso.getCurrencySymbol();

                                        result = this.currencyChange(dollar,
                                                value, peso, ccy);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        currencyPair = won.getName();
                                        ccyPair = won.getCurrencySymbol();

                                        result = this.currencyChange(dollar,
                                                value, won, ccy);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        currencyPair = yen.getName();
                                        ccyPair = yen.getCurrencySymbol();

                                        result = this.currencyChange(dollar,
                                                value, yen, ccy);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_EUR -> {

                                currency = euro.getName();
                                ccy = euro.getCurrencySymbol();

                                switch (Objects.requireNonNull(comboBoxCurrencyPair.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        currencyPair = dollar.getName();
                                        ccyPair = dollar.getCurrencySymbol();

                                        result = this.currencyChange(euro,
                                                value, dollar, ccy);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        currencyPair = libra.getName();
                                        ccyPair = libra.getCurrencySymbol();

                                        result = this.currencyChange(euro,
                                                value, libra, ccy);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        currencyPair = peso.getName();
                                        ccyPair = peso.getCurrencySymbol();

                                        result = this.currencyChange(euro,
                                                value, peso, ccy);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        currencyPair = won.getName();
                                        ccyPair = won.getCurrencySymbol();

                                        result = this.currencyChange(euro,
                                                value, won, ccy);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        currencyPair = yen.getName();
                                        ccyPair = yen.getCurrencySymbol();

                                        result = this.currencyChange(euro,
                                                value, yen, ccy);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_GBP -> {

                                currency = libra.getName();
                                ccy = libra.getCurrencySymbol();

                                switch (Objects.requireNonNull(comboBoxCurrencyPair.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        currencyPair = dollar.getName();
                                        ccyPair = dollar.getCurrencySymbol();

                                        result = this.currencyChange(libra,
                                                value, dollar, ccy);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        currencyPair = euro.getName();
                                        ccyPair = euro.getCurrencySymbol();

                                        result = this.currencyChange(libra,
                                                value, euro, ccy);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        currencyPair = peso.getName();
                                        ccyPair = peso.getCurrencySymbol();

                                        result = this.currencyChange(libra,
                                                value, peso, ccy);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        currencyPair = won.getName();
                                        ccyPair = won.getCurrencySymbol();

                                        result = this.currencyChange(libra,
                                                value, won, ccy);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        currencyPair = yen.getName();
                                        ccyPair = yen.getCurrencySymbol();

                                        result = this.currencyChange(libra,
                                                value, yen, ccy);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_CLP -> {

                                currency = peso.getName();
                                ccy = libra.getCurrencySymbol(); // Esto no es un error, es un control de daños.

                                switch (Objects.requireNonNull(comboBoxCurrencyPair.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        currencyPair = dollar.getName();
                                        ccyPair = dollar.getCurrencySymbol();

                                        result = this.currencyChange(peso,
                                                value, dollar, ccy);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        currencyPair = euro.getName();
                                        ccyPair = euro.getCurrencySymbol();

                                        result = this.currencyChange(peso,
                                                value, euro, ccy);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        currencyPair = libra.getName();
                                        ccyPair = libra.getCurrencySymbol();

                                        result = this.currencyChange(peso,
                                                value, libra, ccy);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        currencyPair = won.getName();
                                        ccyPair = won.getCurrencySymbol();

                                        result = this.currencyChange(peso,
                                                value, won, ccy);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        currencyPair = yen.getName();
                                        ccyPair = yen.getCurrencySymbol();

                                        result = this.currencyChange(peso,
                                                value, yen, ccy);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_KRW -> {

                                currency = won.getName();
                                ccy = won.getCurrencySymbol();

                                switch (Objects.requireNonNull(comboBoxCurrencyPair.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        currencyPair = dollar.getName();
                                        ccyPair = dollar.getCurrencySymbol();

                                        result = this.currencyChange(won,
                                                value, dollar, ccy);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        currencyPair = euro.getName();
                                        ccyPair = euro.getCurrencySymbol();

                                        result = this.currencyChange(won,
                                                value, euro, ccy);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        currencyPair = libra.getName();
                                        ccyPair = libra.getCurrencySymbol();

                                        result = this.currencyChange(won,
                                                value, libra, ccy);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        currencyPair = peso.getName();
                                        ccyPair = peso.getCurrencySymbol();

                                        result = this.currencyChange(won,
                                                value, peso, ccy);
                                    }
                                    case ITEM_CURRENCY_JPY -> {

                                        currencyPair = yen.getName();
                                        ccyPair = yen.getCurrencySymbol();

                                        result = this.currencyChange(won,
                                                value, yen, ccy);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                            case ITEM_CURRENCY_JPY -> {

                                currency = yen.getName();
                                ccy = yen.getCurrencySymbol();

                                switch (Objects.requireNonNull(comboBoxCurrencyPair.getSelectedItem()).toString()) {

                                    case ITEM_CURRENCY_USD -> {

                                        currencyPair = dollar.getName();
                                        ccyPair = dollar.getCurrencySymbol();

                                        result = this.currencyChange(yen,
                                                value, dollar, ccy);
                                    }
                                    case ITEM_CURRENCY_EUR -> {

                                        currencyPair = euro.getName();
                                        ccyPair = euro.getCurrencySymbol();

                                        result = this.currencyChange(yen,
                                                value, euro, ccy);
                                    }
                                    case ITEM_CURRENCY_GBP -> {

                                        currencyPair = libra.getName();
                                        ccyPair = libra.getCurrencySymbol();

                                        result = this.currencyChange(yen,
                                                value, libra, ccy);
                                    }
                                    case ITEM_CURRENCY_CLP -> {

                                        currencyPair = peso.getName();
                                        ccyPair = peso.getCurrencySymbol();

                                        result = this.currencyChange(yen,
                                                value, peso, ccy);
                                    }
                                    case ITEM_CURRENCY_KRW -> {

                                        currencyPair = won.getName();
                                        ccyPair = won.getCurrencySymbol();

                                        result = this.currencyChange(yen,
                                                value, won, ccy);
                                    } default -> fail = Boolean.TRUE;
                                }
                            }
                        }

                        if (fail){
                            JOptionPane.showMessageDialog(null, MSG_INVALID_EQUAL_CURRENCY_PAIR,
                                    MSG_ERROR, JOptionPane.ERROR_MESSAGE);
                        } else {
                            setText(userName, userLastName, userSurName, currency, currencyPair,
                                    ccyPair, value, result);
                        }
                    }
                }
            }
        }

        if (e.getSource() == menuItemTemperatureConverter) {
            ConversorTemperatura ventanaConversorTemperatura = new ConversorTemperatura(); // instancia principal
            ventanaConversorTemperatura.setBounds(
                    COORDENATE_X_TEMPERATURE_WINDOW,
                    COORDENATE_Y_TEMPERATURE_WINDOW,
                    WIDTH_TEMPERATURE_WINDOW,
                    HEIGHT_TEMPERATURE_WINDOW); // dimensiones
            ventanaConversorTemperatura.setVisible(true); // principal visible
            ventanaConversorTemperatura.setResizable(false); // ventana redimensionable
            ventanaConversorTemperatura.setLocationRelativeTo(null); // posición relativa
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

            assert textFieldName != null;
            textFieldName.setText("");
            assert textFieldLastName != null;
            textFieldLastName.setText("");
            assert textFieldSurName != null;
            textFieldSurName.setText("");
            comboBoxCurrencyPair.setSelectedIndex(0);
            comboBoxCurrency.setSelectedIndex(0);
            assert textFieldValue != null;
            textFieldValue.setText("");
            textArea.setText(TEXT_FIELD_CURRENCY_RESULT);
        }
    }

    public void loadUserInterace(){

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

        JMenuItem jMenuItemCurrencyConverter = createItemMenu(
                SUB_MENU_CURRENCY_CONVERTER,
                FONT_MENU_ITEM_CURRENCY_CONVERTER,
                COLOR_BACKGROUND_MENU_ITEM_CURRENCY_CONVERTER);

        menuItemTemperatureConverter = createItemMenu(
                SUB_MENU_TEMPERATURE_CONVERTER,
                FONT_MENU_ITEM_TEMPERATURE_CONVERTER,
                COLOR_BACKGROUND_MENU_ITEM_TEMPERATURE_CONVERTER);

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

        jMenuConverters.add(jMenuItemCurrencyConverter); // añade el menu item de conversor de divisa al menu de conversores
        jMenuConverters.add(menuItemTemperatureConverter); // añade menu item conversor temperatura a menu conversores

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
        comboBoxCurrency = createComboBox(
                POSITION_COMBOBOX_CONVERTER,
                DIMENSION_COMBOBOX_CONVERTER,
                COLOR_BACKGROUND_COMBOBOX_CONVERTER,
                COLOR_FONT_COMBOBOX_CONVERTER,
                FONT_COMBOBOX_CONVERTER);

        comboBoxCurrencyPair = createComboBox(
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

        // Se añaden las divisas a la lista de divisas
        this.currencyManager.addCurrency(ITEM_CURRENCY_USD, new Dollar(ITEM_CURRENCY_USD, 1.00d));
        this.currencyManager.addCurrency(ITEM_CURRENCY_EUR, new Euro(ITEM_CURRENCY_EUR, 0.94d));
        this.currencyManager.addCurrency(ITEM_CURRENCY_GBP, new PoundSterling(ITEM_CURRENCY_GBP, 0.84d));
        this.currencyManager.addCurrency(ITEM_CURRENCY_CLP, new ChileanPeso(ITEM_CURRENCY_CLP, 802.50d));
        this.currencyManager.addCurrency(ITEM_CURRENCY_KRW, new SouthKoreanWon(ITEM_CURRENCY_KRW, 1306.03d));
        this.currencyManager.addCurrency(ITEM_CURRENCY_JPY, new JapaneseYen(ITEM_CURRENCY_JPY, 136.53d));

        // Poblar ComboBox
        addCurrency(comboBoxCurrency, currencyManager);
        addCurrency(comboBoxCurrencyPair, currencyManager);
    }

    public static void main(String[] args) {

        CurrencyConverter ventanaCurrencyConverter = new CurrencyConverter();
        ventanaCurrencyConverter.setBounds(0, 0, 640, 535);
        ventanaCurrencyConverter.setVisible(true);
        ventanaCurrencyConverter.setResizable(false);
        ventanaCurrencyConverter.setLocationRelativeTo(null);
    }
}