package utilidades;

import java.util.Scanner;

/**
 * Clase que contiene métodos para pedir datos al usuario desde la consola.
 * Permite leer números y textos de forma segura.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class Lector {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Pide al usuario un número entero.
     * Si el usuario escribe algo que no es un número, se le vuelve a pedir.
     *
     * @param mensaje el texto que se muestra para pedir el número
     * @return el número que escribió el usuario
     */
    public static int leerNumero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                numero = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println(Colores.ROJO_BOLD + "Entrada no válida. Intenta otra vez. " + Colores.RESET);
            }
        }
        return numero;
    }

    /**
     * Pide al usuario un número entero dentro de un rango (mínimo y máximo).
     * Si escribe algo que no es número o está fuera de rango, se le vuelve a pedir.
     *
     * @param mensaje el texto que se muestra para pedir el número
     * @param min el valor mínimo permitido
     * @param max el valor máximo permitido
     * @return el número que escribió el usuario, dentro del rango
     */
    public static int leerNumeroEntre(String mensaje, int min, int max) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                numero = Integer.parseInt(entrada);
                if (numero < min || numero > max) {
                    System.out.println(Colores.ROJO_BOLD + "Número fuera de rango. Intenta otra vez. " + Colores.RESET);
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(Colores.ROJO_BOLD + "Entrada no válida. Intenta otra vez. " + Colores.RESET);
            } 
        }
        return numero;
    }

    /**
     * Pide al usuario que escriba un texto que no esté vacío.
     * Si no escribe nada, se le vuelve a pedir.
     *
     * @param mensaje el texto que se muestra para pedir la entrada
     * @return el texto que escribió el usuario, sin estar vacío
     */
    public static String leerCadenaNoVacia(String mensaje) {
        String entrada;
        do {
            System.out.print(mensaje);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println(Colores.ROJO_BOLD + "\nLa entrada no puede estar vacía. Intenta otra vez. " + Colores.RESET);
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    /**
     * Pide al usuario que escriba un texto.
     * Puede devolver un texto vacío si el usuario solo presiona ENTER.
     *
     * @param mensaje el texto que se muestra para pedir la entrada
     * @return el texto que escribió el usuario (puede estar vacío)
     */
    public static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    /**
     * Cierra el lector de datos.
     * Es importante cerrarlo al terminar de usarlo para liberar memoria.
     */
    public static void cerrarScanner() {
        scanner.close();
    }
}
