package modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una partida del juego.
 * Contiene información sobre el día, la hora de inicio y fin, los puntos y las monedas obtenidas.
 * Permite calcular la duración de la partida y devolver datos formateados.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class Partida {

    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int puntos;
    private int monedas;

    // Formateador común de horas
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * Constructor para iniciar una nueva partida con la fecha y hora de inicio actual.
     */
    public Partida() {
        this.dia = LocalDate.now();
        this.horaInicio = LocalTime.now();
        this.horaFin = null;
        this.puntos = 0;
        this.monedas = 0;
    }

    /**
     * Constructor para reconstruir una partida guardada con datos específicos.
     *
     * @param dia Día de la partida.
     * @param horaInicio Hora de inicio de la partida.
     * @param horaFin Hora de fin de la partida.
     * @param puntos Puntos obtenidos en la partida.
     * @param monedas Monedas obtenidas en la partida.
     */
    public Partida(LocalDate dia, LocalTime horaInicio, LocalTime horaFin, int puntos, int monedas) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.puntos = puntos;
        this.monedas = monedas;
    }

    /**
     * Devuelve el día de la partida.
     *
     * @return Día de la partida.
     */
    public LocalDate getDia() {
        return dia;
    }

    /**
     * Modifica el día de la partida.
     *
     * @param dia Nuevo día de la partida.
     */
    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    /**
     * Devuelve la hora de inicio de la partida.
     *
     * @return Hora de inicio.
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Modifica la hora de inicio de la partida.
     *
     * @param horaInicio Nueva hora de inicio.
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Devuelve la hora de fin de la partida.
     *
     * @return Hora de fin.
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * Modifica la hora de fin de la partida.
     *
     * @param horaFin Nueva hora de fin.
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Devuelve los puntos obtenidos en la partida.
     *
     * @return Puntos obtenidos.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Modifica los puntos de la partida.
     *
     * @param puntos Nuevos puntos obtenidos.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Devuelve las monedas obtenidas en la partida.
     *
     * @return Monedas obtenidas.
     */
    public int getMonedas() {
        return monedas;
    }

    /**
     * Modifica las monedas de la partida.
     *
     * @param monedas Nuevas monedas obtenidas.
     */
    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    /**
     * Suma puntos a los ya obtenidos en la partida.
     *
     * @param puntos Puntos a sumar.
     */
    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    /**
     * Suma monedas a las ya obtenidas en la partida.
     *
     * @param monedas Monedas a sumar.
     */
    public void sumarMonedas(int monedas) {
        this.monedas += monedas;
    }

    /**
     * Finaliza la partida actualizando la hora de fin al momento actual.
     */
    public void finalizarPartida() {
        this.horaFin = LocalTime.now();
    }

    /**
     * Devuelve la hora de inicio formateada como cadena en formato HH:mm:ss.
     *
     * @return Hora de inicio formateada.
     */
    public String getHoraInicioFormateada() {
        return horaInicio.format(FORMATO_HORA);
    }

    /**
     * Devuelve la hora de fin formateada como cadena en formato HH:mm:ss.
     * Si la partida está en curso, devuelve "En curso".
     *
     * @return Hora de fin formateada o "En curso" si aún no ha finalizado.
     */
    public String getHoraFinFormateada() {
        if (horaFin == null) {
            return "En curso";
        } else {
            return horaFin.format(FORMATO_HORA);
        }
    }

    /**
     * Devuelve la duración de la partida formateada como cadena en formato HH:mm:ss.
     * Si la partida está en curso, devuelve "En curso".
     *
     * @return Duración formateada o "En curso" si aún no ha finalizado.
     */
    public String getDuracionFormateada() {
        if (horaFin == null) {
            return "En curso";
        } else {
            Duration duracion = Duration.between(horaInicio, horaFin);
            long horas = duracion.toHours();
            long minutos = duracion.toMinutesPart();
            long segundos = duracion.toSecondsPart();
            return String.format("%02d:%02d:%02d", horas, minutos, segundos);
        }
    }

    /**
     * Representación en forma de texto de la partida,
     * incluyendo fecha, hora de inicio y fin, duración, puntos y monedas.
     *
     * @return Cadena de texto que representa la partida.
     */
    @Override
    public String toString() {
        return "Partida:\n" +
               "Fecha: " + dia + "\n" +
               "Hora Inicio: " + getHoraInicioFormateada() + "\n" +
               "Hora Fin: " + getHoraFinFormateada() + "\n" +
               "Duración: " + getDuracionFormateada() + "\n" +
               "Puntos: " + puntos + "\n" +
               "Monedas: " + monedas;
    }
}
