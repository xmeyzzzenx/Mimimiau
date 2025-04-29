package ficheros;

import utilidades.Colores;

import java.io.*;

import modelo.Partida;

/**
 * Clase que guarda y muestra partidas usando un fichero de texto.
 * Las partidas se guardan en "files/partidas.txt".
 * Cada partida tiene el nombre del jugador, la fecha, las horas, los puntos y las monedas.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class PartidaFichero {

    // Ruta donde se guarda el archivo
    private static final String RUTA = "../files/partidas.txt";

    /**
     * Guarda una partida en el archivo "partidas.txt".
     * Si el archivo no existe, lo crea y escribe una cabecera.
     *
     * @param nombreJugador Nombre del jugador.
     * @param partida Objeto partida con los datos a guardar.
     */
    public static void guardarPartida(String nombreJugador, Partida partida) {
        try {
            File archivo = new File(RUTA);
            boolean archivoNuevo = !archivo.exists();
    
            PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
    
            if (archivoNuevo) {
                writer.println(String.format("%-15s %-12s %-10s %-10s %-10s %-8s %-8s",
                        "Jugador", "Día", "Inicio", "Fin", "Duración", "Puntos", "Monedas"));
                writer.println("=".repeat(80));
            }
    
            String linea = String.format("%-15s %-12s %-10s %-10s %-10s %-8d %-8d",
                    nombreJugador,
                    partida.getDia(),
                    partida.getHoraInicioFormateada(),
                    partida.getHoraFinFormateada(),
                    partida.getDuracionFormateada(),
                    partida.getPuntos(),
                    partida.getMonedas());
    
            writer.println(linea);
            writer.close();
    
            System.out.println(Colores.VERDE_BOLD + "Partida guardada correctamente en el fichero de texto." + Colores.RESET);
    
        } catch (IOException e) {
            System.out.println(Colores.ROJO_BOLD + "Error al guardar partida en el fichero: " + e.getMessage() + Colores.RESET);
        }
    }
    
    /**
     * Muestra por pantalla todas las partidas guardadas en el archivo de texto.
     * Si no hay archivo, avisa que no se ha guardado ninguna partida todavía.
     * Las partidas se muestran en forma de tabla y con colores.
     */
    public static void mostrarPartidas() {
        File archivo = new File(RUTA);
    
        if (!archivo.exists()) {
            System.out.println(Colores.ROJO_BOLD + "\nNo hay partidas guardadas todavía." + Colores.RESET);
            return;
        }
    
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            
            System.out.println(Colores.VERDE_BOLD);
            System.out.println("\n=========================== HISTORIAL DE PARTIDAS ==============================\n");
            
            String linea;
            boolean primeraLinea = true;
    
            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    System.out.println(Colores.BLANCO_BOLD + linea + Colores.RESET);
                    primeraLinea = false;
                } else if (linea.startsWith("=")) {
                    System.out.println(Colores.VERDE_BOLD + linea + Colores.RESET);
                } else {
                    System.out.println(Colores.CYAN_BOLD + linea + Colores.RESET);
                }
            }
    
            System.out.println(Colores.RESET);
    
        } catch (IOException e) {
            System.out.println(Colores.ROJO_BOLD + "Error al leer las partidas: " + e.getMessage() + Colores.RESET);
        }
    }
    
}
