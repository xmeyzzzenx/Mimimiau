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
 * El jugador debe cumplir una misión interactuando con un gato,
 * eligiendo acciones para modificar sus estados y alcanzar ciertos objetivos.
 */
public class MinijuegoCuidarGatos {

    private static final Random RANDOM = new Random();

    /**
     * Inicia el minijuego de cuidar gatos.
     * El jugador elige un gato, recibe una misión aleatoria y realiza acciones para completarla.
     * Si cumple los objetivos, gana puntos y monedas.
     *
     * @param partida La partida actual del jugador, donde se acumulan puntos y monedas.
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
            case 0:
                metaHambre = 20;
                metaFelicidad = 70;
                descripcionMision = "Dejar el hambre en 20 y la felicidad en 70.";
                break;
            case 1:
                metaHambre = 10;
                metaFelicidad = 80;
                descripcionMision = "Dejar el hambre en 10 y la felicidad en 80.";
                break;
            case 2:
                metaFelicidad = 90;
                metaEnergia = 60;
                descripcionMision = "Dejar la felicidad en 90 y la energía en 60.";
                break;
        }

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

            System.out.println(Colores.AMARILLO_BOLD + "\nTU MISIÓN ESSSSS: " + Colores.RESET + Colores.BLANCO_BOLD + descripcionMision + Colores.RESET);

            mostrarMenuAcciones();
            int opcion = Lector.leerNumeroEntre(Colores.AMARILLO_BOLD + "Elige una acción: " + Colores.RESET, 1, 4);

            switch (opcion) {
                case 1:
                    gato.comer();
                    System.out.println(Colores.CYAN_BOLD + gato.getNombre() + " ha comido." + Colores.RESET);
                    break;
                case 2:
                    gato.jugar();
                    System.out.println(Colores.CYAN_BOLD + gato.getNombre() + " ha jugado." + Colores.RESET);
                    break;
                case 3:
                    gato.dormir();
                    System.out.println(Colores.CYAN_BOLD + gato.getNombre() + " ha dormido." + Colores.RESET);
                    break;
                case 4:
                    System.out.println(Colores.AMARILLO_BOLD + "\nFinalizando cuidado..." + Colores.RESET);
                    salir = true;
                    break;
                default:
                    System.out.println(Colores.ROJO_BOLD + "Opción inválida. Intente nuevamente." + Colores.RESET);
                    break;
            }

            if ((mision == 0 && gato.getHambre() == metaHambre && gato.getFelicidad() == metaFelicidad)
             || (mision == 1 && gato.getHambre() == metaHambre && gato.getFelicidad() == metaFelicidad)
             || (mision == 2 && gato.getFelicidad() == metaFelicidad && gato.getEnergia() == metaEnergia)) {
                misionCumplida = true;
            }

        } while (!misionCumplida && !salir);

        if (misionCumplida) {
            partida.sumarPuntos(20);
            partida.sumarMonedas(10);
            mostrarResumen(gato, partida);
        } else {
            System.out.println(Colores.ROJO_BOLD + "\nNo cumpliste la misión. ¡Será la próxima vez!" + Colores.RESET);
        }
    }

    /**
     * Muestra una introducción narrativa al minijuego con recomendaciones para el jugador.
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
     * Muestra un menú con los nombres de los gatos disponibles para elegir.
     *
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
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Comer");
        System.out.println("2. Jugar");
        System.out.println("3. Dormir");
        System.out.println("4. Terminar cuidado");
        System.out.println(Colores.RESET);
    }

    /**
     * Muestra un resumen final del minijuego con los resultados obtenidos.
     *
     * @param gato    El gato que fue cuidado durante la partida.
     * @param partida La partida actual con los puntos y monedas actualizados.
     */
    public static void mostrarResumen(Gato gato, Partida partida) {
        System.out.println(Colores.VERDE_BOLD);
        System.out.println("\n================================================================================");
        System.out.println("                          RESUMEN DEL MINIJUEGO");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println("¡Misión cumplida! Ganaste +20 puntos y +10 monedas.");
        System.out.println("Gato cuidado     : " + gato.getNombre());
        System.out.println("Puntos ganados   : " + partida.getPuntos() + " pts");
        System.out.println("Monedas ganadas  : " + partida.getMonedas() + " monedas");
        System.out.println(Colores.RESET);
    }
}
