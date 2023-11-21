import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase Ayudante de cocina que implementa el comportamiento de un Cheff dentro
 * de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Mesa extends Item {

    // Numero de mesa.
    private int id_mesa;

    private int capacidad_mesa;

    private int sillas_usadas = 0;

    // Monstruos en la mesa.
    private volatile List<Monstruo> monstruos;

    /**
     * Constructor de la clase Mesa.
     * @param id_mesa numero de la mesa.
     */
    Mesa(int id_mesa) {
        this.nombre = "Mesa";
        this.id_mesa = id_mesa;
        this.capacidad_mesa = genera_capacidad();
        this.monstruos = new ArrayList<>();
    }

    /**
     * Cuantos lugares estan ocupados en la mesa.
     * @return numero de lugares.
     */
    public int lugares_ocupados() {
        return this.sillas_usadas;
    }

    /**
     * Cuantos lugares estan desocupados en la mesa.
     * @return numero de lugares.
     */
    public int lugares_desocupados(){
        return this.capacidad_mesa - lugares_ocupados();
    }

    /**
     * Metodo para ocupar un lugar en la mesa.
     * @param cliente que desea ocupar el lugar.
     * @return True si pudo ocuparlo, False si no pudo ocuparlo.
     */
    public boolean ocupar_lugar(Monstruo cliente) {

        if (lugares_ocupados() < capacidad_mesa) {
            ++sillas_usadas;
            monstruos.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para desocupar un lugar de la mesa.
     * @param posicion de silla / monstruo que se va a desocupar la mesa.
     */
    public void desocupar_lugar(int posicion) {
        sillas_usadas--;
        monstruos.remove(posicion);
    }

    /**
     * Metodo que te indica que monstruo ocupa ese lugar / silla de la mesa
     * @param posicion del monstruo que se desea consultar.
     * @return Monstruo
     */
       public Monstruo obtener_lugar(int posicion) {
        sillas_usadas--;
        return monstruos.get(posicion);
    }

    /**
     * Metodo que te devuelve el numero de la mesa.
     * @return numero de la mesa.
     */
    public int get_id_mesa() {
        return this.id_mesa;
    }

    /**
     * Metodo que genera una capacidad aleatoria para la mesa.
     * @return capacidad de la mesa.
     */
    private static int genera_capacidad() {
        Random random = new Random();

        // Genera un número aleatorio entre 1 y 3 (ambos inclusive)
        int randomNumber = random.nextInt(3) + 1;

        // Multiplica por 2 para obtener 2, 4 o 6
        return randomNumber * 2;
    }

}