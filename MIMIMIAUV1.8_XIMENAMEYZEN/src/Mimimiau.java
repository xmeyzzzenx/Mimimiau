import juego.Juego;

/**
 * Clase principal del programa.
 * Se encarga de empezar el juego Mimimiau.
 * 
 * Al ejecutarse, crea un juego y lo inicia.
 * 
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class Mimimiau {

    /**
     * Método principal. Es el primer método que se ejecuta cuando inicia el programa.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciarJuego();
    }
}
