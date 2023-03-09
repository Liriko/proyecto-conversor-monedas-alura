package negocio.pantalla; // declara el paquete donde estarán ubicadas nuestras pantallas de usuario

import interfaces.Front; // importa mi interfaz Front para implementarla en esta clase

import static constantes.Constantes.*; // importa mis constantes para su libre uso en esta clase

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

public class Bienvenida extends JFrame implements ActionListener, Front {

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

        // configura el marco y su ícono
        estableceMarco(TITULO_BIENVENIDA, 147, 82, 210);
        estableceIcono(ICONO);

        // configura el resto de los componentes que componen el marco

        // logo
        estableceLogo(LOGO, 25, 15, 300, 100);

        // etiquetas
        estableceEtiqueta(CONVERSOR, 70, 135, 300, 30,
                255, 255, 255, FONT_ANDALE_MONO, Font.ITALIC, 18);
        estableceEtiqueta(INGRESA_NOMBRE, 45, 212, 200, 30,
                255, 255, 255, FONT_ANDALE_MONO, Font.BOLD, 12);
        estableceEtiqueta(FOOTER, 55, 375, 300, 30,
                255, 255, 255, FONT_ANDALE_MONO, Font.BOLD, 12);

        // campo de texto
        this.txf_nombre = creaCampoDeTexto(45, 240, 255, 25, FONT_ANDALE_MONO, Font.BOLD, 14,
                255, 0, 255, 224, 224, 224);

        // botón
        this.btn_ingresar = creaBoton(INGRESAR, 125, 280, 100, 30,
                FONT_ANDALE_MONO, Font.BOLD, 14,
                0, 0, 255,
                255, 255, 255, Boolean.FALSE);
    }

    /*
        Acá están los métodos propios de la interfaz Front que deben implementarse.

        estableceCampoDeTexto configura el campo de texto que recibe el nombre del usuario;
            - Posición en el marco
            - Tipo de fuente
            - Color de la fuente
            - Color de fondo
     */
    @Override
    public JTextField creaCampoDeTexto(int x, int y, int width, int height,
                                            String font, int style, int size,
                                            int red, int green, int blue,
                                            int red2, int green2, int blue2) {
        JTextField campo;
        campo = new JTextField(); // inicializa area de texto
        campo.setBounds(x, y, width, height); // establece dimensiones
        campo.setFont(new Font(font, style, size)); // establece tipo de fuente
        campo.setForeground(new Color(red, green, blue)); // establece el color de la letra
        campo.setBackground(new Color(red2, green2, blue2)); // establece el color de fondo

        add(campo); // añade el campo a nuestro marco
        return campo; // retorna el campo
    }

    /*
        estableceBoton configura el botón 'Ingresar';
            - Nombre del botón ('Ingresar')
            - Posición en el marco
            - Tipo de fuente
            - Color de fuente
            - Color de fondo
     */
    @Override
    public JButton creaBoton(String nombre, int x, int y, int width, int height,
                                  String font, int style, int size,
                                  int red, int green, int blue,
                                  int red2, int green2, int blue2, boolean valor) {
        JButton boton;
        boton = new JButton(nombre); // inicializa botón
        boton.setBounds(x, y, width, height); // establece dimensiones
        boton.setFont(new Font(FONT_ANDALE_MONO, style, size)); // establece tipo de fuente
        boton.setForeground(new Color(red, green, blue)); // establece el color de la letra
        boton.setBackground(new Color(red2, green2, blue2)); // establece el color de fondo

        boton.addActionListener(this); // añade un evento al botón

        add(boton); // añade el boton a nuestro marco
        return boton; // retorna el botón
    }

    /*
        estableceAreaDeTexto no tiene uso en esta clase, pero debe implementarse porque es parte
        de la interfaz Front. Como no tiene utilidad, el cuerpo de este método solo retorna null.
     */
    @Override
    public JTextArea creaAreaDeTexto(String texto, boolean valor,
                                     String font, int style, int size,
                                     int red, int green, int blue,
                                     int red2, int green2, int blue2) {
        return null;
    }

    /*
        estableceScroll no tiene uso en esta clase, pero debe implementarse porque es parte
        de la interfaz Front. Como no tiene utilidad, el cuerpo de este método solo retorna null.
     */
    @Override
    public void estableceScroll(JTextArea area, int x, int y, int width, int height) {
    }

    /*
        estableceCheckbox no tiene uso en esta clase, pero debe implementarse porque es parte
        de la interfaz Front. Como no tiene utilidad, el cuerpo de este método solo retorna null.
     */
    @Override
    public JCheckBox creaCheckbox(String msg, int x, int y, int width, int height) {
        return null;
    }

    /*
        estableceEtiqueta configura las distintas etiquetas de la pantalla;
            - Nombre de la etiqueta
            - Posición en el marco
            - Tipo de fuente
            - Color de fuente
     */
    @Override
    public void estableceEtiqueta(String nombre, int x, int y, int width, int height,
                                    int red, int green, int blue, String font, int style, int size) {
        JLabel etiqueta;
        etiqueta = new JLabel(nombre); // establece etiqueta
        etiqueta.setBounds(x, y, width, height); // dimensiones
        etiqueta.setFont(new Font(font, style, size)); // letra
        etiqueta.setForeground(new Color(red, green, blue)); // fondo

        add(etiqueta);
    }

    @Override
    public JMenuBar creaBarraDeMenu(int red, int green, int blue) {
        return null;
    }

    @Override
    public JMenu creaMenu(String nombre, int red, int green, int blue, String font, int style, int size, int red2, int green2, int blue2) {
        return null;
    }

    @Override
    public JMenuItem creaMenuItem(String nombre, String font, int style, int size, int red, int green, int blue) {
        return null;
    }

    @Override
    public JComboBox creaComboBox(int x, int y, int width, int height, int red, int green, int blue, int red2, int green2, int blue2, String font, int style, int size) {
        return null;
    }

    /*
        estableceMarco configura el marco de la pantalla;
            - Título del marco
            - Colores para el fondo
     */
    @Override
    public void estableceMarco(String titulo, int red, int green, int blue) {

        setLayout(null); // definir marco de trabajo
        setDefaultCloseOperation(EXIT_ON_CLOSE); // definir operación de cierre de app por defecto
        setTitle(titulo); // título de este marco
        getContentPane().setBackground(new Color(red, green, blue)); // color de fondo por defecto
    }

    /*
        estableceIcono nos ayuda a establecer un ícono para esta pantalla.
     */
    @Override
    public void estableceIcono(String icono) {

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(icono))).getImage()); // icono
    }

    /*
        estableceLogo hace lo propio con el logo
     */
    @Override
    public void estableceLogo(String logo, int x, int y, int width, int height) {
        ImageIcon imagen = new ImageIcon(logo); // logo
        JLabel etiqueta = new JLabel(imagen); // se le asigna el logo a la etiqueta correspondiente
        etiqueta.setBounds(x, y, width, height); // dimensiones

        add(etiqueta);
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