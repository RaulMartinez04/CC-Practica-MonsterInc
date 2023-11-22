package com.monstersinc.vestuario;

import java.util.ArrayList;

public class Casillero {
	private final int numero;
	private final ArrayList<String> cosas;
    private int idMonstruoActual = -1; // -1 indica que el casillero está libre
    //private final Lock lock = new ReentrantLock();

    public int getNumero() {
    	return this.numero;
    }
    public Casillero(int numero) {
        this.numero = numero;
        this.cosas = new ArrayList<>();
        this.cosas.add("Casco");
        this.cosas.add("Olorante");
    }
    
    @Override
	public String toString() {
		return "Casillero [numero=" + numero + ", cosas=" + cosas + ", idMonstruoActual=" + idMonstruoActual + "]";
	}

	public boolean tieneMonstruo(int idMonstruo) {
        //lock.lock();
        try {
            return idMonstruoActual == idMonstruo;
        } finally {
            //lock.unlock();
        }
    }

    /*
     * Este metodo simplemente compara el ID del monstruo 
     * actualmente asignado al casillero con el ID del 
     * monstruo proporcionado.
     * */
    public boolean ocuparCasillero(int idMonstruo) {
        //lock.lock();
        try {
            if (idMonstruoActual == -1) {
                idMonstruoActual = idMonstruo;
                System.out.println("Monstruo " + idMonstruo + " ocupa el casillero " + numero +".\n");
                return true;
            } else {
            	System.out.println("El casillero:" + numero +" esta ocupado.\n");
                return false; // Casillero ocupado
            }
        } finally {
        	System.out.println("Ocupar Casiillero Exit.\n");
            //lock.unlock();
        }
    }
    
    public void desocuparCasillero() {
        //lock.lock();
        try {
            idMonstruoActual = -1;
            System.out.println("Casillero " + numero + " desocupado.\n");
        } finally {
        	System.out.println("Error al desocupar el Casillero " + numero + ".\n");
            //lock.unlock();
        }
    }
    
    
    
    public boolean agregarElemento(String elemento) {
        if (idMonstruoActual != -1) {
            cosas.add(elemento);
            System.out.println("Elemento '" + elemento + "' añadido al casillero " + numero + ".\n");
            return true;
        } else {
            System.out.println("El casillero " + numero + " no está ocupado. No se puede añadir el elemento.\n");
            return false;
        }
    }

    public boolean retirarElemento(String elemento) {
        if (idMonstruoActual != -1) {
            if (cosas.contains(elemento)) {
                cosas.remove(elemento);
                System.out.println("Elemento '" + elemento + "' retirado del casillero " + numero + ".\n");
                return true;
            } else {
                System.out.println("El elemento '" + elemento + "' no está en el casillero " + numero + ".\n");
                return false;
            }
        } else {
            System.out.println("El casillero " + numero + " no está ocupado. No se puede retirar el elemento.\n");
            return false;
        }
    }

    public ArrayList<String> obtenerElementos() {
    	// Devuelve una copia de la lista para evitar modificaciones externas
    	return new ArrayList<>(cosas);
    }

}