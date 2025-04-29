package modelo.gatos;

/**
 * Representa un gato de raza Maine Coon.
 * Es un gato grande, fuerte y con mucha energía.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class GatoMaineCoon extends Gato {

    /**
     * Crea un gato Maine Coon con valores por defecto de energía, hambre y felicidad.
     * @param nombre Nombre del gato.
     */
    public GatoMaineCoon(String nombre) {
        super(nombre, 70, 40, 65); // Energía alta, hambre algo alta, felicidad media-alta
    }

    /**
     * Crea un gato Maine Coon con valores personalizados.
     * @param nombre Nombre del gato.
     * @param energia Nivel inicial de energía.
     * @param hambre Nivel inicial de hambre.
     * @param felicidad Nivel inicial de felicidad.
     */
    public GatoMaineCoon(String nombre, int energia, int hambre, int felicidad) {
        super(nombre, energia, hambre, felicidad);
    }

    /**
     * Hace que el gato coma.
     * Baja mucho el hambre, sube la energía y la felicidad.
     */
    @Override
    public void comer() {
        setHambre(getHambre() - 30);
        setEnergia(getEnergia() + 15);
        setFelicidad(getFelicidad() + 10);
        validarEstados();
    }

    /**
     * Hace que el gato duerma.
     * Aumenta la energía, un poco la felicidad y sube algo el hambre.
     */
    @Override
    public void dormir() {
        setEnergia(getEnergia() + 20);
        setHambre(getHambre() + 5);
        setFelicidad(getFelicidad() -5);
        validarEstados();
    }

    /**
     * Hace que el gato juegue.
     * Baja un poco la energía, sube la felicidad y aumenta el hambre.
     */
    @Override
    public void jugar() {
        setEnergia(getEnergia() - 15);
        setHambre(getHambre() + 10);
        setFelicidad(getFelicidad() + 15);
        validarEstados();
    }
}
