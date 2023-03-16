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
		createFrame(LABEL_LICENCE, new Color(0, 0, 0));
		setIcon(ICONO);

		// configura el resto de los componentes que componen el marco

		this.nombre = Bienvenida.nombre; // asigna nombre desde la bienvenida

		// etiqueta
		setLabel(TEXT_FIELD_LICENCE,
				new PositionInFrame(215, 5),
				new DimensionInFrame(200, 30),
				new Color(0, 0, 0),
				new FontType(FONT_ANDALE_MONO, 14));

		// area de texto
		JTextArea textArea_01 = createTextArea(TEXT_FIELD_LICENCE_DETAIL, Boolean.FALSE,
				new FontType(FONT_ANDALE_MONO, 9),
				new Color(0, 0, 0),
				new Color(0, 0, 0));

		// scroll
		createScrollPane(textArea_01,
				new PositionInFrame(10, 40),
				new DimensionInFrame(575, 200));

		// checkbox
		this.chk_acepto = createCheckBox("Yo, " + nombre + ", acepto",
				new PositionInFrame(10, 250),
				new DimensionInFrame(300, 30));

		// botones
		this.btn_continuar = createButton(BUTTON_CONTINUE,
				new PositionInFrame(10, 290),
				new DimensionInFrame(100, 30),
				new FontType(null, 0),
				new Color(0, 0, 0),
				new Color(0, 0, 0),
				Boolean.FALSE);

		this.btn_noAcepto = createButton(BUTTON_DECLINE,
				new PositionInFrame(120, 290),
				new DimensionInFrame(100, 30),
				new FontType(null, 0),
				new Color(0, 0, 0),
				new Color(0, 0, 0),
				Boolean.TRUE);

		// logo
		setLogo(LOGO_ALURA, new PositionInFrame(300, 225), new DimensionInFrame(300, 120));
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
	public void createFrame(String titulo, Color colorBackground) {
		setLayout(null); // marco de trabajo
		setDefaultCloseOperation(EXIT_ON_CLOSE); // operación de cierre por defecto
		setTitle(titulo); // título
	}

	@Override
	public void setIcon(String imagePath) {
		setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath))).getImage()); // ícono
	}

	/**
	 * Establece el logo dentro del marco específicado
	 * @param logoPath la ruta del logo
	 * @param position la posición del logo en el marco, en los ejes X e Y
	 * @param dimension la dimensión del logo en el marco, basado en ancho y largo
	 */
	@Override
	public void setLogo(String logoPath, PositionInFrame position, DimensionInFrame dimension) {

		// Establece el logo como imagen
		ImageIcon imageIcon = new ImageIcon(logoPath);

		// Establece la etiqueta que contendrá el logo
		JLabel lLabel = new JLabel(imageIcon);

		// Establece la posición y dimensión de la etiqueta
		lLabel.setBounds(new Rectangle(position.getX(), position.getY(),
						dimension.getWidth(), dimension.getHeight()));

		// Añade la etiqueta al marco
		add(lLabel);
	}

	/**
	 * Establece una etiqueta con su respectiva posición, dimensión, color de fondo, tipo de letra y nombre
	 * @param name nombre de la etiqueta
	 * @param position la posición de la etiqueta en el marco, en los ejes X e Y
	 * @param dimension la dimensión de la etiqueta en el marco, basado en ancho y largo
	 * @param backgroundColor color de fondo de la etiqueta
	 * @param fontType tipo de letra o fuente, de la etiqueta
	 */
	@Override
	public void setLabel(String name, PositionInFrame position, DimensionInFrame dimension,
						 Color backgroundColor,
						 FontType fontType) {

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
	 * No tiene uso en esta clase.
	 *
	 * @param backgroundColor Color de fondo de la barra de menú
	 * @return la barra de menú
	 */
	@Override
	public JMenuBar createMenuBar(Color backgroundColor) {
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

	/**
	 * Crea un elemento de campo de texto según una posición, dimensión, tipo de letra, color de fondo y
	 * color de letra específicos. En esta clase no tendrá uso.
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
		return null;
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

		// Cambiamos el estado del botón según parámetro
		setEnabled(isEnabled);

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
		jScrollPane.setBounds(position.getX(), position.getY(),
				dimension.getWidth(), dimension.getHeight());

		// Añade el elemento al marco principal
		add(jScrollPane);
	}

	/**
	 * Crea un elemento checkBox con una posición y dimensión específica.
	 *
	 * @param msg Mensaje que mostrará el checkbox.
	 * @param position Posición del checkbox en coordenadas X y Y
	 * @param dimension Dimensión del checkbox según base y altura
	 * @return el checkbox
	 */
	@Override
	public JCheckBox createCheckBox(String msg, PositionInFrame position,
									DimensionInFrame dimension) {

		// Crea el componente checkbox con un mensaje según parámetro
		JCheckBox jCheckBox = new JCheckBox(msg);

		// Establece las dimensiones y posiciones específicas del checkbox en el marco
		jCheckBox.setBounds(new Rectangle(position.getX(), position.getY(), dimension.getWidth(), dimension.getHeight()));

		// Añade un evento a este componente
		jCheckBox.addChangeListener(this);

		// Añade el checkbox al marco
		add(jCheckBox);

		// Retorna el checkbox
		return jCheckBox;
	}
}