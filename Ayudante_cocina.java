/**
 * Clase Ayudante de cocina que implementa el comportamiento de un Cheff dentro
 * de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Ayudante_cocina extends Cheff {

    /**
     * Metodo constructor de un ayudante de cocina.
     * @param id_hilo
     */
    public Ayudante_cocina(int id_hilo) {
        super(id_hilo);
    }

    @Override
    public int get_ID_Oficio() {
        return 0;
    }

    @Override
    public String get_Nombre_Oficio() {
        return "Ayudante de cocina";
    }

    @Override
    public String get_descripcion() {
        return "Un cheff que se dedica a ayudar al Cheff profesional de Harryhausens";
    }

}