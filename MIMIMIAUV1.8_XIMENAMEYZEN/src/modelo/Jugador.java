package modelo;

import java.util.ArrayList;

/**
 * Clase que representa un jugador en el juego.
 * Un jugador tiene un nombre y un historial de partidas jugadas.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class Jugador {

    private String nombre;
    private ArrayList<Partida> partidas;

    /**
     * Constructor que crea un jugador con su nombre e inicializa la lista de partidas vacía.
     *
     * @param nombre Nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidas = new ArrayList<>();
    }

    /**
     * Constructor que crea un jugador con su nombre y una lista de partidas existente.
     *
     * @param nombre Nombre del jugador.
     * @param partidas Lista de partidas del jugador.
     */
    public Jugador(String nombre, ArrayList<Partida> partidas) {
        this.nombre = nombre;
        this.partidas = partidas;
    }

    /**
     * Devuelve el nombre del jugador.
     *
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del jugador.
     *
     * @param nombre Nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la lista de partidas del jugador.
     *
     * @return Lista de partidas.
     */
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    /**
     * Modifica la lista de partidas del jugador.
     *
     * @param partidas Nueva lista de partidas.
     */
    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    /**
     * Agrega una nueva partida al historial del jugador.
     *
     * @param partida Partida a agregar.
     */
    public void agregarPartida(Partida partida) {
        partidas.add(partida);
    }

    /**
     * Representación en forma de texto del jugador, incluyendo su nombre
     * y el número de partidas jugadas.
     *
     * @return Cadena de texto que representa al jugador.
     */
    @Override
    public String toString() {
        return "Jugador:\n" +
               "Nombre: " + nombre + "\n" +
               "Número de partidas: " + partidas.size();
    }
}
