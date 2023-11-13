/**
 * Interfaz oficio que implementa el comportamiento de los trabajos de los monstruos dentro de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */

public interface Oficio {

    /**
     * Regresa el ID del tipo de oficio.
     * @return ID del oficio.
     */
    int get_ID_Oficio();

    /**
     * Regresa el nombre del oficio.
     * @return nombre del oficio.
     */
    String get_Nombre_Oficio();

    /**
     * Regresa la descripcion del trabajo.
     * @return descripcion del trabajo.
     */
    String get_descripcion();

}
