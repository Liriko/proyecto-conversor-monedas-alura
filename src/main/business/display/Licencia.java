package src.main.business.display; // declara el paquete donde estarán ubicadas nuestras pantallas de usuario

import src.main.interfaces.UserInterface; // importa mi interfaz Front para implementarla en esta clase
import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import static src.main.constants.Constant.*; // importa mis constantes para su libre uso en esta clase

import javax.swing.*; // importa librería gráfica para configurar la pantalla
import javax.swing.event.*; // importa librería para implementer interfaz ChangeListener
import java.awt.*; // importa librería para manipular eventos
import java.awt.event.*; // importa librería para implementer interfaz ActionListener
import java.util.Objects; // importa librería util.Objects para usar requireNonNull

/*
	Autor: Jorge Daniel Salgado Pons
	Fecha: 25-02-2023

	Propósito: Esta clase presenta la Licencia de uso al usuario
	Aquí el usuario tiene dos opciones;
	O bien no acepta la licencia y es devuelto a la clase Bienvenida.
	O bien acepta la licencia y procede a la siguiente pantalla.

	Nuestra clase Licencia es una clase hija de la clase JFrame e implementa
	la interfaz ActionListener de la librería awt.event.* y
	la interfaz ChangeListener de la librería swing.event.* y también
	implementa una interfaz propia llamada Front que diseñé para mejorar
	las implementaciones de interfaz gráfica.
*/
public class Licencia extends JFrame implements ActionListener, ChangeListener, UserInterface {

	private final JCheckBox chk_acepto; // declara caja de chequeo
	private final JButton btn_continuar; // declara botón
	private final JButton btn_noAcepto; // declara botón
	String nombre; // Evitar declarar String vacíos, es redundante (String nombre = "")

	/*
        En el constructor de esta clase vamos a establecer el marco sobre el cual
        vamos a trabajar nuestra interfaz gráfica.

        Para ello necesitaremos títulos, colores, íconos, logos, dimensiones, y todos los
        elementos necesarios para poder mostrar por pantalla nuestra interfaz.

        Estas funcionalidades son propias de la interfaz Front que he diseñado de manera
        paralela a este desarrollo.
    */
	public Licencia(){

		// configura el marco y su ícono
		createFramework(LABEL_LICENCE, new Color(0, 0, 0));
		stablishIcon(ICONO);

		// configura el resto de los componentes que componen el marco

		this.nombre = Bienvenida.nombre; // asigna nombre desde la bienvenida

		// etiqueta
		stablishLabel(TEXT_FIELD_LICENCE,
				new PositionInFrame(215, 5),
				new DimensionInFrame(200, 30),
				new Color(0, 0, 0),
				new FontType(FONT_ANDALE_MONO, 14));

		// area de texto
		JTextArea textArea_01 = creaAreaDeTexto(TEXT_FIELD_LICENCE_DETAIL, Boolean.FALSE,
				FONT_ANDALE_MONO, Font.TRUETYPE_FONT, 9,
				0, 0, 0,
				0, 0, 0);

		// scroll
		createScroll(textArea_01,
				new PositionInFrame(10, 40),
				new DimensionInFrame(575, 200));

		// checkbox
		this.chk_acepto = creaCheckbox("Yo, " + nombre + ", acepto",
				10, 250, 300, 30);

		// botones
		this.btn_continuar = creaBoton(BUTTON_CONTINUE, 10, 290, 100, 30,
				null, 0,0,
				0,0,0,
				0,0, 0,
				Boolean.FALSE);
		this.btn_noAcepto = creaBoton(BUTTON_DECLINE, 120, 290, 100, 30,
				null, 0, 0,
				0, 0, 0,
				0, 0, 0,
				Boolean.TRUE);

		// logo
		stablishLogo(LOGO_ALURA, new PositionInFrame(300, 225), new DimensionInFrame(300, 120));
	}

	// cambios de estado
	public void stateChanged(ChangeEvent e){
		
		if(chk_acepto.isSelected()){ // sí se aceptan los términos
			btn_continuar.setEnabled(true); // habilita el botón continuar
			btn_noAcepto.setEnabled(false); // des-habilita el botón no acepto
		} else {
			btn_continuar.setEnabled(false); // des-habilita el botón continuar
			btn_noAcepto.setEnabled(true); // habilita el botón no acepto
		}
	}

	// evento
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == btn_continuar){ // si se presiona el botón continuar
			ConversorDivisas ventanaConversorDivisas = new ConversorDivisas(); // instancia principal
			ventanaConversorDivisas.setBounds(0,0,640,535); // dimensiones
			ventanaConversorDivisas.setVisible(true); // principal visible
			ventanaConversorDivisas.setResizable(false); // ventana redimensionable
			ventanaConversorDivisas.setLocationRelativeTo(null); // posición relativa
			this.setVisible(false); // esconde la pantalla de licencia
			
		} else if(e.getSource() == btn_noAcepto){ // si presiona botó no acepto
			Bienvenida ventanaBienvenida = new Bienvenida(); // instancia bienvenida
			ventanaBienvenida.setBounds(0,0,350,450); // dimensiones
			ventanaBienvenida.setVisible(true); // bienvenida visible
			ventanaBienvenida.setLocationRelativeTo(null); // posición relativa
			ventanaBienvenida.setResizable(false); // ventana redimensionable
			this.setVisible(false); // esconde pantalla licencia
		}
	}

	public static void main(String[] args){
		
		Licencia ventanaLicencia = new Licencia(); // instancia licencia
		
		ventanaLicencia.setBounds(0,0,600,360); // dimensiones
		ventanaLicencia.setVisible(true); // ventana visible
		ventanaLicencia.setResizable(false); // ventana redimensionable
		ventanaLicencia.setLocationRelativeTo(null); // posición relativa
	}

	@Override
	public void createFramework(String titulo, Color colorBackground) {
		setLayout(null); // marco de trabajo
		setDefaultCloseOperation(EXIT_ON_CLOSE); // operación de cierre por defecto
		setTitle(titulo); // título
	}

	@Override
	public void stablishIcon(String icono) {
		setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(icono))).getImage()); // ícono
	}

	/**
	 * Establece el logo dentro del marco específicado
	 * @param logo la ruta del logo
	 * @param positionInFrame la posición del logo en el marco, en los ejes X e Y
	 * @param dimensionInFrame la dimensión del logo en el marco, basado en ancho y largo
	 */
	@Override
	public void stablishLogo(String logo, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame) {

		// Establece el logo como imagen
		ImageIcon imageIcon = new ImageIcon(logo);

		// Establece la etiqueta que contendrá el logo
		JLabel lLabel = new JLabel(imageIcon);

		// Establece la posición y dimensión de la etiqueta
		lLabel.setBounds(new Rectangle(positionInFrame.getX(), positionInFrame.getY(),
						dimensionInFrame.getWidth(), dimensionInFrame.getHeight()));

		// Añade la etiqueta al marco
		add(lLabel);
	}

	/**
	 * Establece una etiqueta con su respectiva posición, dimensión, color de fondo, tipo de letra y nombre
	 * @param nombre nombre de la etiqueta
	 * @param positionInFrame la posición de la etiqueta en el marco, en los ejes X e Y
	 * @param dimensionInFrame la dimensión de la etiqueta en el marco, basado en ancho y largo
	 * @param colorBackground color de fondo de la etiqueta
	 * @param fontType tipo de letra o fuente, de la etiqueta
	 */
	@Override
	public void stablishLabel(String nombre, PositionInFrame positionInFrame, DimensionInFrame dimensionInFrame,
							  Color colorBackground,
							  FontType fontType) {

		// Establece la etiqueta con un nombre específico
		JLabel jLabel = new JLabel(nombre);

		// Establece la posición y la dimensión de la etiqueta
		jLabel.setBounds(new Rectangle(positionInFrame.getX(), positionInFrame.getY(),
				dimensionInFrame.getWidth(), dimensionInFrame.getHeight()));

		// Establece el tipo de letra de la etiqueta
		jLabel.setFont(new Font(fontType.getFont(), Font.BOLD, fontType.getSize()));

		// Establece el color de fondo de esta etiqueta
		jLabel.setForeground(colorBackground);

		// Añade la etiqueta al marco
		add(jLabel);
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

	/**
	 * Crea un elemento de campo de texto según una posición, dimensión, tipo de letra, color de fondo y
	 * color de letra específicos. En esta clase no tendrá uso.
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
		return null;
	}

	@Override
	public JButton creaBoton(String nombre, int x, int y, int width, int height,
								  String font, int style, int size,
								  int red, int green, int blue,
								  int red2, int green2, int blue2,
								  boolean valor) {
		JButton btn = new JButton(nombre); // botón
		btn.setBounds(x,y,width,height); // dimensiones
		btn.setEnabled(valor); // inhabilitado por defecto
		btn.addActionListener(this); // evento

		add(btn); // añade el botón al marco
		return btn; // retorna el botón
	}

	@Override
	public JTextArea creaAreaDeTexto(String texto, boolean valor,
									 String font, int style, int size,
									 int red, int green, int blue,
									 int red2, int green2, int blue2) {

		JTextArea area	= new JTextArea(); // área de texto
		area.setText(texto);
		area.setEditable(valor); // no es editable
		area.setFont(new Font(font,style,size)); // color de la fuente

		add(area); // añade el área de texto al marco
		return area; // retorna el área de texto
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
		jScrollPane.setBounds(positionInFrame.getX(), positionInFrame.getY(),
				dimensionInFrame.getWidth(), dimensionInFrame.getHeight());

		// Añade el elemento al marco principal
		add(jScrollPane);
	}

	@Override
	public JCheckBox creaCheckbox(String msg, int x, int y, int width, int height) {

		JCheckBox chk = new JCheckBox(msg); // caja de chequeo
		chk.setBounds(x,y,width,height); // dimensiones
		chk.addChangeListener(this); // evento

		add(chk); // añade el checkbox al marco
		return chk; // retorna el checkbox
	}
}