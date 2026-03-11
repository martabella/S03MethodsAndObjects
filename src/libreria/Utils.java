package libreria;

import model.Genero;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Utils {
    /**
     * Solicita al usuario la introducción de un número entero por consola,
     * mostrando un mensaje personalizado y validando que el valor esté
     * dentro de un rango específico.
     *
     * <p>El método seguirá solicitando la entrada hasta que el usuario
     * introduzca un número entero válido y comprendido entre los valores
     * mínimo y máximo indicados (ambos incluidos).</p>
     *
     * @param mensaje el texto que se mostrará al usuario para solicitar el número
     * @param minEntero el valor mínimo permitido (incluido)
     * @param maxEntero el valor máximo permitido (incluido)
     * @return el número entero introducido por el usuario que cumple
     *         las condiciones de validación
     */
    public static int leerEnteroConsola(String mensaje, int minEntero, int maxEntero){
        Scanner input = new Scanner(System.in);
        int lectura=0;
        boolean exit = false;
        do {
            System.out.println(mensaje);
            if (input.hasNextInt()) {
                lectura = input.nextInt();
                input.nextLine();
                if (lectura >= minEntero && lectura <= maxEntero) {
                    exit = true;
                } else {
                    System.out.println("Error. Debes introducir un entero dentro del rango " + minEntero + " ,  " + maxEntero);
                }
            } else {
                System.out.println("Error. Debes introducir un entero");
                input.nextLine();
            }
        }while(!exit);
        return lectura;
    }

    /**
     * Solicita al usuario la introducción de un número float por consola,
     * mostrando un mensaje personalizado y validando que el valor esté
     * dentro de un rango específico.
     *
     * <p>El método seguirá solicitando la entrada hasta que el usuario
     * introduzca un número comprendido entre los valores
     * mínimo y máximo indicados (ambos incluidos).</p>
     *
     * @param mensaje texto que se muestra por consola para pedir el valor float
     * @param valueMin valor mínimo float aceptado
     * @param valueMax valor máximo float aceptado
     * @return valor float comprendido entre valueMin y valueMax
     */
    public static float leerFloatConsole(String mensaje, float valueMin, float valueMax){
        Scanner input= new Scanner(System.in);
        float value = 0;
        boolean exit = false;
        do{
            System.out.println(mensaje);
            if (input.hasNextFloat()){
                value = input.nextFloat();
                input.nextLine();
                if (value>=valueMin&&value<=valueMax){
                    exit = true;
                }
            }else{
                System.out.println("Error. Debes introducir un valor numerico");
                input.nextLine();
            }
        }while(!exit);
        return value;
    }

    /**
     * Solicita al usuario la introducción de una cadena de texto por consola,
     * mostrando un mensaje personalizado.
     *
     * <p>El método seguirá solicitando la entrada hasta que el usuario
     * introduzca una cadena de texto.</p>
     *
     * @param mensaje texto que se muestra por consola para pedir el valor String
     * @return String que contenga caracteres
     */
    public static String leerStringConsole(String mensaje){
        Scanner input = new Scanner(System.in);
        String texto;
        do {
            System.out.println(mensaje);
            texto = input.nextLine();
        }while(texto.isBlank());
        return texto;
    }

    /**
     * Solicita una confirmación al usuario (Sí/No).
     * * @param mensaje El texto de la pregunta (ej: "¿Desea continuar?")
     * @return true si el usuario responde 's' o 'si', false si responde 'n' o 'no'
     */
    public static boolean leerBooleanConsole(String mensaje) {
        Scanner input = new Scanner(System.in);
        String respuesta;
        boolean valido = false;
        boolean resultado = false;

        do {
            System.out.print(mensaje + " [S/N]: ");
            respuesta = input.nextLine().trim().toLowerCase(); // Normalizamos la entrada

            if (respuesta.equals("s") || respuesta.equals("si")) {
                resultado = true;
                valido = true;
            } else if (respuesta.equals("n") || respuesta.equals("no")) {
                resultado = false;
                valido = true;
            } else {
                System.out.println("Error: Por favor, responde 'S' para Sí o 'N' para No.");
            }
        } while (!valido);

        return resultado;
    }

    /**
     * Solicita al usuario una fecha válida pidiendo día, mes y año.
     * Valida meses de 30/31 días y años bisiestos.
     * * @param mensaje Texto explicativo inicial.
     * @return Un objeto LocalDate con la fecha validada.
     */
    public static LocalDate leerFechaConsole(String mensaje) {
        Scanner input = new Scanner(System.in);
        int dia, mes, anio;
        LocalDate fecha = null;
        boolean valido = false;

        System.out.println(mensaje);
        do {
            anio = leerEnteroConsola("Introduce el año", 1900, 2100);
            mes = leerEnteroConsola("Introduce el mes", 1, 12);

            // El día depende del mes y el año, pero luego lo validamos con un try-catch
            dia = leerEnteroConsola("Introduce el día", 1, 31);

            try {
                // Intentamos crear la fecha. Si el día no cuadra con el mes o el año, lanzará una excepción.
                fecha = LocalDate.of(anio, mes, dia);
                valido = true;
            } catch (DateTimeException e) {
                System.out.println("Error: La fecha introducida no existe (ej: 30 de febrero). Inténtalo de nuevo.");
            }
        } while (!valido);

        return fecha;
    }

    /**
     * Muestra las opciones del enum model.Genero y permite al usuario seleccionar una.
     * * @param mensaje Texto que precede a la lista de opciones.
     * @return El valor del Enum model.Genero seleccionado.
     */
    public static Genero leerEnumGenero(String mensaje) {
        // Obtenemos todos los valores posibles del enum en un array
        Genero[] opciones = Genero.values();
        int eleccion;

        System.out.println(mensaje);

        // Mostramos opciones
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        eleccion = leerEnteroConsola("Seleccione una opción", 1, opciones.length);

        // Devolvemos el valor correspondiente (restando 1 por el índice del array)
        return opciones[eleccion - 1];
    }
}