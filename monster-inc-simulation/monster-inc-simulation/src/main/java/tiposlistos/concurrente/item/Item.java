package tiposlistos.concurrente.item;
/**
 * Interfaz Item que implementa el comportamiento de un Item dentro de Monster
 * Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */

public abstract class Item {

    public int dano = 0;

    public String nombre;

    public boolean roto = false;
    
    /**
     * Regresa el dano del objeto hasta el momento.
     * 
     * @return ID del oficio.
     */
    public int get_porcentaje_de_dano() {
        return this.dano;
    }

    /**
     * Aumenta el dano del objeto hasta el momento.
     * 
     * @param dano nuevo para el objeto
     */
    public void aumentar_porcentaje_de_dano(int dano) {

        this.dano += dano;

        if (get_porcentaje_de_dano() >= 100) {
            this.roto = true;
        } else {
            this.roto = false;
        }
    }

    /**
     * Regresa el nombre del item.
     * 
     * @return nombre del item.
     */
    public String get_Nombre() {
        return this.nombre;
    }

    /**
     * Indica si el objeto esta roto.
     * 
     * @return True si esta roto, false si no esta roto.
     */
    public boolean esta_roto() {
        return this.roto;
    }

    /**
     * Resetea el estado del objeto a ceros, como una reparacion.
     */
    public void set_item(){
       this.dano = 0;
       this.roto = false;
    }

}