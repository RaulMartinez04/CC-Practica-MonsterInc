package com.monstersinc.monstruo;
import java.util.Random;

import com.monstersinc.cafeteria.Cafeteria;
import com.monstersinc.oficio.Oficio;
import com.monstersinc.vestuario.Casillero;
import com.monstersinc.vestuario.Vestidor;

import lombok.Data;

/**
 * Clase Monstruo que implementa el comportamiento de un Monstruo dentro
 * de Monster Inc
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
@Data
public abstract class Monstruo implements Runnable {

    // Nombre del monstruo.
    private String nombre;
    // Tipo de monstruo.
    private int tipo;

    // Trabajo del monstruo.
    private Oficio trabajo;

    public int getTipo() {
		return tipo;
	}

	public int getId_hilo() {
		return id_hilo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setId_hilo(int id_hilo) {
		this.id_hilo = id_hilo;
	}

	// ID del hilo.
    private int id_hilo;

    // Peso del monstruo.
    private double peso;

    // Altura del monstruo.
    private double altura;

    private Cafeteria cafeteria;
    
    private Vestidor vestidor; 

    public Monstruo(Cafeteria cafeteria, String nombre, Oficio trabajo,
    				int numCasillero, String passCasillero) {
        this.cafeteria = cafeteria;
        this.cafeteria = cafeteria;
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.id_hilo = ThreadID.get();
    }

    // Método toString para imprimir bonito
    @Override
    public String toString() {
        return "Monstruo{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", id ='" + id_hilo + '\'' +
                ", peso=" + peso + '\'' +
                ", altura=" + altura+ '\'' +
                '}';
    }
    
    /**
     * Decide que hacer el monstruo.
     * 
     * @return 0 ir al sanitario, 1 ir a comer, 2 ir a trabajar (Con mas
     *         probabilidades de ir a trabajar).
     */
    public int decidir_que_hacer() {
        Random random = new Random();

        // Genera un número aleatorio entre 0 y 9
        int numeroRandom = random.nextInt(9);

        // Si el número generado es menor o igual que 5, devuelve 2
        if (numeroRandom <= 5) {
            return 2;
        } else {
            // Si no, devuelve el número aleatorio normal (0 o 1)
            return random.nextInt(2);
        }
    }

    /**
     * Simulacion del monstruo al ir a comer.
     * 
     * @throws InterruptedException
     */
    public void ir_a_comer() throws InterruptedException {
        cafeteria.entrar_cafeteria(this);
    }

    /**
     * Simulacion del monstruo al ir al sanitario.
     */
    public void ir_al_sanitario() {

    }

    /**
     * Simulacion del monstruo al ir al vestuario.
     */
    public void ir_al_vestuario() {
    	Casillero casillero = vestidor.ingresarCasillero(this.id_hilo);
    	if (casillero != null) {
            // Realizar acciones en el vestuario
            
    		System.out.println(this.nombre + " está en el vestidor...");
            // Es la manera más simple que encontré de simular que algo está tomando tiempo
    		// PERO COMO OBTENGO EL HILO CON EL ID_HILO? 
            //Thread.sleep(1000); // Simulación de tiempo en el vestidor
    		
    		System.out.println(this.nombre + " Dejara sus cosas personales...\n");
    		//Thread.sleep(1000); // Simulación de tiempo en el vestidor
    		
    		System.out.println(this.nombre + " se pone olorante y su casco...\n");
            // Al salir del vestuario, desocupar el casillero
            casillero.desocuparCasillero();
        }
    }

    /**
     * Simulacion del monstruo de ir a trabajar.
     * 
     * @throws InterruptedException
     */
    public void ir_a_trabajar() throws InterruptedException {
        switch (this.trabajo.get_ID_Oficio()) {

            // Eres un cheff profesional, ve a la cafeteria.
            case 3:
                cafeteria.entrar_cafeteria(this);
                break;

            // Eres un ayudante de cocina, ve a la cafeteria.
            case 0:
                cafeteria.entrar_cafeteria(this);
                break;

            // Eres un recepcionista, ve a la cafeteria.
            case 1:
                cafeteria.entrar_cafeteria(this);

            default:
                System.out.println("Algo no se esta asignando bienn )):");
                break;
        }
    }

    public static class ThreadID {
        private static volatile int nextID = 0;
        private static ThreadLocal<Integer> threadID = ThreadLocal.withInitial(() -> nextID++);

        public static int get() {
            return threadID.get();
        }
    }

    /**
     * Simulacion del Monstruo dentro de la empresa Monster Inc
     */
    @Override
    public void run() {

        // Antes debe ir al vestuario.

        int iterador = 0;

        // Para monstruos que deben trabajar de ahuevo.
        if (this.trabajo.get_ID_Oficio() == 3 || this.trabajo.get_ID_Oficio() == 0
                || this.trabajo.get_ID_Oficio() == 1) {
            try {
                ir_a_trabajar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
          // Hay algo raro aqui
            while (iterador == 1) {
                // switch (decidir_que_hacer()) {
                switch (decidir_que_hacer()) {
                    case 0:
                        System.out.println("En mantenimiento muacckkk");
                        break;

                    case 1:

                        try {
                            ir_a_comer();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        break;

                    case 2:

                        try {
                            ir_a_trabajar();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        break;

                    default:
                        break;
                }
            }

        }
        // Debe ir al vestuario antes de irse.

    }
}