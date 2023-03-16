package src.main.business.display; // declara el paquete donde estarán ubicadas nuestras pantallas de usuario

import src.main.interfaces.UserInterface; // importa mi interfaz Front para implementarla en esta clase
import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase

import javax.swing.*; // importa librería gráfica para configurar la pantalla
import java.awt.event.*; // importa librería para implementer interfaz ActionListener
import java.awt.*; // importa librería para manipular eventos
import java.util.Objects; // importa librería util.Objects para usar requireNonNull

/*
	Autor: Jorge Daniel Salgado Pons
	Fecha: 25-02-2023

	Propósito: Esta clase le da la bienvenida al usuario a nuestra aplicación.
	Bienvenida muestra una interfaz gráfica donde el usuario debe escribir su nombre
	para poder proceder. De lo contrario aparecerá un pop-up indicando que el nombre
	es necesario para poder avanzar.

	Nuestra clase Bienvenida es una clase hija de la clase JFrame e implementa
	la interfaz ActionListener de la librería awt.event.* y también
	implementa una interfaz propia llamada Front que diseñé para mejorar
	las implementaciones de interfaz gráfica.
*/

public class Bienvenida extends JFrame implements ActionListener, UserInterface {

    private final JTextField txf_nombre; // declara area de texto
    private final JButton btn_ingresar; // declara botón
    public static String nombre = "";

    /*
        En el constructor de esta clase vamos a establecer el marco sobre el cual
        vamos a trabajar nuestra interfaz gráfica.

        Para ello necesitaremos títulos, colores, íconos, logos, dimensiones, y todos los
        elementos necesarios para poder mostrar por pantalla nuestra interfaz.

        Estas funcionalidades son propias de la interfaz Front que he diseñado de manera
        paralela a este desarrollo.
    */
    public Bienvenida() {

        // configura el marco
        createFrame(HEADER_WELCOME, new Color(147, 82, 210));

        // configura el ícono
        setIcon(ICONO);

        // configura el logo
        setLogo(LOGO, new PositionInFrame(25, 15), new DimensionInFrame(300, 100));

        // etiquetas
        setLabel(SUB_MENU_CURRENCY_CONVERTER,
                new PositionInFrame(70, 135),
                new DimensionInFrame(300, 30),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 18));

        setLabel(LABEL_INPUT_NAME,
                new PositionInFrame(45, 212),
                new DimensionInFrame(200, 30),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        setLabel(LABEL_FOOTER,
                new PositionInFrame(55, 375),
                new DimensionInFrame(300, 30),
                new Color(255, 255, 255),
                new FontType(FONT_ANDALE_MONO, 12));

        // campo de texto
        this.txf_nombre = createTextField(new PositionInFrame(45, 240),
                new DimensionInFrame(255, 25),
                new FontType(FONT_ANDALE_MONO, 14),
                new Color(224, 224, 224),
                new Color(255, 0, 255));

        // botón
        this.btn_ingresar = createButton(BUTTON_ENTER,
                new PositionInFrame(125, 280),
                new DimensionInFrame(100, 30),
                new FontType(FONT_ANDALE_MONO, 14),
                new Color(0, 0, 255),
                new Color(255, 255, 255),
                Boolean.FALSE);
    }

    /**
     * Crea un elemento de campo de texto según una posición, dimensión, tipo de letra, color de fondo y
     * color de letra específicos
     *
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
        return null;
    }

    /**
     * Crea un elemento Scroll dentro de un área de texto específico de acuerdo a una posición y dimensión
     * específicas. En esta clase no tiene uso.
     *
     * @param textArea             El área de texto dentro del marco
     * @param position  Posición específica dentro del área de texto
     * @param dimension Dimensión específica dentro del área de texto
     */
    @Override
    public void createScrollPane(JTextArea textArea, PositionInFrame position, DimensionInFrame dimension) {
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

    /**
     * Establece una etiqueta con su respectiva posición, dimensión, color de fondo, tipo de letra y nombre
     * @param name            Nombre de la etiqueta
     * @param position   La posición de la etiqueta en el marco, en los ejes X e Y
     * @param dimension  La dimensión de la etiqueta en el marco, basado en ancho y largo
     * @param backgroundColor   Color de fondo de la etiqueta
     * @param fontType          Tipo de letra o fuente, de la etiqueta
     */
    @Override
    public void setLabel(String name, PositionInFrame position, DimensionInFrame dimension,
                         Color backgroundColor, FontType fontType) {

        int font = (SUB_MENU_CURRENCY_CONVERTER.equals(name)) ? Font.ITALIC : Font.BOLD;

        // Establece la etiqueta con un nombre específico
        JLabel jLabel = new JLabel(name);

        // Establece la posición y la dimensión de la etiqueta
        jLabel.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

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
     * @param backgroundColor Color de fondo de la barra de menú
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
     * @param name            Nombre del menú
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
     * @param name        Nombre del ítem
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
     * @param position Posición del ComboBox en coordenadas X e Y específicas
     * @param dimension Dimensión del ComboBox de acuerdo a una base y altura específicas
     * @param textColor Color del texto del ComboBox
     * @param backgroundColor Color de fondo del ComboBox
     * @param fontType Tipo de letra del texto del ComboBox
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

    /*
        estableceMarco configura el marco de la pantalla;
            - Título del marco
            - Colores para el fondo
     */
    @Override
    public void createFrame(String titulo, Color colorBackground) {

        setLayout(null); // definir marco de trabajo
        setDefaultCloseOperation(EXIT_ON_CLOSE); // definir operación de cierre de app por defecto
        setTitle(titulo); // título de este marco
        getContentPane().setBackground(colorBackground); // color de fondo por defecto
    }

    /*
        estableceIcono nos ayuda a establecer un ícono para esta pantalla.
     */
    @Override
    public void setIcon(String imagePath) {

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath))).getImage()); // icono
    }

    /**
     * Establece el logo en una posición y dimensión específicas
     *
     * @param logoPath              La ruta del logo
     * @param position   La posición del logo en el marco, en los ejes X e Y
     * @param dimension  La dimensión del logo en el marco, basado en ancho y largo
     */
    @Override
    public void setLogo(String logoPath, PositionInFrame position, DimensionInFrame dimension) {

        // logo
        ImageIcon imageIcon = new ImageIcon(logoPath);

        // etiqueta que contiene el logo
        JLabel jLabel = new JLabel(imageIcon);

        // posición y dimensión de la etiqueta
        jLabel.setBounds(new Rectangle(position.getX(), position.getY(),
                dimension.getWidth(), dimension.getHeight()));

        // se añade la etiqueta al marco
        add(jLabel);
    }

    // Evento del botón 'Ingresar'
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_ingresar) { // evaluar si disparar el evento

            nombre = this.txf_nombre.getText().trim(); // no se usa .this porque se hace una referencia estática

            // validación nombre vacío
            if (nombre.equals("")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre");
            } else {
                Licencia ventanaLicencia = new Licencia(); // instanciar licencia
                ventanaLicencia.setBounds(0, 0, 610, 380); // dimensiones
                ventanaLicencia.setVisible(true); // hacer licencia visible
                ventanaLicencia.setResizable(false); // tamaño de la ventana reajustable
                ventanaLicencia.setLocationRelativeTo(null); // posición relativa
                this.setVisible(false); // esconde bienvenida
            }
        }
    }

    /*
        En nuestro método principal preparamos la instancia
        de nuestra pantalla de Bienvenida y configuramos sus valores.
     */
    public static void main(String[] args) {

        Bienvenida ventanaBienvenida = new Bienvenida();
        ventanaBienvenida.setBounds(0, 0, 350, 450);
        ventanaBienvenida.setVisible(true);
        ventanaBienvenida.setLocationRelativeTo(null);
        ventanaBienvenida.setResizable(false);
    }
}