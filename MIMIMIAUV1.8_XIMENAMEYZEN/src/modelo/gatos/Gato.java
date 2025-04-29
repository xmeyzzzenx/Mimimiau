package modelo.gatos;

/**
 * Clase abstracta que representa un gato.
 * Define atributos básicos como nombre, hambre, energía y felicidad.
 * También define acciones que todos los gatos deben tener: comer, dormir y jugar.
 * @author Ximena Meyzen Calderón   
 * @version 1.8 (final)
 */
public abstract class Gato {
    
    private String nombre;
    private int hambre;
    private int energia;
    private int felicidad;

    /**
     * Crea un gato con su nombre, energía, hambre y felicidad.
     * @param nombre Nombre del gato.
     * @param energia Nivel inicial de energía (0 a 100).
     * @param hambre Nivel inicial de hambre (0 a 100).
     * @param felicidad Nivel inicial de felicidad (0 a 100).
     */
    public Gato(String nombre, int energia, int hambre, int felicidad) {
        this.nombre = nombre;
        this.hambre = hambre;
        this.energia = energia;
        this.felicidad = felicidad;
    }

    // ======== Getters y Setters ========

    /**
     * Devuelve el nombre del gato.
     * @return nombre del gato.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del gato.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nivel de hambre del gato.
     * @return hambre del gato.
     */
    public int getHambre() {
        return hambre;
    }

    /**
     * Cambia el nivel de hambre del gato.
     * @param hambre Nuevo nivel de hambre.
     */
    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    /**
     * Devuelve el nivel de energía del gato.
     * @return energía del gato.
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * Cambia el nivel de energía del gato.
     * @param energia Nueva energía.
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    /**
     * Devuelve el nivel de felicidad del gato.
     * @return felicidad del gato.
     */
    public int getFelicidad() {
        return felicidad;
    }

    /**
     * Cambia el nivel de felicidad del gato.
     * @param felicidad Nueva felicidad.
     */
    public void setFelicidad(int felicidad) {
        this.felicidad = felicidad;
    }

    // ======== Métodos abstractos ========

    /**
     * Acción que representa cuando el gato come.
     * Cada tipo de gato lo implementará a su manera.
     */
    public abstract void comer();

    /**
     * Acción que representa cuando el gato duerme.
     */
    public abstract void dormir();

    /**
     * Acción que representa cuando el gato juega.
     */
    public abstract void jugar();

    // ======== Otros métodos ========

    /**
     * Ajusta los niveles de hambre, energía y felicidad para que siempre estén entre 0 y 100.
     */
    public void validarEstados() {
        if (hambre < 0) {
            hambre = 0;
        } else if (hambre > 100) {
            hambre = 100;
        }

        if (energia < 0) {
            energia = 0;
        } else if (energia > 100) {
            energia = 100;
        }

        if (felicidad < 0) {
            felicidad = 0;
        } else if (felicidad > 100) {
            felicidad = 100;
        }
    }

    /**
     * Devuelve un resumen de cómo está el gato (nombre, energía, hambre y felicidad).
     * @return estado actual del gato en forma de texto.
     */
    @Override
    public String toString() {
        return "Gato: " + nombre + "\n" +
               "Energia: " + energia + "\n" +
               "Hambre: " + hambre + "\n" +
               "Felicidad: " + felicidad;
    }
}
