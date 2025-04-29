package modelo.gatos;

/**
 * Representa un gato de raza Persa.
 * Es un gato tranquilo, que duerme mucho y se cansa fácilmente.
 * @author Ximena Meyzen Calderón
 * @version 1.8 (final)
 */
public class GatoPersa extends Gato {

    /**
     * Crea un gato Persa con valores estándar de energía, hambre y felicidad.
     * @param nombre Nombre del gato.
     */
    public GatoPersa(String nombre) {
        super(nombre, 60, 20, 60); // Energía media, poca hambre, felicidad media
    }

    /**
     * Crea un gato Persa con valores personalizados.
     * @param nombre Nombre del gato.
     * @param energia Nivel inicial de energía.
     * @param hambre Nivel inicial de hambre.
     * @param felicidad Nivel inicial de felicidad.
     */
    public GatoPersa(String nombre, int energia, int hambre, int felicidad) {
        super(nombre, energia, hambre, felicidad);
    }

    /**
     * Hace que el gato coma.
     * Baja un poco el hambre y sube un poco la energía y felicidad.
     */
    @Override
    public void comer() {
        setHambre(getHambre() - 15);
        setEnergia(getEnergia() + 5);
        setFelicidad(getFelicidad() + 5);
        validarEstados();
    }

    /**
     * Hace que el gato duerma.
     * Sube mucho la energía, sube algo el hambre y un poco la felicidad.
     */
    @Override
    public void dormir() {
        setEnergia(getEnergia() + 30);
        setHambre(getHambre() + 10);
        setFelicidad(getFelicidad() -5 );
        validarEstados();
    }

    /**
     * Hace que el gato juegue.
     * Baja bastante la energía, sube el hambre y mejora la felicidad.
     */
    @Override
    public void jugar() {
        setEnergia(getEnergia() - 25);
        setHambre(getHambre() + 10);
        setFelicidad(getFelicidad() + 10);
        validarEstados();
    }
}


    
