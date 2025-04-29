package basedatos;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Clase para conectar a la base de datos del juego Mimimiau.
 * Guarda la URL, el usuario y la contraseña para conectar.
 * Tiene un método para obtener la conexión.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class ConexionBD {

    // Dirección de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/mimimiau";

    // Nombre de usuario para entrar a la base de datos
    private static final String USER = "root";

    // Contraseña del usuario
    private static final String PASSWORD = "Password12345";

    /**
     * Abre y devuelve una conexión a la base de datos.
     *
     * @return Conexión abierta a MySQL.
     * @throws SQLException si falla la conexión.
     */
    public static Connection conexionBD() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
