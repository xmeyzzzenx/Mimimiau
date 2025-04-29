package juego;

import basedatos.PartidaBD;
import ficheros.PartidaFichero;
import juego.minijuegos.MinijuegoAtenderClientes;
import juego.minijuegos.MinijuegoCuidarGatos;
import modelo.Jugador;
import modelo.Partida;
import utilidades.Colores;
import utilidades.Lector;

/**
 * Clase principal del juego Mimimiau.
 * Controla la introducción, los menús, las partidas y el historial.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class Juego {

    /**
     * Inicia el juego.
     * Muestra la introducción, pide el nombre y abre el menú principal.
     */
    public void iniciarJuego() {
        mostrarIntroduccion();
        String nombre = Lector.leerCadenaNoVacia(Colores.AMARILLO_BOLD + "¡Bienvenido! Ingresa tu nombre: " + Colores.RESET);
        Jugador jugador = new Jugador(nombre);
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = Lector.leerNumeroEntre(Colores.AMARILLO_BOLD + "Seleccione una opción: " + Colores.RESET, 1, 4);
            switch (opcion) {
                case 1:
                    iniciarMinijuegos(jugador);
                    break;
                case 2:
                    mostrarInstrucciones();
                    break;
                case 3:
                    mostrarHistorial();
                    break;
                case 4:
                    System.out.println(Colores.AMARILLO_BOLD + "\nGracias por jugar a Mimimiau. ¡Hasta pronto!" + Colores.RESET);
                    break;
                default:
                    System.out.println(Colores.ROJO_BOLD + "\nOpción no válida. Intente nuevamente." + Colores.RESET);
                    break;
            }
        } while (opcion != 4);
    }

    /**
     * Muestra la introducción del juego.
     * Explica al jugador de qué trata Mimimiau.
     */
    public void mostrarIntroduccion() {
        System.out.println(Colores.MORADO_BOLD);
        System.out.println("███    ███ ██ ███    ███ ██ ███    ███ ██  █████  ██    ██");
        System.out.println("████  ████ ██ ████  ████ ██ ████  ████ ██ ██   ██ ██    ██");
        System.out.println("██ ████ ██ ██ ██ ████ ██ ██ ██ ████ ██ ██ ███████ ██    ██");
        System.out.println("██  ██  ██ ██ ██  ██  ██ ██ ██  ██  ██ ██ ██   ██ ██    ██");
        System.out.println("██      ██ ██ ██      ██ ██ ██      ██ ██ ██   ██  ██████");
        System.out.println(Colores.RESET + Colores.CYAN_BOLD);
        System.out.println("Bienvenido a Mimimiau, tu nueva cafetería felina.");
        System.out.println("Aquí no solo prepararás bebidas, también cuidarás de tus adorables gatos.");
        System.out.println("Haz que cada día cuente para ti, tus clientes y tus mininos.");
        System.out.println(Colores.RESET);
    }

    /**
     * Muestra el menú principal del juego.
     * Permite al jugador elegir entre jugar, ver instrucciones o salir.
     */
    public void mostrarMenuPrincipal() {
        System.out.println(Colores.VERDE_BOLD);
        System.out.println("================================================================================");
        System.out.println("                               MENÚ PRINCIPAL");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println(" (1) Jugar");
        System.out.println(" (2) Instrucciones");
        System.out.println(" (3) Historial de partidas");
        System.out.println(" (4) Salir del juego");
        System.out.println(Colores.RESET + Colores.VERDE_BOLD);
        System.out.println("================================================================================");
        System.out.println(Colores.RESET);
    }    

    /**
     * Muestra el menú de minijuegos.
     * Permite al jugador atender clientes o cuidar gatos.
     * Guarda la partida al volver al menú principal.
     *
     * @param jugador El jugador actual que está jugando.
     */
    public void iniciarMinijuegos(Jugador jugador) {
        Partida partida = new Partida();
        int opcion;
        do {
            mostrarMenuMinijuegos();
            opcion = Lector.leerNumeroEntre(Colores.AMARILLO_BOLD + "Seleccione una opción: " + Colores.RESET, 1, 3);
            switch (opcion) {
                case 1:
                    MinijuegoAtenderClientes.jugar(partida);
                    break;
                case 2:
                    MinijuegoCuidarGatos.jugar(partida);
                    break;
                case 3:
                    System.out.println(Colores.AMARILLO_BOLD + "\nRegresando al menú principal..." + Colores.RESET);
                    partida.finalizarPartida();
                    jugador.agregarPartida(partida);
                    PartidaBD.guardarPartida(jugador.getNombre(), partida);
                    PartidaFichero.guardarPartida(jugador.getNombre(), partida);
                    break;
                default:
                    System.out.println(Colores.ROJO_BOLD + "\nOpción no válida. Intente nuevamente." + Colores.RESET);
                    break;
            }
        } while (opcion != 3);
    }

    /**
     * Muestra el menú secundario (minijuegos).
     */
    public void mostrarMenuMinijuegos() {
        System.out.println(Colores.VERDE_BOLD);
        System.out.println("================================================================================");
        System.out.println("                               MENÚ MINIJUEGOS");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println(" (1) Atender clientes");
        System.out.println(" (2) Cuidar gatos");
        System.out.println(" (3) Volver al menú principal");
        System.out.println(Colores.RESET + Colores.VERDE_BOLD);
        System.out.println("================================================================================");
        System.out.println(Colores.RESET);
    }    

    /**
     * Muestra las instrucciones del juego.
     * Explica cómo funcionan los minijuegos y cómo se gana puntos y monedas.
     */
    public void mostrarInstrucciones() {
        System.out.println(Colores.VERDE_BOLD);
        System.out.println("================================================================================");
        System.out.println("                               INSTRUCCIONES");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println(" Atender clientes: escribe el pedido exacto en un tiempo límite.");
        System.out.println(" Cuidar gatos: mantén la energía, hambre y felicidad de tu gato.");
        System.out.println(" Cada acción en los minijuegos otorga puntos y monedas.");
        System.out.println(" Tu progreso se guarda automáticamente en la base de datos y en el archivo.");
        System.out.println(Colores.RESET + Colores.VERDE_BOLD);
        System.out.println("================================================================================");
        System.out.println(Colores.RESET);
    }
    
    /**
     * Muestra el historial de partidas guardadas en el archivo.
     */
    public void mostrarHistorial() {
        PartidaFichero.mostrarPartidas();
    }
}
