package com.monstersinc.cafeteria;
/**
 * Clase Sopa marucha que implementa el comportamiento 
 * de un Platillo dentro de la cafeteria de Monster Inc.
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Sopa_Marucha extends Platillo {

    /**
     * Constructor del platillo sopa marucha.
     */
    public Sopa_Marucha() {
        this.nombre = "Sopa Marucha";
        this.cantidad_carne = 10;
        this.cantidad_vegetales = 18;
        this.identificador_platillo = 1;
    }
}