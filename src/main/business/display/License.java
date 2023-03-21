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

public class License extends JFrame implements ActionListener, ChangeListener, UserInterface {

	private JCheckBox checkBoxIAccept; // declara caja de chequeo
	private JButton buttonContinue; // declara botón
	private JButton buttonIDontAccept; // declara botón
	String name; // Evitar declarar String vacíos, es redundante (String nombre = "")

	/**
	 * Método responsable de la carga de interfaz de usuario
	 */
	public License(){

		loadUserInterface();
	}

	/**
	 * Método responsable de los cambios de estado de la aplicación
	 *
	 * @param e el objeto ChangeEvent
	 */
	public void stateChanged(ChangeEvent e){
		
		if(checkBoxIAccept.isSelected()){ // sí se aceptan los términos
			buttonContinue.setEnabled(true); // habilita el botón continuar
			buttonIDontAccept.setEnabled(false); // des-habilita el botón no acepto
		} else {
			buttonContinue.setEnabled(false); // des-habilita el botón continuar
			buttonIDontAccept.setEnabled(true); // habilita el botón no acepto
		}
	}


	/**
	 * Método responsable de los eventos de la aplicación
	 *
	 * @param e el evento a ser procesado
	 */
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == buttonContinue){ // si se presiona el botón continuar
			CurrencyConverter ventanaCurrencyConverter = new CurrencyConverter(); // instancia principal
			ventanaCurrencyConverter.setBounds(
					COORDENATE_X_CURRENCY_WINDOW,
					COORDENATE_Y_CURRENCY_WINDOW,
					WIDTH_CURRENCY_WINDOW,
					HEIGHT_CURRENCY_WINDOW); // dimensiones
			ventanaCurrencyConverter.setVisible(true); // principal visible
			ventanaCurrencyConverter.setResizable(false); // ventana redimensionable
			ventanaCurrencyConverter.setLocationRelativeTo(null); // posición relativa
			this.setVisible(false); // esconde la pantalla de licencia
			
		} else if(e.getSource() == buttonIDontAccept){ // si presiona botó no acepto
			Welcome ventanaWelcome = new Welcome(); // instancia bienvenida
			ventanaWelcome.setBounds(
					COORDENATE_X_WELCOME_WINDOW,
					COORDENATE_Y_WELCOME_WINDOW,
					WIDTH_WELCOME_WINDOW,
					HEIGHT_WELCOME_WINDOW); // dimensiones
			ventanaWelcome.setVisible(true); // bienvenida visible
			ventanaWelcome.setLocationRelativeTo(null); // posición relativa
			ventanaWelcome.setResizable(false); // ventana redimensionable
			this.setVisible(false); // esconde pantalla licencia
		}
	}

	/**
	 * Método utilizado como punto de entrada para la ejecución de la aplicación.
	 *
	 * @param args parámetro por defecto del método main.
	 */
	public static void main(String[] args){
		
		License ventanaLicencia = new License(); // instancia licencia
		
		ventanaLicencia.setBounds(
				COORDENATE_X_LICENSE_WINDOW,
				COORDENATE_Y_LICENSE_WINDOW,
				WIDTH_LICENSE_WINDOW_OPT,
				HEIGHT_LICENSE_WINDOW_OPT); // dimensiones
		ventanaLicencia.setVisible(true); // ventana visible
		ventanaLicencia.setResizable(false); // ventana redimensionable
		ventanaLicencia.setLocationRelativeTo(null); // posición relativa
	}

	/**
	 * Método responsable de la creación de los marcos
	 *
	 * @param title 			Título del marco
	 * @param colorBackground	Color de fondo del marco
	 */
	@Override
	public void createFrame(String title, Color colorBackground) {
		setLayout(null); // marco de trabajo
		setDefaultCloseOperation(EXIT_ON_CLOSE); // operación de cierre por defecto
		setTitle(title); // título
	}

	/**
	 * Método encargado de la carga del ícono en la aplicación
	 * @param imagePath ruta de la imagen
	 */
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
	public void createLogoLabel(String logoPath, PositionInFrame position, DimensionInFrame dimension) {

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

	public void loadUserInterface(){

		// configura el marco y su ícono
		createFrame(LABEL_LICENCE, COLOR_BACKGROUND_LICENSE_FRAME);
		setIcon(ICON);

		// configura el resto de los componentes que componen el marco

		this.name = Welcome.name; // asigna nombre desde la bienvenida

		// etiqueta
		setLabel(TEXT_FIELD_LICENCE,
				POSITION_LICENSE_TEXTFIELD,
				DIMENSION_LICENSE_TEXTFIELD,
				COLOR_BACKGROUND_LICENSE_TEXTFIELD,
				FONT_LICENSE_TEXTFIELD);

		// area de texto
		JTextArea textArea = createTextArea(
				TEXT_FIELD_LICENCE_DETAIL,
				Boolean.FALSE,
				FONT_LICENSE_DETAIL,
				COLOR_FONT_LICENSE_DETAIL,
				COLOR_BACKGROUND_LICENSE_DETAIL);

		// scroll
		createScrollPane(textArea,
				POSITION_LICENSE_SCROLL_PANE,
				DIMENSION_LICENSE_SCROLL_PANE);

		// checkbox
		this.checkBoxIAccept = createCheckBox("Yo, " + name + ", acepto",
				POSITION_LICENSE_CHECKBOX_I_ACCEPT,
				DIMENSION_LICENSE_CHECKBOX_I_ACCEPT);

		// botones
		this.buttonContinue = createButton(BUTTON_CONTINUE,
				POSITION_LICENSE_BUTTON_CONTINUE,
				DIMENSION_LICENSE_BUTTON_CONTINUE,
				FONT_BUTTON_CONTINUE,
				COLOR_FONT_BUTTON_CONTINUE,
				COLOR_BACKGROUND_BUTTON_CONTINUE,
				Boolean.FALSE);

		this.buttonIDontAccept = createButton(BUTTON_DECLINE,
				POSITION_LICENSE_BUTTON_DECLINE,
				DIMENSION_LICENSE_BUTTON_DECLINE,
				FONT_BUTTON_DECLINE,
				COLOR_FONT_BUTTON_DECLINE,
				COLOR_BACKGROUND_BUTTON_DECLINE,
				Boolean.TRUE);

		// logo
		createLogoLabel(LOGO_ALURA,
				POSITION_LICENSE_LOGO_ALURA,
				DIMENSION_LICENSE_LOGO_ALURA);
	}
}