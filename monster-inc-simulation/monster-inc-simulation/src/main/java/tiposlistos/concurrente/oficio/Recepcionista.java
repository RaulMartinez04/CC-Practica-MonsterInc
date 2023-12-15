package com.monstersinc.oficio;
import java.util.List;

import com.monstersinc.aux.ColorsAthena;
import com.monstersinc.item.Mesa;
import com.monstersinc.monstruo.Monstruo;

/**
 * Clase Ayudante de cocina que implementa el comportamiento de un Cheff dentro
 * de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Recepcionista extends Oficio {

    /**
     * Metodo constructor de la clase camarero.
     * 
     * @param id_hilo del hilo en ejecucion.
     * @param string
     */
    public Recepcionista(int id_hilo) {
        super(id_hilo);
        this.id_hilo = id_hilo;
    }

    @Override
    public int get_ID_Oficio() {
        return 1;
    }

    @Override
    public String get_Nombre_Oficio() {
        return "Recepcionista";
    }

    @Override
    public String get_descripcion() {
        return "Un Recepcionista de la cafeteria de MonsterInc";
    }

    /**
     * Metodo que asigna un lugar a un cliente en una lista de mesas.
     * 
     * @param cliente        a asignar lugar.
     * @param lista_De_Mesas que usar
     * @return True si si hubo un lugar, False si no hubo un lugar.
     */
    public boolean asignar_lugar(Monstruo cliente, List<Mesa> lista_De_Mesas) {
        for (int i = 0; i < lista_De_Mesas.size(); i++) {
            if (lista_De_Mesas.get(i).ocupar_lugar(cliente)) {
                System.out.println(
                        ColorsAthena.rojo("El recepcionista llevo al monstruo " + cliente.nombre + " a la mesa "
                                + lista_De_Mesas.get(i).get_id_mesa()));
                return true;
            }
        }

        System.out.println(ColorsAthena.rojo("El recepcionista no encontro mesa ):"));
        return false;
    }

}