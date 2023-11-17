package com.monstersinc.cafeteria;
/**
 * Interfaz Platillo que implementa el comportamiento de un Platillo dentro de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public abstract class Platillo {

    // Nombre del platillo.
    protected String nombre;

    // Identificador del platillo.
    protected int identificador_platillo;

    // Cantidad de carne.
    protected int cantidad_carne;

    // Cantidad de vegetales.
    protected int cantidad_vegetales;

    /**
     * Obten el nombre del platillo.
     * @return nombre del platillo.
     */
    protected String get_nombre_de_platillo(){
        return this.nombre;
    }

    /**
     * Cantidad de carne del platillo.
     * @return cantidad de carne.
     */
    protected int get_cantidad_de_carne(){
       return cantidad_carne;
    }

    /**
     * Cantidad de vegetales del platillo.
     * @return cantidad de vegetales.
     */
    protected int get_cantidad_de_vegetales(){
       return cantidad_vegetales;
    }

    /**
     * Cambiar nombre del platillo.
     * @param nuevo_nombre xd
     */
    protected void set_nombre_de_platillo(String nuevo_nombre){
        this.nombre = nuevo_nombre;
    }

    /**
     * Cambiar cantidad de carne requerida para el platillo.
     * @param cantidad de carne.
     */
    protected void set_cantidad_de_carne(int cantidad){
         this.cantidad_carne = cantidad;
    }

    /**
     * Cambiar cantidad de vegetales requerida para el platillo.
     * @param cantidad de vegetales.
     */
    protected void set_cantidad_de_vegetales(int cantidad){
         this.cantidad_vegetales = cantidad;
    }

    /**
     * Obtener identificador del platillo.
     * @return id del platillo.
     */
    protected int get_identificador_platillo(){
          return this.identificador_platillo;
    }

}
