package com.monstersinc.cafeteria;
/**
 * Clase Pozole de humano que implementa el
 * comportamiento de un Platillo dentro de la 
 * cafeteria de Monster Inc.
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Pozole_humano extends Platillo {

    /**
     * Constructor del platillo pozole de humano.
     */
    public Pozole_humano() {
        this.nombre = "Pozole de humano";
        this.cantidad_carne = 48;
        this.cantidad_vegetales = 19;
        this.identificador_platillo = 3;
    }

}