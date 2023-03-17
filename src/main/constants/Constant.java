package src.main.constants;

import src.main.utils.DimensionInFrame;
import src.main.utils.FontType;
import src.main.utils.PositionInFrame;

import java.awt.*;

/**
 * Clase final para evitar su extensión.
 */
public final class Constant {

    private Constant() {
        // Constructor privado para evitar su instancia
    }

    // Encabezados
    public static final String HEADER_WELCOME = "Bienvenido/a";

    // Etiquetas
    public static final String LABEL_A = "A";
    public static final String LABEL_LASTNAME = "Apellido Paterno";
    public static final String LABEL_FOOTER = "© 2023 Challenge Alura Latam Oracle-ONE";
    public static final String LABEL_INPUT_NAME = "Ingrese su nombre";
    public static final String LABEL_LICENCE = "Licencia de uso";
    public static final String LABEL_NAME = "Nombres: ";
    public static final String LABEL_SUBTITLE = "Datos del usuario y detalle de conversión";
    public static final String LABEL_SURNAME = "Apellido Materno";
    public static final String LABEL_TITLE = "Bienvenido ";
    public static final String LABEL_TO_CHANGE_FROM = "Cambio de";
    public static final String LABEL_VALUE = "Valor";

    // Botones
    public static final String BUTTON_CALCULATE = "=";
    public static final String BUTTON_CONTINUE = "Continuar";
    public static final String BUTTON_DECLINE = "No acepto";
    public static final String BUTTON_ENTER = "Ingresar";

    // Campos de texto
    public static final String TEXT_FIELD_CALCULATION_RESULT = "Resultado de la conversión";
    public static final String TEXT_FIELD_CURRENCY_RESULT = "\n Aquí aparece el resultado de la conversión de divisas.";
    public static final String TEXT_FIELD_LICENCE = "TÉRMINOS Y CONDICIONES";
    public static final String TEXT_FIELD_LICENCE_DETAIL = """


                      TÉRMINOS Y CONDICIONES

                        A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN MI AUTORIZACIÓN.
                        B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS.
                        C.  NO ME HAGO RESPONSABLE DEL MAL USO DE ESTE SOFTWARE, DE FINES PEDAGÓGICOS.

                      LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE
                      (EL AUTOR, JORGE SALGADO), NO SE RESPONSABILIZA DEL USO QUE USTED
                      HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)

                      SI USTED NO ACEPTA ESTOS TÉRMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE.\
            """;
    public static final String TEXT_FIELD_TEMPERATURE_RESULT = "\n Aquí aparece el resultado de la conversión de temperaturas";

    // Menú "Sobre mí"
    public static final String MENU_ABOUT_ME = "Sobre mí";
    public static final String SUB_MENU_AUTHOR = "Autor";
    public static final String MSG_EMAIL = "Correo: j.salgado2k@gmail.com";
    public static final String MSG_INFO_EDUCATION = "Estudiante de Alura Latam Oracle-One Next Education";
    public static final String MSG_INFO_APP = "Programa elaborado por Jorge Daniel Salgado Pons";

    // Menú "Conversores"
    public static final String MENU_CONVERTER = "Conversores";
    public static final String SUB_MENU_CURRENCY_CONVERTER = "Conversor de divisas";
    public static final String SUB_MENU_TEMPERATURE_CONVERTER = "Conversor de temperatura";

    // Menú "Opciones"
    public static final String SUB_MENU_COLOR_FONDO = "Color de fondo";
    public static final String SUB_MENU_LIMPIAR_CAMPOS = "Limpiar campos";
    public static final String SUB_MENU_NEW = "Nuevo";
    public static final String MENU_OPTIONS = "Opciones";
    public static final String SUB_MENU_EXIT = "Salir";

    // Menú "Color de fondo"
    public static final String SUB_MENU_BLACK_BACKGROUND = "Negro";
    public static final String SUB_MENU_PURPLE_BACKGROUND= "Morado";
    public static final String SUB_MENU_RED_BACKGROUND = "Rojo";


    // Valores del combobox / ítems del combobox
    public static final String ITEM_CURRENCY_USD = "USD $ - Dólar Estadounidense";
    public static final String ITEM_CURRENCY_CLP = "CLP $ - Peso Chileno";
    public static final String ITEM_CURRENCY_EUR = "Eur € - Euro";
    public static final String ITEM_CURRENCY_GBP = "GBP £ - Libra Esterlina";
    public static final String ITEM_CURRENCY_JPY = "JPY ¥ - Yen Japonés";
    public static final String ITEM_CURRENCY_KRW = "KRW ₩ - Won Surcoreano";
    public static final String ITEM_TEMPERATURE_CELSIUS = "Celsius";
    public static final String ITEM_TEMPERATURE_FAHRENHEIT = "Fahrenheit";
    public static final String ITEM_TEMPERATURE_KELVIN = "Kelvin";
    public static final String ITEM_OPTION_SELECT = "- Seleccione -";

    // Símbolos
    public static final char SYMBOL_CLP = '$';
    public static final char SYMBOL_CELSIUS = 'C';
    public static final char SYMBOL_USD = '$';
    public static final char SYMBOL_EUR = '€';
    public static final char SYMBOL_FAHRENHEIT = 'F';
    public static final char SYMBOL_KELVIN = 'K';
    public static final char SYMBOL_GBP = '£';
    public static final char SYMBOL_JPY = '¥';
    public static final char SYMBOL_KRW = '₩';

    // Mensajes de validación
    public static final String MSG_ABS_ZERO_INPUT = "Su dato de entrada no puede ser inferior al cero absoluto";
    public static final String MSG_ERROR = "Error";
    public static final String MSG_INVALID_CURRENCY_PAIR = "Debe seleccionar ambas divisas para proceder con el cambio";
    public static final String MSG_INVALID_EQUAL_CURRENCY_PAIR = "Las divisas no pueden ser iguales. Favor reintentar";
    public static final String MSG_INVALID_EQUAL_TEMPERATURE_PAIR = "Las temperaturas no pueden ser iguales. Favor reintentar";
    public static final String MSG_INVALID_VALUE_EMPTY_OR_SPECIAL_CHAR = "Valor inválido, no se permiten carácteres, ni debe ser vacío";
    public static final String MSG_INVALID_VALUE_LOWER_THAN_ZERO = "Valor inválido, debe ser mayor a 0";

    // Fuentes
    public static final String FONT_ANDALE_MONO = "Andale Mono";

    // Imágenes y recursos
    public static final String ICONO = "/src/main/resources/icon.png";
    public static final String LOGO = "src/main/resources/logo-conversor.png";
    public static final String LOGO_ALURA = "src/main/resources/alura.png";

    // Constantes para la interfaz gráfica de WELCOME
    public static final Color COLOR_BACKGROUND_FRAME = new Color(147, 82, 210);
    public static final Color COLOR_BACKGROUND_SUB_MENU_CURRENCY = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_INPUT_NAME = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_FOOTER = new Color(255, 255, 255);
    public static final Color COLOR_FONT_TEXT_FIELD_NAME = new Color(224, 224, 224);
    public static final Color COLOR_BACKGROUND_TEXT_FIELD_NAME = new Color(50, 50, 255);
    public static final Color COLOR_FONT_BUTTON_ENTER = new Color(0, 0, 255);
    public static final Color COLOR_BACKGROUND_BUTTON_ENTER = new Color(255, 255, 255);

    public static final PositionInFrame POSITION_LABEL_LOGO = new PositionInFrame(25, 15);
    public static final PositionInFrame POSITION_SUB_MENU_CURRENCY = new PositionInFrame(85, 135);
    public static final PositionInFrame POSITION_LABEL_INPUT_NAME = new PositionInFrame(45, 212);
    public static final PositionInFrame POSITION_LABEL_FOOTER = new PositionInFrame(55, 375);
    public static final PositionInFrame POSITION_TEXT_FIELD_NAME = new PositionInFrame(45, 240);
    public static final PositionInFrame POSITION_BUTTON_ENTER = new PositionInFrame(125, 280);

    public static final DimensionInFrame DIMENSION_LABEL_LOGO = new DimensionInFrame(300, 100);
    public static final DimensionInFrame DIMENSION_SUB_MENU_CURRENCY = new DimensionInFrame(300, 30);
    public static final DimensionInFrame DIMENSION_LABEL_INPUT_NAME = new DimensionInFrame(200, 30);
    public static final DimensionInFrame DIMENSION_LABEL_FOOTER = new DimensionInFrame(300, 30);
    public static final DimensionInFrame DIMENSION_TEXT_FIELD_NAME  = new DimensionInFrame(255, 25);
    public static final DimensionInFrame DIMENSION_BUTTON_ENTER  = new DimensionInFrame(100, 30);

    public static final FontType FONT_SUB_MENU_CURRENCY = new FontType(FONT_ANDALE_MONO, 18);
    public static final FontType FONT_LABEL_INPUT_NAME = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_LABEL_FOOTER = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_TEXT_FIELD_NAME = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_BUTTON_ENTER = new FontType(FONT_ANDALE_MONO, 14);

    public static final String MSG_INPUT_NAME = "Debes ingresar tu nombre";
    public static final int COORDENATE_X_LICENSE_WINDOW = 0;
    public static final int COORDENATE_Y_LICENSE_WINDOW = 0;
    public static final int WIDTH_LICENSE_WINDOW = 610;
    public static final int HEIGHT_LICENSE_WINDOW = 380;

    public static final int COORDENATE_X_WELCOME_WINDOW = 0;
    public static final int COORDENATE_Y_WELCOME_WINDOW = 0;
    public static final int WIDTH_WELCOME_WINDOW = 350;
    public static final int HEIGHT_WELCOME_WINDOW = 450;

}
