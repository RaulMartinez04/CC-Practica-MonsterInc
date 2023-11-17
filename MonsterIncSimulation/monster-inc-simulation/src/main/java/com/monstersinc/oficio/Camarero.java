package com.monstersinc.oficio;

import com.monstersinc.cafeteria.Platillo;

/**
 * Clase Ayudante de cocina que implementa el comportamiento de un Cheff dentro
 * de la cafeteria de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Camarero implements Oficio {

    // Id del Hilo, del monstruo.
    private int id_hilo;

    /**
     * Metodo constructor de la clase camarero.
     * @param id_hilo del hilo en ejecucion.
     */
    public Camarero(int id_hilo){
       super();
       this.id_hilo = id_hilo;
    }

    @Override
    public int get_ID_Oficio() {
        return 2;
    }

    @Override
    public String get_Nombre_Oficio() {
        return "Mesero de la cafeteria";
    }

    @Override
    public String get_descripcion() {
        return "Un cheff que se dedica a ayudar al Cheff profesional de Harryhausens";
    }

    /**
     * Regresa el id del hilo en ejecucion.
     * @return id del hilo en ejecucion.
     */
    public int get_id_hilo(){
        return this.id_hilo;
    }

    public void llevar_comida(int id_mesa, Platillo platillo){
        
    }

}