import java.util.concurrent.atomic.AtomicInteger;

/**
 * Interfaz Cheff que implementa el comportamiento de los trabajadores del tipo
 * Cheff dentro de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */

public abstract class Cheff extends Oficio {

    // Id del Hilo, del monstruo.
    private int id_hilo;

    // Lista de platillos que puede cocinar.
    private Platillo[] lista_platillos;

    /**
     * Clase Cheff, pasar id de hilo o monstruo.
     * 
     * @param id_hilo identificador del monstruo.
     */
    public Cheff(int id_hilo) {
        super(id_hilo);
    }

    /**
     * Simulacion de preparacion de una comida.
     * 
     * @param id_del_platillo platillo a preparar
     * @param inventario      inventario con el cual se va a trabajar
     * @param nombre          Nombre del cheff
     * @throws InterruptedException error
     */
    protected void preparar_comida(int id_del_platillo, AtomicInteger[] inventario, String nombre)
            throws InterruptedException {
        for (int i = 0; i < lista_platillos.length; i++) {

            // Se encontro el platillo.
            if (i == lista_platillos[i].get_identificador_platillo()) {
                Platillo aux = lista_platillos[i];

                // Vemos si hay ingredientes.
                if (aux.get_cantidad_de_carne() <= inventario[0].get()
                        && aux.get_cantidad_de_vegetales() <= inventario[1].get()) {

                    set_Inventario(inventario, aux);

                    System.out.println(ColorsAthena.rojo("Preparando " + aux.get_nombre_de_platillo()));
                    Thread.sleep(1000);
                    System.out.println(
                            ColorsAthena.rojo("Cocinero " + nombre + " preparo " + aux.get_nombre_de_platillo()));

                } else {

                    // Falta carne
                    if (aux.get_cantidad_de_carne() > inventario[0].get()) {

                        System.out.println(ColorsAthena
                                .rojo("Falta de carne para " + aux.get_identificador_platillo() + " cocinero "
                                        + id_hilo + " llena el inventario de carne"));
                        llenar_Inventario(inventario, 0);
                        set_Inventario(inventario, aux);

                        System.out.println(ColorsAthena.rojo("Preparando " + aux.get_nombre_de_platillo()));
                        Thread.sleep(1000);
                        System.out.println(
                                ColorsAthena.rojo("Cocinero " + nombre + " preparo " + aux.get_nombre_de_platillo()));

                    } else {

                        // Falta vegetales.
                        System.out.println(ColorsAthena
                                .rojo("Falta de vegetales para " + aux.get_identificador_platillo() + " cocinero "
                                        + id_hilo + " llena el inventario de vegetales"));
                        llenar_Inventario(inventario, 1);
                        set_Inventario(inventario, aux);

                        System.out.println(ColorsAthena.rojo("Preparando " + aux.get_nombre_de_platillo()));
                        Thread.sleep(1000);
                        System.out.println(
                                ColorsAthena.rojo("Cocinero " + nombre + " preparo " + aux.get_nombre_de_platillo()));

                    }
                }
            }
        }
    }

    /**
     * Obtener la lista de platillos que puede preparar.
     * 
     * @return lista de platillos que puede preparar.
     */
    protected Platillo[] get_lista_platillos() {
        return this.lista_platillos;
    }

    /**
     * Cambiar la lista de platillos que puede preparar.
     * 
     * @param lista_nueva de platillos
     */
    protected void set_lista_platillos(Platillo[] lista_nueva) {
        this.lista_platillos = lista_nueva;
    }

    /**
     * Resta los ingredientes ocupados por el platillo en el inventario.
     * 
     * @param inventario inventario de carne y vegetales.
     * @param consumir   platillo que consumira los recursos.
     */
    protected void set_Inventario(AtomicInteger[] inventario, Platillo consumir) {
        inventario[0].set(inventario[0].get() - consumir.get_cantidad_de_carne());
        inventario[1].set(inventario[1].get() - consumir.get_cantidad_de_vegetales());
    }

    /**
     * LLena de ingredientes el inventario, 1000 es el maximo de ingredintes.
     * 
     * @param inventario a llenar
     * @param a_llenar   0 si se va a llenar carne, 1 si se va a llenar vegetales.
     */
    // Concurrente
    protected void llenar_Inventario(AtomicInteger[] inventario, int a_llenar) {
        inventario[a_llenar].set(1000);
    }

}