package basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Partida;
import utilidades.Colores;

/**
 * Clase que guarda una partida en la base de datos del juego Mimimiau.
 * Usa la conexión que da ConexionBD.
 * Guarda el nombre del jugador, las horas, puntos y monedas.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)

 */
public class PartidaBD {

    /**
     * Guarda una partida en la base de datos.
     * 
     * @param nombreJugador Nombre del jugador.
     * @param partida Objeto partida con los datos a guardar.
     */
    public static void guardarPartida(String nombreJugador, Partida partida) {

        String sql = "INSERT INTO partidas (nombre_jugador, fecha_partida, hora_inicio, hora_fin, duracion, puntos, monedas) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conexion = ConexionBD.conexionBD();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, nombreJugador);
            sentencia.setString(2, partida.getDia().toString());
            sentencia.setString(3, partida.getHoraInicio().toString());
            sentencia.setString(4, partida.getHoraFin().toString());
            sentencia.setString(5, partida.getDuracionFormateada());
            sentencia.setInt(6, partida.getPuntos());
            sentencia.setInt(7, partida.getMonedas());

            sentencia.executeUpdate();
            System.out.println(Colores.VERDE_BOLD + "Partida guardada correctamente en la base de datos." + Colores.RESET);

        } catch (SQLException e) {
            System.out.println(Colores.ROJO_BOLD + "Error al guardar partida en la base de datos: " + e.getMessage() + Colores.RESET);
        }
    }
}
