import java.util.Random;

/**
 * Clase Monstruo que implementa el comportamiento de un Monstruo dentro
 * de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public abstract class Monstruo implements Runnable {

    // Nombre del monstruo.
    protected String nombre;

    // Tipo de monstruo.
    protected int tipo;

    // Trabajo del monstruo.
    public Oficio trabajo;

    // ID del hilo.
    protected int id_hilo;

    // Peso del monstruo.
    protected double peso;

    // Altura del monstruo.
    protected double altura;

    /**
     * Decide que hacer el monstruo.
     * @return 0 ir al sanitario, 1 ir a comer, 2 ir a trabajar (Con mas probabilidades de ir a trabajar).
     */
    public int decidir_que_hacer() {
        Random random = new Random();

        // Genera un número aleatorio entre 0 y 9
        int numeroRandom = random.nextInt(9);

        // Si el número generado es menor que 4, devuelve 2
        if (numeroRandom <= 5) {
            return 2;
        } else {
            // Si no, devuelve el número aleatorio normal (0 o 1)
            return random.nextInt(2);
        }
    }

    /**
     * Simulacion del monstruo al ir a comer.
     */
    public void ir_a_comer(){

    }

    /**
     * Simulacion del monstruo al ir al sanitario.
     */
    public void ir_al_sanitario(){

    }

    /**
     * Simulacion del monstruo al ir al vestuario.
     */
    public void ir_al_vestuario(){

    }

    /**
     * Simulacion del monstruo de ir a trabajar.
     */
    public void ir_a_trabajar(){

    }

    /**
     * Simulacion del Monstruo dentro de la empresa Monster Inc
     */
    @Override
    public void run() {

     // Antes debe ir al vestuario.

        switch (decidir_que_hacer()) {
            case 0:
                // Si va ir al sanitario
                break;

            case 1:
                // Si va a ir a comer
                break;

            case 2:
                // Si va a trabajar
                break;
        
            default:
                break;
        }

     // Debe ir al vestuario antes de irse.

    }
}