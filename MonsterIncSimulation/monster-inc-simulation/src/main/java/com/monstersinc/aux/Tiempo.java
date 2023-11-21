package com.monstersinc.aux;

/**
 * Clase Tiempo que te da el tiempo en vida real de ejecucion.
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Tiempo {

    /**
     * Regresa una cantidad de minutos en tiempo.
     * @param duracionMinutos nunero de minutos a usar.
     * @return minutos en milisegundos.
     */
    public static long tiempo_en_minutos(long duracionMinutos){
        return  duracionMinutos * 60 * 1000;
    }

    /**
     * Regresa el tiempo actual al momento de ser ejecutado.
     * @return
     */
    public static long tiempo_actual(){
       return System.currentTimeMillis();
    }

    /**
     * Regresa el tiempo transcurrido desde tiempoInicio.
     * @param tiempoInicio tiempo de inicio.
     * @return tiempo transcurrido.
     */
    public static long tiempo_transcurrido(long tiempoInicio){
        return System.currentTimeMillis() - tiempoInicio;
    }


}