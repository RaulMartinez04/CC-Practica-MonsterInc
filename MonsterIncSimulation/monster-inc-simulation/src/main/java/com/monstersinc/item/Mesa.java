package com.monstersinc.item;
import java.util.List;
import java.util.Random;

import com.monstersinc.monstruo.Monstruo;

/**
 * Clase Ayudante de cocina que implementa el comportamiento de un Cheff dentro
 * de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Mesa extends Item {

    private int id_mesa;
    private int capacidad_mesa;
    private int sillas_usadas = 0;
    private List<Monstruo> monstruos;

    Mesa(int id_mesa) {
        this.nombre = "Mesa";
        this.id_mesa = id_mesa;
        this.capacidad_mesa = genera_capacidad();
    }

    public int lugares_ocupados() {
        return this.sillas_usadas;
    }

    public int lugares_desocupados(){
        return this.capacidad_mesa - lugares_ocupados();
    }

    public boolean ocupar_lugar(Monstruo cliente) {
        if (lugares_ocupados() <= capacidad_mesa) {
            monstruos.add(cliente);
            sillas_usadas++;
            return true;
        } else {
            return false;
        }
    }

    public void desocupar_lugar(int posicion) {
        sillas_usadas--;
        monstruos.remove(posicion);
    }

       public Monstruo obtener_lugar(int posicion) {
        sillas_usadas--;
        return monstruos.get(posicion);
    }

    public int get_id_mesa() {
        return this.id_mesa;
    }

    private static int genera_capacidad() {
        Random random = new Random();

        // Genera un número aleatorio entre 1 y 3 (ambos inclusive)
        int randomNumber = random.nextInt(3) + 1;

        // Multiplica por 2 para obtener 2, 4 o 6
        return randomNumber * 2;
    }

}