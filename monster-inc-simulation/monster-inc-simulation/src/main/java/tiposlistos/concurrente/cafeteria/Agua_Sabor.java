package tiposlistos.concurrente.cafeteria;

/**
 * Clase Agua de sabor que implementa el comportamiento de un Platillo dentro de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Agua_Sabor extends Platillo {
    /**
     * Constructor del platillo agua de sabor.
     */
    public Agua_Sabor() {
        this.nombre = "Agua de sabor";
        this.cantidad_carne = 0;
        this.cantidad_vegetales = 9;
        this.identificador_platillo = 4;
    }

}