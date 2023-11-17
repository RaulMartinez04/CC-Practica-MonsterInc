package com.monstersinc.oficio;
import java.util.List;

import com.monstersinc.item.Mesa;
import com.monstersinc.monstruo.Monstruo;


/**
 * Clase Ayudante de cocina que implementa el comportamiento de un Cheff dentro
 * de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Recepcionista implements Oficio {

    // Id del Hilo, del monstruo.
    private int id_hilo;

    /**
     * Metodo constructor de la clase camarero.
     * 
     * @param id_hilo del hilo en ejecucion.
     * @param string
     */
    public Recepcionista(int id_hilo, String string) {
        super();
        this.id_hilo = id_hilo;
    }

    @Override
    public int get_ID_Oficio() {
        return 1;
    }

    @Override
    public String get_Nombre_Oficio() {
        return "Mesero de la cafeteria";
    }

    @Override
    public String get_descripcion() {
        return "Un cheff que se dedica a ayudar al Cheff profesional de Harryhausens";
    }

    /**
     * Regresa el id del hilo en ejecucion.
     * 
     * @return id del hilo en ejecucion.
     */
    public int get_id_hilo() {
        return this.id_hilo;
    }

    public boolean asignar_lugar(Monstruo cliente, List<Mesa> lista_De_Mesas) {
        for (int i = 0; i < lista_De_Mesas.size(); i++) {
            if (lista_De_Mesas.get(i).ocupar_lugar(cliente)) {
                System.out.println("El recepcionista llevo al monstruo " + cliente.nombre + " a la mesa "
                        + lista_De_Mesas.get(i).get_id_mesa());
                return true;
            }
        }

        System.out.println("El recepcionista no encontro mesa ):");
        return false;
    }

}