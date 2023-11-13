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
    private Monstruo[] monstruos; // Cambiar a algo de tipo cola o nodos.
    private int iterador = 0; // Lo mismo

    Mesa(int id_mesa, int capacidad_mesa) {
        this.nombre = "Mesa";
        this.id_mesa = id_mesa;
        this.capacidad_mesa = capacidad_mesa;
        this.monstruos = new Monstruo[capacidad_mesa];
    }

    public int lugares_disponibles(){
        return this.sillas_usadas;
    }

    public boolean ocupar_lugar(Monstruo cliente){
       if(lugares_disponibles() <= capacidad_mesa){
          monstruos[iterador] = cliente;
          iterador++;
          sillas_usadas++;
          return true;
       } else {
        return false;
       }
    }

    public void desocupar_lugar(int posicion) {
        sillas_usadas--;
        monstruos[posicion] = null; //Checar una mejor implementacion.
    }

}