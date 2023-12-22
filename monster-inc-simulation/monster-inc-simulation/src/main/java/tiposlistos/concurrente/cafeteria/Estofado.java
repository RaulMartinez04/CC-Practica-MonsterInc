package tiposlistos.concurrente.cafeteria;
/**
 * Clase Estofado que implementa el comportamiento de un Platillo dentro de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Estofado extends Platillo {

    /**
     * Constructor del platillo estofado.
     */
    public Estofado() {
        this.nombre = "Estofado";
        this.cantidad_carne = 33;
        this.cantidad_vegetales = 7;
        this.identificador_platillo = 2;
    }

}