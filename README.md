# proyecto-conversor-monedas-alura
Proyecto de conversión de monedas y temperaturas correspondiente al Challenge de Alura Latam Oracle-One Next Education que forma parte de su curso Backend

#Fichero .jar incluido, comprimido en winrar, para que puedan ejecutar directamente.
Se ha incluído en el proyecto el fichero .jar para su ejecución directa.
De esta manera podrán hacer pruebas directas sobre la aplicación:
https://github.com/Liriko/proyecto-conversor-monedas-alura/blob/master/proyecto_conversor_monedas_jar.rar

# Paso a paso de la aplicación
  A continuación podrán visualizar el paso a paso de este conversor

  # 01 - Iniciando la aplicación - Bienvenida
  ![Bienvenida](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev01.png)
  
  Nada más iniciar la aplicación se nos presenta la bienvenida al gestor de conversor, donde podremos digitar nuestro nombre, o no, para pasar a la siguiente pantalla.
  
  # 02 - Términos y condiciones - No acepto.
  ![Términos y condiciones - No acepto](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev02.png)
  
  La pantalla siguiente es la pantalla de Términos y condiciones.
  Esta pantalla, por defecto, dejará desmarcado el check "Yo, <nombre>, acepto" y solo tendremos disponible el botón "No acepto" para poder continuar.
  
  # 03 - Términos y condiciones - Acepto
  ![Términos y condiciones - Acepto](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev03.png)
  
  Tras marcar la casilla de "Yo, <nombre>, acepto", se deshabilita el botón "No acepto" y se habilita el botón "Continuar".
  
  # 04 - Conversor de divisas
  ![Conversor de divisas](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev04.png)
  
  Se abre la pantalla principal correspondiente al conversor de divisas. En esta pantalla podremos notar que hay un título que nos da la bienvenida con el mismo nombre que digitamos en la primera pantalla. También se nos expone un menú con varias opciones que iremos revisando poco a poco y varios campos que tendremos que ir completando.

  # 05 - Menú de opciones
  ![Menu de opciones](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev05.png)
  
  Este menú nos presenta los siguientes submenú:
  - Color de fondo
  - Nuevo
  - Salir
  - Limpiar campos
  
  # Submenu Opciones - Color de fondo
  ![Submenu de opciones - Color de fondo](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev06.png)
  
  Este submenu despliega las opciones:
  - Rojo
  - Negro
  - Morado
  
  Esta funcionalidad cambia el color de fondo de la pantalla, como se muestra a continuación:
  
  ![Submenu de opciones - Color de fondo](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev07.png)
  
  ![Submenu de opciones - Color de fondo](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev08.png)
  
  ![Submenu de opciones - Color de fondo](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev09.png)
  
  # Submenus Nuevo, Salir y Limpiar campos
  
  Estos submenú en cuestión, presentan las siguientes funcionalidades:
  - Nuevo - Abre una nueva instancia de la aplicación.
  - Salir - Cierra la aplicación.
  - Limpiar campos - En la misma instancia, limpia todos los campos a su estado inicial por defecto.
  
  # Menu conversores
  ![Submenu de opciones - Conversores](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev10.png)
  
  Este menú despliega las opciones:
  - Conversor de divisas - Abre una nueva instancia del conversor de divisas
  - Conversor de temperaturas - Abre una nueva instancia del conversor de temperaturas
  
  # Menu Sobre mí
  ![Submenu de opciones - Conversores](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev11.png)
  
  El menú Sobre mí solo cuenta con un módulo llamado Autor, y que entrega algunos datos del autor de esta aplicación;
  
  ![Submenu de opciones - Conversores](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev12.png)
  
  # Campos Nombres, Apellido Paterno y Apellido Materno
  ![Submenu de opciones - Conversores](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev13.png)
  
  A la izquierda de la aplicación se encuentran tres campos completables:
  - Nombre
  - Apellido Paterno
  - Apellido Materno
  
  Llenar estos cambios hará que el nombre del usuario de la aplicación se muestre como parte del mensaje de respuesta que entregará la aplicación.
  Estos campos no son obligatorios, por lo que pueden omitirse para esconder la identidad del usuario de la aplicación.
  
  # Campos desplegables
  
  Existen dos campos completables, los cuales se alimentarán dinámicamente dependiendo de si la pantalla es un conversor de divisas o de temperature.
  Para el primer caso, ambos campos se llenarán con las siguientes divisas ordenadas alfabéticamente:
  
  ![Submenu de opciones - Conversor de currency](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev14.png)
  
  - CLP $ - Peso Chileno
  - Eur € - Euro
  - GBP £ - Libra Esterlina
  - JPY ¥ - Yen Japonés
  - KRW ₩ - Won Surcoreano
  - USD $ - Dólar estadounidense
  
  Para el caso del conversor de temperaturas, la lista será la siguiente, ordenada alfabéticamente:
  
  ![Submenu de opciones - Conversor de temperature](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev15.png)
  
  - Celsius
  - Fahrenheit
  - Kelvin
  
  # Campo Valor, = y campo de texto
  
  Finalmente, a la derecha, figura un campo llamado Valor, que posee algunas validaciones y cuyo propósito representa el valor que el usuario desea transformar.
  El botón marcado con un signo igual (=) ejecuta la lógica del cálculo que permite transformar el valor de una currency a otra, o de una temperature a otra.
  El resultado de esta operación se muestra finalmente en el campo de texto que está situado en la zona inferior de la pantalla.
  
  # Validaciones del campo Valor
  Existen 6 reglas de src.main.business en forma de validaciones para el campo Valor.
  
  ![Regla de src.main.business 1 - El campo Valido no permite carácteres, ni puede ser vacío](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev16.png)
  
  1. Regla de src.main.business I - Valor inválido, no se permiten carácteres, ni debe ser vacío.
  Dejar el campo Valor vacío, o bien digitar un caracter alfanumérico puede desencadenar un mensaje de Error alertando esta situación sin permitir progresar con la operación a menos que se modifique la condición que gatilla esta alerta.
  
  ![Regla de src.main.business 2 - Debe seleccionar ambas temperaturas para proceder con el cambio](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev17.png)
  
  2. Regla de src.main.business II - Debe seleccionar ambas temperaturas para proceder con el cambio.
  La siguiente regla de src.main.business solo aplica sobre el conversor de temperaturas, en donde dejar alguno de los campos desplegables de temperaturas queda como - Seleccionar -. Modificar esta condición permitirá avanzar con la operación.
  
  ![Regla de src.main.business 3 - Debe seleccionar ambas divisas para proceder con el cambio](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev18.png)
  
  3. Regla de src.main.business III - Debe seleccionar ambas divisas para proceder con el cambio.
  En contraste, para el conversor de divisas la alerta es similar, gatillada por la misma acción.
  
  ![Regla de src.main.business 4 - Debe seleccionar ambas temperaturas para proceder con el cambio](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev19.png)
  
  4. Regla de src.main.business IV - Las temperaturas no pueden ser iguales. Favor reintentar.
  Otra regla de src.main.business se dispara cuando ambas temperaturas seleccionadas resultan ser la misma, ya que no tiene sentido transformar una temperature, a la misma temperature.
  
  ![Regla de src.main.business 5 - Las divisas no pueden ser iguales. Favor reintentar.](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev19.png)
  
  5. Regla de src.main.business V - Las divisas no pueden ser iguales. Favor reintentar.
  Para el caso del conversor de divisas, la alerta es similar, gatillada por la misma acción.
  
  ![Regla de negocio6 - Valor inválido, debe ser mayor a 0.](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev20.png)
  
  6. Regla de src.main.business VI - Valor inválido, debe ser mayor a 0.
  Finalmente, existe una regla de src.main.business aplicable solo para el gestor de divisas, donde el valor a cambiar debe ser mayor a 0.
  
  # Ejemplo del completado de los campos 
  
  1. Convertor de divisas
  
  ![Ejemplo 1.1](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev21.png)
  
  2. Convertor de temperaturas
  
  ![Ejemplo 1.2](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev23.png)
  
  # Ejemplo del resultado tras presionar el botón '='
  
  1. Convertor de divisas
  
  ![Ejemplo 2.1](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev22.png)
  
  2. Convertor de temperaturas
  
  ![Ejemplo 2.1](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev24.png)
  
  # Estructura del proyecto
  ![Estructura del proyecto](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev25.png)
  
  En la estructura encontramos el proyecto divido en capas. 
  Los packages que representan esta jerarquía son los siguientes:
  
  - constantes (en su interior, la clase abstracta Constantes de la cual se referencian los distintos mensajes de la aplicación).
  - images (las imagenes del proyecto).
  - src.main.interfaces (en su interior la interfaz Front, destinada a la implementación de la parte visual de la aplicación).
  - src.main.model
    - divisas
      - Divisa (clase abstracta)
      - Dólar
      - Euro
      - LibraEsterlina
      - PesoChileno
      - WonSurcoreano
      - YenJapones
    - temperaturas
      - Temperatura (clase abstracta)
      - Celsius
      - Fahrenheit
      - Kelvin
  - src.main.business
    - logica
      - GestorDivisa
      - GestorTemperatura
    - pantalla
      - Bienvenida
      - ConversorDivisas
      - ConversorTemperatura
      - Licencia
  
  # Clases
  ![Detalle clases](https://raw.githubusercontent.com/Liriko/proyecto-conversor-monedas-alura/master/src/main/resources/ev26.png)
  
  Todas las clases, src.main.interfaces, y componentes se encuentran cuidadosamente comentados para el mejor entendimiento de su análisis.
  
  # Diseño
  En cuanto al diseño de esta aplicación; la solución implementada hace uso de la Programación orientada a objetos y sus paradigmas, Abstracción, Encapsulamiento, Herencia y Polimorfismo y adelanta el uso de la Colección HashMap como manipulador de divisas y temperaturas, para lo cuál se implementaron gestores, constantes, validaciones e src.main.interfaces, con el objetivo de desacoplar las distintas capas del proyecto, permitiendo la escalabilidad de la aplicación, asegurando la calidad y rendimiento de la misma.
  
  # Conclusión
  Este proyecto me permitió aplicar los conceptos impartidos en clases. Espero en el futuro poder modificar un poco el diseño para permitir un mantenedor de temperaturas y divisas para que el usuario pueda eliminar e incorporar sus propios elementos. En este minuto, gracias al diseño actual de la aplicación, ésto es posible solo a través de un requerimiento que, tras evaluado, puede constituir una mejora y posterior planificación de desarrollo.
  
  #¡Gracias Alura Latam!
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
