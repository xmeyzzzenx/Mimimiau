package juego.minijuegos;

import modelo.Partida;
import modelo.gatos.Gato;
import modelo.gatos.GatoMaineCoon;
import modelo.gatos.GatoPersa;
import modelo.gatos.GatoSiames;
import utilidades.Colores;
import utilidades.Lector;

import java.util.Random;

/**
 * Minijuego de cuidar gatos.
 * El jugador debe cumplir una misión cuidando al gato, alimentándolo, jugando o dejándolo dormir.
 * Ganas puntos y monedas si logras cumplir la misión.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class MinijuegoCuidarGatos {

    /** Generador de números aleatorios para seleccionar la misión del gato. */
    private static final Random RANDOM = new Random();

    /**
     * Ejecuta el minijuego completo de cuidar gatos: elegir gato, recibir misión, interactuar y ganar recompensas.
     * @param partida La partida actual en la que se sumarán los puntos y monedas obtenidos.
     */
    public static void jugar(Partida partida) {
        Gato[] gatos = {
            new GatoSiames("Morris"),
            new GatoMaineCoon("Bruchi"),
            new GatoPersa("Kitty")
        };

        mostrarIntroduccion();
        mostrarMenuGatos(gatos);

        int eleccion = Lector.leerNumeroEntre(Colores.AMARILLO_BOLD + "Selecciona un gato para cuidar: " + Colores.RESET, 1, gatos.length);
        Gato gato = gatos[eleccion - 1];

        int mision = RANDOM.nextInt(3);
        int metaHambre = 0;
        int metaFelicidad = 0;
        int metaEnergia = 0;
        String descripcionMision = "";

        switch (mision) {
            case 0 -> {
                metaHambre = 20;
                metaFelicidad = 70;
                descripcionMision = "Dejar el hambre en 20 y la felicidad en 70.";
            }
            case 1 -> {
                metaHambre = 10;
                metaFelicidad = 80;
                descripcionMision = "Dejar el hambre en 10 y la felicidad en 80.";
            }
            case 2 -> {
                metaFelicidad = 90;
                metaEnergia = 60;
                descripcionMision = "Dejar la felicidad en 90 y la energía en 60.";
            }
        }

        System.out.println(Colores.AMARILLO_BOLD + "\nTU MISIÓN ESSSSS: " + Colores.RESET + Colores.BLANCO_BOLD + descripcionMision + Colores.RESET);

        boolean cumplida = gestionarCuidado(gato, mision, metaHambre, metaFelicidad, metaEnergia);

        if (cumplida) {
            partida.sumarPuntos(20);
            partida.sumarMonedas(10);
            mostrarResumen(gato, partida);
        } else {
            System.out.println(Colores.ROJO_BOLD + "\nNo cumpliste la misión. ¡Será la próxima vez!" + Colores.RESET);
        }
    }

    /**
     * Controla la interacción de cuidado del gato, mostrando estado y permitiendo elegir acciones.
     * Repite hasta cumplir la misión o decidir salir.
     * @param gato El gato que se está cuidando.
     * @param mision Número de la misión asignada.
     * @param metaHambre Valor objetivo de hambre para la misión.
     * @param metaFelicidad Valor objetivo de felicidad para la misión.
     * @param metaEnergia Valor objetivo de energía para la misión.
     * @return true si se cumplió la misión, false si el jugador decidió salir antes.
     */
    public static boolean gestionarCuidado(Gato gato, int mision, int metaHambre, int metaFelicidad, int metaEnergia) {
        boolean misionCumplida = false;
        boolean salir = false;

        do {
            System.out.println(Colores.MORADO_BOLD);
            System.out.println("\n================================================================================");
            System.out.println("                  CUIDANDO A " + gato.getNombre().toUpperCase() + ":" + " ESTADO ACTUAL");
            System.out.println("================================================================================");
            System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
            System.out.println(gato);
            System.out.println(Colores.RESET);

            mostrarMenuAcciones();
            int opcion = Lector.leerNumeroEntre(Colores.AMARILLO_BOLD + "Elige una acción: " + Colores.RESET, 1, 4);

            switch (opcion) {
                case 1 -> {
                    gato.comer();
                    System.out.println(Colores.CYAN_BOLD + gato.getNombre() + " ha comido." + Colores.RESET);
                }
                case 2 -> {
                    gato.jugar();
                    System.out.println(Colores.CYAN_BOLD + gato.getNombre() + " ha jugado." + Colores.RESET);
                }
                case 3 -> {
                    gato.dormir();
                    System.out.println(Colores.CYAN_BOLD + gato.getNombre() + " ha dormido." + Colores.RESET);
                }
                case 4 -> {
                    System.out.println(Colores.AMARILLO_BOLD + "\nFinalizando cuidado..." + Colores.RESET);
                    salir = true;
                }
                default -> System.out.println(Colores.ROJO_BOLD + "Opción inválida. Intente nuevamente." + Colores.RESET);
            }

            if ((mision == 0 && gato.getHambre() == metaHambre && gato.getFelicidad() == metaFelicidad)
             || (mision == 1 && gato.getHambre() == metaHambre && gato.getFelicidad() == metaFelicidad)
             || (mision == 2 && gato.getFelicidad() == metaFelicidad && gato.getEnergia() == metaEnergia)) {
                misionCumplida = true;
            }

        } while (!misionCumplida && !salir);

        return misionCumplida;
    }

    /**
     * Muestra la introducción del minijuego explicando las reglas básicas al jugador.
     */
    public static void mostrarIntroduccion() {
        System.out.println(Colores.MORADO_BOLD);
        System.out.println("\n================================================================================");
        System.out.println("                        BIENVENIDO AL MINIJUEGO: CUIDAR GATOS");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println(" En este minijuego, tendrás que cuidar a un gato y cumplir con una misión.");
        System.out.println(" Puedes alimentarlo, jugar con él o dejarlo dormir para mantener su felicidad y energía.");
        System.out.println(" Tu objetivo es cumplir con los requisitos de cada misión para ganar puntos y monedas.");
        System.out.println();
        System.out.println(" CONSEJO: Presta atención a las necesidades de tu gato para completar la misión.");
        System.out.println();
        System.out.println(" IMPORTANTE: Si deseas salir, elige la opción para terminar el cuidado en cualquier momento.");
        System.out.println(Colores.RESET + Colores.MORADO_BOLD);
        System.out.println("================================================================================");
        System.out.println(Colores.RESET);
        Lector.leerCadena(Colores.AMARILLO_BOLD + "\nPresiona ENTER para comenzar..." + Colores.RESET);
    }

    /**
     * Muestra el menú de gatos disponibles para elegir cuál cuidar.
     * @param gatos Array de gatos disponibles.
     */
    public static void mostrarMenuGatos(Gato[] gatos) {
        System.out.println(Colores.MORADO_BOLD);
        System.out.println("\n================================================================================");
        System.out.println("                            NUESTROS GATITOS");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        for (int i = 0; i < gatos.length; i++) {
            System.out.println((i + 1) + ". " + gatos[i].getNombre());
        }
        System.out.println(Colores.RESET);
    }

    /**
     * Muestra el menú de acciones que el jugador puede realizar con el gato.
     */
    public static void mostrarMenuAcciones() {
        System.out.println(Colores.MORADO_BOLD);
        System.out.println("\n================================================================================");
        System.out.println("                             MENÚ DE ACCIONES");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println("1. Comer");
        System.out.println("2. Jugar");
        System.out.println("3. Dormir");
        System.out.println("4. Terminar cuidado");
        System.out.println(Colores.RESET);
    }

    /**
     * Muestra el resumen final del minijuego: gato cuidado, puntos y monedas obtenidos.
     * @param gato Gato que fue cuidado.
     * @param partida La partida donde se registraron los puntos y monedas.
     */
    public static void mostrarResumen(Gato gato, Partida partida) {
        System.out.println(Colores.VERDE_BOLD);
        System.out.println("\n================================================================================");
        System.out.println("                          RESUMEN DEL MINIJUEGO");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println("\u00a1Misión cumplida! Ganaste +20 puntos y +10 monedas.");
        System.out.println("Gato cuidado     : " + gato.getNombre());
        System.out.println("Puntos ganados   : " + partida.getPuntos() + " pts");
        System.out.println("Monedas ganadas  : " + partida.getMonedas() + " monedas");
        System.out.println(Colores.RESET);
    }
}
