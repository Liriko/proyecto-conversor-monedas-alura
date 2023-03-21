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
    public static final String LABEL_TO_CHANGE_TO = "A";
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
    public static final String ICON = "/src/main/resources/icon.png";
    public static final String LOGO = "src/main/resources/logo-conversor.png";
    public static final String LOGO_ALURA = "src/main/resources/alura.png";

    // Constantes para la interfaz gráfica de WELCOME
    public static final Color COLOR_BACKGROUND_FRAME = new Color(147, 82, 210);
    public static final Color COLOR_BACKGROUND_SUB_MENU_CURRENCY = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_INPUT_NAME = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_FOOTER = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_BUTTON_ENTER = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_TEXT_FIELD_NAME = new Color(50, 50, 255);

    public static final Color COLOR_FONT_BUTTON_ENTER = new Color(0, 0, 255);
    public static final Color COLOR_FONT_TEXT_FIELD_NAME = new Color(224, 224, 224);

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

    public static final int WIDTH_LICENSE_WINDOW_OPT = 600;
    public static final int HEIGHT_LICENSE_WINDOW_OPT = 360;

    public static final int COORDENATE_X_WELCOME_WINDOW = 0;
    public static final int COORDENATE_Y_WELCOME_WINDOW = 0;
    public static final int WIDTH_WELCOME_WINDOW = 350;
    public static final int HEIGHT_WELCOME_WINDOW = 450;

    public static final int COORDENATE_X_TEMPERATURE_WINDOW = 0;
    public static final int COORDENATE_Y_TEMPERATURE_WINDOW = 0;
    public static final int WIDTH_TEMPERATURE_WINDOW = 640;
    public static final int HEIGHT_TEMPERATURE_WINDOW = 535;

    public static final int COORDENATE_X_CURRENCY_WINDOW = 0;
    public static final int COORDENATE_Y_CURRENCY_WINDOW = 0;
    public static final int WIDTH_CURRENCY_WINDOW = 640;
    public static final int HEIGHT_CURRENCY_WINDOW = 535;

    // Constantes para la interfaz gráfica de Currency Y Temperature Converters

    public static final Color COLOR_FONT_MENU_OPTIONS = new Color(255, 255, 255);
    public static final Color COLOR_FONT_MENU_CONVERTERS = new Color(255, 255, 255);
    public static final Color COLOR_FONT_MENU_ABOUT_ME = new Color(255, 255, 255);
    public static final Color COLOR_FONT_MENU_ITEM_BACKGROUND_COLOR = new Color(255, 0, 0);
    public static final Color COLOR_FONT_SUB_MENU_RED_BACKGROUND = new Color(255, 0, 0);
    public static final Color COLOR_FONT_SUB_MENU_BLACK_BACKGROUND = new Color(255, 0, 0);
    public static final Color COLOR_FONT_SUB_MENU_PURPLE_BACKGROUND = new Color(255, 0, 0);
    public static final Color COLOR_FONT_SUB_MENU_NEW = new Color(255, 0, 0);
    public static final Color COLOR_FONT_SUB_MENU_AUTHOR = new Color(255, 0, 0);
    public static final Color COLOR_FONT_SUB_MENU_EXIT = new Color(255, 0, 0);
    public static final Color COLOR_FONT_SUB_MENU_LIMPIAR_CAMPOS = new Color(255, 0, 0);
    public static final Color COLOR_FONT_TEXTFIELD_NAME = new Color(255, 0, 0);
    public static final Color COLOR_FONT_TEXTFIELD_VALUE = new Color(255, 0, 0);
    public static final Color COLOR_FONT_TEXTFIELD_LASTNAME = new Color(255, 0, 0);
    public static final Color COLOR_FONT_TEXTFIELD_SURNAME = new Color(255, 0, 0);
    public static final Color COLOR_FONT_BUTTON_CALCULATE = new Color(0, 0, 0);
    public static final Color COLOR_FONT_COMBOBOX_CONVERTER = new Color(224, 224, 224);
    public static final Color COLOR_FONT_COMBOBOX_CONVERTER_PAIR = new Color(224, 224, 224);
    public static final Color COLOR_FONT_TEXT_FIELD_CURRENCY_RESULT = new Color(225, 0, 0);

    public static final Color COLOR_BACKGROUND_MENU_BAR = new Color(147, 82, 210);
    public static final Color COLOR_BACKGROUND_MENU_OPTIONS = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_MENU_CONVERTERS = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_MENU_ABOUT_ME = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_MENU_ITEM_BACKGROUND_COLOR = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_MENU_ITEM_CURRENCY_CONVERTER = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_MENU_ITEM_TEMPERATURE_CONVERTER = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_LABEL_VALUE = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_TITLE = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_SUBTITLE = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_NAME = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_LASTNAME = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_SURNAME = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_TO_CHANGE_FROM = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_TO_CHANGE_TO = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_TEXT_FIELD_CALCULATION_RESULT = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_LABEL_CONVERTER_FOOTER = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND_TEXTFIELD_NAME = new Color(224, 224, 224);
    public static final Color COLOR_BACKGROUND_TEXTFIELD_VALUE = new Color(224, 224, 224);
    public static final Color COLOR_BACKGROUND_TEXTFIELD_LASTNAME = new Color(224, 224, 224);
    public static final Color COLOR_BACKGROUND_TEXTFIELD_SURNAME = new Color(224, 224, 224);
    public static final Color COLOR_BACKGROUND_BUTTON_CALCULATE = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_COMBOBOX_CONVERTER = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_COMBOBOX_CONVERTER_PAIR = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_TEXT_FIELD_CURRENCY_RESULT = new Color(224, 224, 224);
    public static final Color COLOR_BACKGROUND_PURPLE = new Color(51, 0, 51);
    public static final Color COLOR_BACKGROUND_RED = new Color(255, 0, 0);
    public static final Color COLOR_BACKGROUND_BLACK = new Color(0, 0, 0);

    public static final FontType FONT_MENU_OPTIONS = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_MENU_CONVERTERS = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_MENU_ABOUT_ME = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_MENU_ITEM_BACKGROUND_COLOR = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_MENU_ITEM_CURRENCY_CONVERTER = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_MENU_ITEM_TEMPERATURE_CONVERTER = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_SUB_MENU_RED_BACKGROUND = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_SUB_MENU_BLACK_BACKGROUND = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_SUB_MENU_PURPLE_BACKGROUND = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_SUB_MENU_NEW = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_SUB_MENU_AUTHOR = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_SUB_MENU_EXIT = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_SUB_MENU_LIMPIAR_CAMPOS = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_LABEL_VALUE = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_LABEL_TITLE = new FontType(FONT_ANDALE_MONO, 32);
    public static final FontType FONT_LABEL_SUBTITLE = new FontType(FONT_ANDALE_MONO, 24);
    public static final FontType FONT_LABEL_NAME = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_LABEL_LASTNAME = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_LABEL_SURNAME = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_LABEL_TO_CHANGE_FROM = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_LABEL_TO_CHANGE_TO = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_TEXT_FIELD_CALCULATION_RESULT = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_LABEL_CONVERTER_FOOTER = new FontType(FONT_ANDALE_MONO, 12);
    public static final FontType FONT_TEXTFIELD_NAME = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_TEXTFIELD_VALUE = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_TEXTFIELD_LASTNAME = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_TEXTFIELD_SURNAME = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_BUTTON_CALCULATE = new FontType(FONT_ANDALE_MONO, 20);
    public static final FontType FONT_COMBOBOX_CONVERTER = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_COMBOBOX_CONVERTER_PAIR = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_TEXT_FIELD_CURRENCY_RESULT = new FontType(FONT_ANDALE_MONO, 11);

    public static final DimensionInFrame DIMENSION_LOGO = new DimensionInFrame(250, 140);
    public static final DimensionInFrame DIMENSION_LABEL_VALUE = new DimensionInFrame(180, 25);
    public static final DimensionInFrame DIMENSION_LABEL_TITLE = new DimensionInFrame(300, 50);
    public static final DimensionInFrame DIMENSION_LABEL_SUBTITLE = new DimensionInFrame(900, 25);
    public static final DimensionInFrame DIMENSION_LABEL_NAME = new DimensionInFrame(180, 25);
    public static final DimensionInFrame DIMENSION_LABEL_LASTNAME = new DimensionInFrame(180, 25);
    public static final DimensionInFrame DIMENSION_LABEL_SURNAME = new DimensionInFrame(180, 25);
    public static final DimensionInFrame DIMENSION_LABEL_TO_CHANGE_FROM = new DimensionInFrame(180, 25);
    public static final DimensionInFrame DIMENSION_LABEL_TO_CHANGE_TO = new DimensionInFrame(180, 25);
    public static final DimensionInFrame DIMENSION_TEXT_FIELD_CALCULATION_RESULT = new DimensionInFrame(180, 25);
    public static final DimensionInFrame DIMENSION_LABEL_CONVERTER_FOOTER = new DimensionInFrame(500, 30);
    public static final DimensionInFrame DIMENSION_TEXTFIELD_NAME = new DimensionInFrame(150, 25);
    public static final DimensionInFrame DIMENSION_TEXTFIELD_VALUE = new DimensionInFrame(125, 25);
    public static final DimensionInFrame DIMENSION_TEXTFIELD_LASTNAME = new DimensionInFrame(150, 25);
    public static final DimensionInFrame DIMENSION_TEXTFIELD_SURNAME = new DimensionInFrame(150, 25);
    public static final DimensionInFrame DIMENSION_BUTTON_CALCULATE = new DimensionInFrame(125, 45);
    public static final DimensionInFrame DIMENSION_COMBOBOX_CONVERTER = new DimensionInFrame(220, 25);
    public static final DimensionInFrame DIMENSION_COMBOBOX_CONVERTER_PAIR = new DimensionInFrame(220, 25);
    public static final DimensionInFrame DIMENSION_SCROLL_PANE = new DimensionInFrame(386, 90);

    public static final PositionInFrame POSITION_LOGO = new PositionInFrame(5, 5);
    public static final PositionInFrame POSITION_LABEL_VALUE = new PositionInFrame(480, 188);
    public static final PositionInFrame POSITION_LABEL_TITLE = new PositionInFrame(280, 30);
    public static final PositionInFrame POSITION_LABEL_SUBTITLE = new PositionInFrame(45, 140);
    public static final PositionInFrame POSITION_LABEL_NAME = new PositionInFrame(25, 188);
    public static final PositionInFrame POSITION_LABEL_LASTNAME = new PositionInFrame(25, 248);
    public static final PositionInFrame POSITION_LABEL_SURNAME = new PositionInFrame(25, 308);
    public static final PositionInFrame POSITION_LABEL_TO_CHANGE_FROM = new PositionInFrame(220, 188);
    public static final PositionInFrame POSITION_LABEL_TO_CHANGE_TO = new PositionInFrame(220, 248);
    public static final PositionInFrame POSITION_TEXT_FIELD_CALCULATION_RESULT = new PositionInFrame(220, 307);
    public static final PositionInFrame POSITION_LABEL_CONVERTER_FOOTER = new PositionInFrame(195, 445);
    public static final PositionInFrame POSITION_TEXTFIELD_NAME = new PositionInFrame(25, 213);
    public static final PositionInFrame POSITION_TEXTFIELD_VALUE = new PositionInFrame(480, 213);
    public static final PositionInFrame POSITION_TEXTFIELD_LASTNAME = new PositionInFrame(25, 273);
    public static final PositionInFrame POSITION_TEXTFIELD_SURNAME = new PositionInFrame(25, 334);
    public static final PositionInFrame POSITION_BUTTON_CALCULATE = new PositionInFrame(480, 258);
    public static final PositionInFrame POSITION_COMBOBOX_CONVERTER = new PositionInFrame(220, 213);
    public static final PositionInFrame POSITION_COMBOBOX_CONVERTER_PAIR = new PositionInFrame(220, 273);
    public static final PositionInFrame POSITION_SCROLL_PANE = new PositionInFrame(220, 333);

    public static final String ABSOLUTE_ZERO_ERROR_MSG = "Favor vuelva a intentarlo";

    // Constantes para la interfaz gráfica de LICENSE
    public static final Color COLOR_BACKGROUND_LICENSE_FRAME = new Color(0, 0, 0);
    public static final Color COLOR_BACKGROUND_LICENSE_TEXTFIELD = new Color(0, 0, 0);
    public static final Color COLOR_BACKGROUND_LICENSE_DETAIL = new Color(0, 0, 0);
    public static final Color COLOR_BACKGROUND_BUTTON_CONTINUE = new Color(0, 0, 0);
    public static final Color COLOR_BACKGROUND_BUTTON_DECLINE = new Color(0, 0, 0);

    public static final Color COLOR_FONT_LICENSE_DETAIL = new Color(0, 0, 0);
    public static final Color COLOR_FONT_BUTTON_CONTINUE = new Color(0, 0, 0);
    public static final Color COLOR_FONT_BUTTON_DECLINE = new Color(0, 0, 0);

    public static final FontType FONT_LICENSE_TEXTFIELD = new FontType(FONT_ANDALE_MONO, 14);
    public static final FontType FONT_LICENSE_DETAIL = new FontType(FONT_ANDALE_MONO, 9);
    public static final FontType FONT_BUTTON_CONTINUE = new FontType(null, 0);
    public static final FontType FONT_BUTTON_DECLINE = new FontType(null, 0);

    public static final PositionInFrame POSITION_LICENSE_TEXTFIELD = new PositionInFrame(215, 5);
    public static final PositionInFrame POSITION_LICENSE_SCROLL_PANE = new PositionInFrame(10, 40);
    public static final PositionInFrame POSITION_LICENSE_CHECKBOX_I_ACCEPT = new PositionInFrame(10, 250);
    public static final PositionInFrame POSITION_LICENSE_BUTTON_CONTINUE = new PositionInFrame(10, 290);
    public static final PositionInFrame POSITION_LICENSE_BUTTON_DECLINE = new PositionInFrame(120, 290);
    public static final PositionInFrame POSITION_LICENSE_LOGO_ALURA = new PositionInFrame(300, 225);

    public static final DimensionInFrame DIMENSION_LICENSE_TEXTFIELD = new DimensionInFrame(200, 30);
    public static final DimensionInFrame DIMENSION_LICENSE_SCROLL_PANE = new DimensionInFrame(575, 200);
    public static final DimensionInFrame DIMENSION_LICENSE_CHECKBOX_I_ACCEPT = new DimensionInFrame(300, 30);
    public static final DimensionInFrame DIMENSION_LICENSE_BUTTON_CONTINUE = new DimensionInFrame(100, 30);
    public static final DimensionInFrame DIMENSION_LICENSE_BUTTON_DECLINE = new DimensionInFrame(100, 30);
    public static final DimensionInFrame DIMENSION_LICENSE_LOGO_ALURA = new DimensionInFrame(300, 120);

}
