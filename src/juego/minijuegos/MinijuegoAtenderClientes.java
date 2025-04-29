package juego.minijuegos;

import java.util.Random;

import modelo.Partida;
import utilidades.Colores;
import utilidades.Lector;

/**
 * Minijuego de atender clientes.
 * El jugador debe escribir pedidos correctamente en un tiempo límite.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class MinijuegoAtenderClientes {

    /** Generador de números aleatorios para seleccionar pedidos. */
    private static final Random RANDOM = new Random();

    /** Lista de pedidos cortos para el nivel 1. */
    private static final String[] PEDIDOS_CORTOS = {
        "cafe con leche", "cafe con hielo", "cafe americano",
        "te de menta", "te negro con miel", "infusion de manzanilla",
        "espresso corto", "capuccino clasico", "latte vainilla"
    };

    /** Lista de pedidos largos para los niveles 2 y 3. */
    private static final String[] PEDIDOS_LARGOS = {
        "latte con leche de avena y jarabe de caramelo",
        "capuccino doble con espuma extra sin azucar",
        "americano grande con hielo sin azucar ni leche",
        "mocha con leche de almendra y canela",
        "espresso con leche condensada y esencia de vainilla",
        "flat white con leche de coco y jarabe de avellana",
        "cafe filtrado con canela y jengibre sin azucar",
        "te matcha con leche de soja y miel",
        "latte macchiato descafeinado con nata montada",
        "americano triple con esencia de chocolate oscuro"
    };

    /** Constantes del juego: configuraciones generales. */
    private static final int PEDIDOS_POR_NIVEL = 5;
    private static final int NIVELES = 3;
    private static final int TIEMPO_BASE = 15; // segundos
    private static final int PUNTOS_BASE = 10;
    private static final int MONEDAS_BASE = 5;
    private static final int PEDIDOS_PARA_RACHA = 3;
    private static final int EXTRA_PUNTOS_RACHA = 5;
    private static final int EXTRA_MONEDAS_RACHA = 2;

    /**
     * Ejecuta el minijuego completo: niveles, pedidos, control de tiempo, puntos y monedas.
     * Permite salir escribiendo "salir" en cualquier momento.
     * 
     * @param partida La partida donde se acumulan los puntos y monedas.
     */
    public static void jugar(Partida partida) {
        int pedidosCorrectos = 0;
        int pedidosFallidos = 0;
        int rachaActiva = 0;

        mostrarIntroduccion();

        for (int nivel = 1; nivel <= NIVELES; nivel++) {
            System.out.println(Colores.MORADO_BOLD);
            System.out.println("================================================================================");
            System.out.println("                                  NIVEL " + nivel);
            System.out.println("================================================================================");
            System.out.println(Colores.RESET);

            for (int i = 1; i <= PEDIDOS_POR_NIVEL; i++) {
                String pedido = (nivel == 1)
                        ? PEDIDOS_CORTOS[RANDOM.nextInt(PEDIDOS_CORTOS.length)]
                        : PEDIDOS_LARGOS[RANDOM.nextInt(PEDIDOS_LARGOS.length)];

                int tiempoLimite = (nivel == 3) ? TIEMPO_BASE - (i - 1) : TIEMPO_BASE;

                System.out.println(Colores.BLANCO_BOLD + "\nPedido " + i + ": " + Colores.RESET + Colores.AMARILLO_BOLD + pedido + Colores.RESET);

                long tiempoInicio = System.currentTimeMillis();
                String respuesta = Lector.leerCadena(Colores.BLANCO_BOLD + "Escribe el pedido exactamente: " + Colores.RESET);

                if (respuesta.equalsIgnoreCase("salir")) {
                    System.out.println(Colores.ROJO_BOLD + "\nHas decidido salir del minijuego y volver al menú." + Colores.RESET);
                    mostrarResumen(pedidosCorrectos, pedidosFallidos, partida);
                    return;
                }

                long tiempoFin = System.currentTimeMillis();
                long tiempoTranscurrido = (tiempoFin - tiempoInicio) / 1000;

                boolean correcto = respuesta.equalsIgnoreCase(pedido) && tiempoTranscurrido <= tiempoLimite;

                if (correcto) {
                    partida.sumarPuntos(PUNTOS_BASE);
                    partida.sumarMonedas(MONEDAS_BASE);
                    pedidosCorrectos++;
                    rachaActiva++;

                    System.out.println(Colores.VERDE_BOLD + "Pedido correcto. Tiempo: " + tiempoTranscurrido + "s de " + tiempoLimite + "s. + " + PUNTOS_BASE + " pts + " + MONEDAS_BASE + " monedas." + Colores.RESET);

                    if (rachaActiva >= PEDIDOS_PARA_RACHA) {
                        partida.sumarPuntos(EXTRA_PUNTOS_RACHA);
                        partida.sumarMonedas(EXTRA_MONEDAS_RACHA);
                        System.out.println(Colores.VERDE_BOLD + "¡Bonus de racha aplicado! + " + EXTRA_PUNTOS_RACHA + " pts + " + EXTRA_MONEDAS_RACHA + " monedas." + Colores.RESET);
                    }
                } else {
                    pedidosFallidos++;
                    System.out.println(Colores.ROJO_BOLD + "Pedido incorrecto. Tiempo: " + tiempoTranscurrido + "s de " + tiempoLimite + "s." + Colores.RESET);

                    if (rachaActiva >= PEDIDOS_PARA_RACHA) {
                        System.out.println(Colores.ROJO_BOLD + "Has perdido tu racha de aciertos." + Colores.RESET);
                    }

                    rachaActiva = 0;
                }
            }
        }

        mostrarResumen(pedidosCorrectos, pedidosFallidos, partida);
    }

    /**
     * Muestra la introducción del minijuego: explica el objetivo, las reglas y consejos.
     */
    public static void mostrarIntroduccion() {
        System.out.println(Colores.MORADO_BOLD);
        System.out.println("================================================================================");
        System.out.println("                        BIENVENIDO AL MINIJUEGO: ATENDER CLIENTES");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println(" En este minijuego trabajarás en la cafetería Mimimiau atendiendo pedidos.");
        System.out.println(" Tu objetivo es escribir el pedido EXACTAMENTE como aparece en pantalla.");
        System.out.println(" Tienes un tiempo límite para cada pedido. ¡No te confíes!");
        System.out.println();
        System.out.println(" NIVELES:");
        System.out.println(" - Nivel 1: Pedidos cortos y tiempo suficiente (15s).");
        System.out.println(" - Nivel 2: Pedidos largos, mismo tiempo (15s).");
        System.out.println(" - Nivel 3: Pedidos largos, pero cada vez menos tiempo (15s-14s-13s...).");
        System.out.println();
        System.out.println(" ¿Cómo ganas puntos?");
        System.out.println(" - Cada pedido correcto suma puntos y monedas.");
        System.out.println(" - Si aciertas 3 pedidos seguidos, ganas un bonus extra de puntos y monedas.");
        System.out.println(" - Si fallas o tardas mucho, pierdes la racha de bonus.");
        System.out.println();
        System.out.println(" CONSEJO:");
        System.out.println(" - Escribe rápido pero con mucho cuidado. Un error te puede costar mucho.");
        System.out.println();
        System.out.println(" IMPORTANTE:");
        System.out.println(" - Si deseas abandonar el minijuego en cualquier momento, escribe: salir");
        System.out.println(Colores.RESET + Colores.MORADO_BOLD);
        System.out.println("================================================================================");
        System.out.println(Colores.RESET);
        Lector.leerCadena(Colores.AMARILLO_BOLD + "\nPresiona ENTER para comenzar el desafío..." + Colores.RESET);
    }

    /**
     * Muestra el resumen final: pedidos acertados, fallidos, puntos y monedas ganadas.
     * 
     * @param pedidosCorrectos Número de pedidos correctos realizados.
     * @param pedidosFallidos Número de pedidos fallidos.
     * @param partida La partida donde se almacenan los resultados.
     */
    public static void mostrarResumen(int pedidosCorrectos, int pedidosFallidos, Partida partida) {
        System.out.println(Colores.MORADO_BOLD);
        System.out.println("================================================================================");
        System.out.println("                           RESUMEN DEL MINIJUEGO");
        System.out.println("================================================================================");
        System.out.println(Colores.RESET + Colores.BLANCO_BOLD);
        System.out.println("Pedidos correctos : " + pedidosCorrectos + " de " + (NIVELES * PEDIDOS_POR_NIVEL));
        System.out.println("Pedidos fallidos  : " + pedidosFallidos + " de " + (NIVELES * PEDIDOS_POR_NIVEL));
        System.out.println("Puntos ganados    : " + partida.getPuntos() + " pts");
        System.out.println("Monedas ganadas   : " + partida.getMonedas() + " monedas");
        System.out.println(Colores.RESET + Colores.MORADO_BOLD);
        System.out.println("=================================================================================");
        System.out.println(Colores.RESET);
    }
}
