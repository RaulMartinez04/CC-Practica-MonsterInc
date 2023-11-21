/**
 * Clase Ayudante de cocina que implementa el comportamiento de un Cheff dentro
 * de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Chef_profesional extends Cheff {

    /**
     * Constructor de un chef profesional.
     * @param id_hilo
     */
    public Chef_profesional(int id_hilo) {
        super(id_hilo);
    }

    @Override
    public int get_ID_Oficio() {
        return 3;
    }

    @Override
    public String get_Nombre_Oficio() {
        return "Cheff de Harryhausens";
    }

    @Override
    public String get_descripcion() {
        return "Un cheff de Harryhausens, el casi nunca cocina pero se dice que puede cocinar de todo";
    }

}