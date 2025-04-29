package modelo.gatos;

/**
 * Representa un gato de raza Siamés.
 * Es un gato muy activo, alegre, pero también sensible si no duerme bien.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class GatoSiames extends Gato {

    /**
     * Crea un gato Siamés con valores estándar de energía, hambre y felicidad.
     * @param nombre Nombre del gato.
     */
    public GatoSiames(String nombre) {
        super(nombre, 80, 30, 70); // Mucha energía, hambre moderada, felicidad alta
    }

    /**
     * Crea un gato Siamés con valores personalizados.
     * @param nombre Nombre del gato.
     * @param energia Nivel inicial de energía.
     * @param hambre Nivel inicial de hambre.
     * @param felicidad Nivel inicial de felicidad.
     */
    public GatoSiames(String nombre, int energia, int hambre, int felicidad) {
        super(nombre, energia, hambre, felicidad);
    }

    /**
     * Hace que el gato coma.
     * Reduce bastante el hambre y mejora un poco la energía y felicidad.
     */
    @Override
    public void comer() {
        setHambre(getHambre() - 20);
        setEnergia(getEnergia() + 10);
        setFelicidad(getFelicidad() + 5);
        validarEstados();
    }

    /**
     * Hace que el gato duerma.
     * Sube algo la energía y el hambre, pero baja un poco la felicidad.
     */
    @Override
    public void dormir() {
        setEnergia(getEnergia() + 15);
        setHambre(getHambre() + 5);
        setFelicidad(getFelicidad() - 5);
        validarEstados();
    }

    /**
     * Hace que el gato juegue.
     * Gasta bastante energía, sube el hambre pero sube mucho la felicidad.
     */
    @Override
    public void jugar() {
        setEnergia(getEnergia() - 20);
        setHambre(getHambre() + 10);
        setFelicidad(getFelicidad() + 20);
        validarEstados();
    }
}

