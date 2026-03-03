import java.util.Random;
import java.util.Scanner;

public class ChallengeMethods {
    public static void main(String[] args) {
        ChallengeMethods programa = new ChallengeMethods();
        programa.inicio();
    }

    public void inicio(){
        int menu;
        do {
            menu = leerEnteroConsola("✨ ¡Bienvenido al juego del Número Mágico! ✨ \n[1] Jugar \n[2] Salir", 1, 2);
            switch (menu) {
                case 1:
                    jugar();
                    break;
                case 2:
                    System.out.println("Terminando el programa");
                    break;
            }
        }while(menu!=2);

    }

    /**
     * Ejecuta una partida del juego del Número Mágico.
     *
     * <p>El método realiza los siguientes pasos:</p>
     * <ol>
     *     <li>Solicita al usuario un valor mínimo.</li>
     *     <li>Solicita un valor máximo mayor que el mínimo.</li>
     *     <li>Genera un número mágico aleatorio dentro del rango indicado.</li>
     *     <li>Pide al usuario que intente adivinar el número mágico.</li>
     *     <li>Muestra un mensaje indicando si ha ganado o perdido.</li>
     * </ol>
     *
     * <p>La validación de los valores introducidos se realiza mediante el
     * método {@code leerEnteroConsola}, garantizando que los números estén
     * dentro de los rangos permitidos.</p>
     */
    public void jugar(){
        int minNumber, maxNumber, magicNumber, userNumber;
        minNumber = leerEnteroConsola("Primero, dime el valor mínimo: ", Integer.MIN_VALUE,Integer.MAX_VALUE);
        maxNumber = leerEnteroConsola("Ahora, dime el valor máximo:", minNumber+1, Integer.MAX_VALUE);
        magicNumber = calcularEnteroAleatorio(minNumber, maxNumber);
        userNumber = leerEnteroConsola("¿Cuál crees que es? Introduce tu número mágico", minNumber, maxNumber);
        System.out.println(decidirVictoriaDerrota(userNumber, magicNumber));
    }

    /**
     * Determina si el usuario ha acertado el número mágico y devuelve
     * un mensaje indicando victoria o derrota.
     *
     * <p>Si el número introducido por el usuario coincide con el número mágico,
     * el método devuelve un mensaje de éxito. En caso contrario, devuelve
     * un mensaje de derrota indicando cuál era el número secreto.</p>
     *
     * @param user el número introducido por el usuario
     * @param magic el número mágico generado por el sistema
     * @return un mensaje indicando si el usuario ha ganado o perdido
     */
    public String decidirVictoriaDerrota(int user, int magic){
        String result;
        if (user == magic){
            result = "😉Lo has adivionado!";
        }else{
            result = "😔¡Casi! No has tenido suerte. El número secreto era " + magic;
        }
        return result;
    }

    /**
     * Genera y devuelve un número entero aleatorio dentro de un rango específico.
     *
     * <p>El valor generado estará comprendido entre el mínimo y el máximo
     * indicados, ambos inclusive.</p>
     *
     * @param min el valor mínimo del rango (incluido)
     * @param max el valor máximo del rango (incluido)
     * @return un número entero aleatorio entre min y max (incluidos)
     */
    public int calcularEnteroAleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(min, max+1);
    }

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
    public int leerEnteroConsola(String mensaje, int minEntero, int maxEntero){
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
}
