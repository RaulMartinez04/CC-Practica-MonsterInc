package com.monstersinc.vestuario;

import java.util.HashMap;
import java.util.Map;

public class Vestidor {
	
	//El vestidor sera un singleton, solo habra un vestidor en toda la simulación.
    private static final Vestidor instance = new Vestidor();
    private final Map<Integer, Casillero> casilleros = new HashMap<>();
    //private final Lock lock = new ReentrantLock();
    private final Integer noCasilleros = 50;


    private Vestidor() {
        // Inicializa el vestidor con 50 casilleros para cada tipo de monstruo
        for (int i = 0; i < noCasilleros; i++) {
            casilleros.put(i, new Casillero(i));
        }
    }
    
    public static Vestidor getInstance() {
        return instance;
    }
    
    // metodo que asigna-permite a un monstrio tener un casiillero
    // y regresa un casillero de acuerdo al id dado.
    public Casillero ingresarCasillero(int id_hilo) {
        //lock.lock();
        try {
            for (Casillero casillero : casilleros.values()) {
                if (casillero.ocuparCasillero(id_hilo)) {
                		System.out.println("Casillero Asignado");
                    return casillero;
                }
            }
            // Si no hay casillero disponible
            System.out.println("No hay casillero disponible para el monstruo " + id_hilo);
            return null;
        } finally {
            //lock.unlock();
        	System.out.println("........");
        }
    }
}
