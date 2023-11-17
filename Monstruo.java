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
    public int id_hilo;

    // Peso del monstruo.
    protected double peso;

    // Altura del monstruo.
    protected double altura;

    protected Cafeteria cafeteria;

    /**
     * Constructor de Monstruo.
     * @param cafeteria que va a usar.
     * @param nombre del monstruo.
     * @param trabajo trabajo del monstruo.
     */
    public Monstruo(Cafeteria cafeteria, String nombre, Oficio trabajo) {
        this.cafeteria = cafeteria;
        this.cafeteria = cafeteria;
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.id_hilo = ThreadID.get();
    }

    /**
     * Decide que hacer el monstruo.
     * 
     * @return 0 ir al sanitario, 1 ir a comer, 2 ir a trabajar (Con mas
     *         probabilidades de ir a trabajar).
     */
    public int decidir_que_hacer() {
        Random random = new Random();

        // Genera un número aleatorio entre 0 y 9
        int numeroRandom = random.nextInt(9);

        // Si el número generado es menor o igual que 4, devuelve 2
       /* if (numeroRandom <= 4) {
            return 2;
        } else {
            // Si no, devuelve el número aleatorio normal (0 o 1)
            return random.nextInt(2);
        } */
        return 1;
    }

    /**
     * Simulacion del monstruo al ir a comer.
     * 
     * @throws InterruptedException
     */
    public void ir_a_comer() throws InterruptedException {
        cafeteria.entrar_cafeteria(this);
    }

    /**
     * Simulacion del monstruo al ir al sanitario.
     */
    public void ir_al_sanitario() {

    }

    /**
     * Simulacion del monstruo al ir al vestuario.
     */
    public void ir_al_vestuario() {

    }

    /**
     * Simulacion del monstruo de ir a trabajar.
     * 
     * @throws InterruptedException
     */
    public void ir_a_trabajar() throws InterruptedException {
        switch (this.trabajo.get_ID_Oficio()) {

            // Eres un cheff profesional, ve a la cafeteria.
            case 3:
                cafeteria.entrar_cafeteria(this);
                break;

            // Eres un ayudante de cocina, ve a la cafeteria.
            case 0:
                cafeteria.entrar_cafeteria(this);
                break;

            // Eres un recepcionista, ve a la cafeteria.
            case 1:
                cafeteria.entrar_cafeteria(this);
                break;

            // No tienes trabajo??
            default:
                System.out.println("Algo no se esta asignando bienn )):");
                break;
        }
    }

    public static class ThreadID {
        private static volatile int nextID = 0;
        private static ThreadLocal<Integer> threadID = ThreadLocal.withInitial(() -> nextID++);

        /**
         * Devuelve el id del hilo.
         * @return id del hilo.
         */
        public static int get() {
            return threadID.get();
        }
    }

    /**
     * Simulacion del Monstruo dentro de la empresa Monster Inc
     */
    @Override
    public void run() {

        // Antes debe ir al vestuario.

        int iterador = 0;

        // Para monstruos que deben trabajar de ahuevo.
        if (this.trabajo.get_ID_Oficio() == 3 || this.trabajo.get_ID_Oficio() == 0
                || this.trabajo.get_ID_Oficio() == 1) {
            try {
                ir_a_trabajar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
        
        //Para monstruos con mas libertad.
            while (iterador <= 0) {
                switch (decidir_que_hacer()) {

                    //Ir al sanitario
                    case 0:
                        System.out.println("En mantenimiento muacckkk");
                        break;

                    //Ir a comer.
                    case 1:

                        try {
                            ir_a_comer();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        break;

                    //Ir a trabajar.
                    case 2:

                        try {
                            ir_a_trabajar();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        break;

                    default:
                        break;
                }
                iterador++;
            }

        }
        
        // Debe ir al vestuario antes de irse.

    }
}