package tiposlistos.concurrente.oficio;
/**
 * Interfaz oficio que implementa el comportamiento 
 * de los trabajos de los monstruos dentro de Monster Inc.
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */

public abstract class Oficio {

    // Id del Hilo, del monstruo.
    public int id_hilo;

    public Oficio(int id_hilo) {
        this.id_hilo = id_hilo;
    }

    /**
     * Regresa el ID del tipo de oficio.
     * 
     * @return ID del oficio.
     */
    public int get_ID_Oficio() {
        return -1;
    }

    /**
     * Regresa el nombre del oficio.
     * 
     * @return nombre del oficio.
     */
    String get_Nombre_Oficio() {
        return "NULL";
    }

    /**
     * Regresa la descripcion del trabajo.
     * 
     * @return descripcion del trabajo.
     */
    String get_descripcion() {
        return "NULL";
    }

    /**
     * Regresa el id del hilo en ejecucion.
     * 
     * @return id del hilo en ejecucion.
     */
    public int get_id_hilo() {
        return this.id_hilo;
    }

}