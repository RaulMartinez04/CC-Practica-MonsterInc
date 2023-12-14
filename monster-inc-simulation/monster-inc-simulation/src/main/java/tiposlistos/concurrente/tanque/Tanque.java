package com.monstersinc.tanque;

import java.util.concurrent.atomic.AtomicLong;

public class Tanque {
	// Tipos de tanque
	//capacidad para N unidades de energia
	public static final String ESTANDAR = "Estandar";
	//capacidad de M tanques estandar.
    public static final String MAXITANQUE = "Maxitanque";
    // Ultratanque, tiene capacidad de L Maxitanques.
    public static final String ULTRATANQUE = "Ultratanque";
    // tiene capacidad de 2H ultratanques.
    public static final String GIGATANQUE = "Gigatanque";
    
    /*
     *  se asigna un ID único obtenido a partir de ID_GENERATOR.getAndIncrement(). 
     *  AtomicLong garantiza la atomicidad de la operación de incremento
     * */
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);
    private Long id;
    
	// Capacidad en unidades de energía
	private int capacidad;
	// Tipo de tanque (Estandar, Maxitanque, Ultratanque, GigaTanque)
	private String tipo;
	// Varia en el tiempo
	private int tiempoFabricacion;   
	// Estado del tanque (En uso, en reparacion, disponible) NO SE PUEDE SOLO CON UNA VARIABLE?
	//private String estado; 
	private boolean enUso;
	private boolean enReparacion;
	private boolean disponible;
	private boolean roto;
	private int usos;

	public Tanque(String tipo, int tiempoFabricacion) {
		//super();
		this.id = ID_GENERATOR.getAndIncrement();
		this.tipo = tipo;
		this.tiempoFabricacion = tiempoFabricacion;
		this.enUso = false;
		this.enReparacion = false;
		this.roto = false;
		this.disponible = true;
		this.usos = 0;
	}
}