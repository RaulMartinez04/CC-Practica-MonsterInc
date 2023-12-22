package tiposlistos.concurrente.cafeteria;
/**
 * Clase hamburguesa que implementa el comportamiento de un Platillo dentro de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Hamburguesa extends Platillo {

    /**
     * Constructor del platillo hamburguesa.
     */
    public Hamburguesa() {
        this.nombre = "Hamburguesa";
        this.cantidad_carne = 25;
        this.cantidad_vegetales = 14;
        this.identificador_platillo = 0;
    }

}