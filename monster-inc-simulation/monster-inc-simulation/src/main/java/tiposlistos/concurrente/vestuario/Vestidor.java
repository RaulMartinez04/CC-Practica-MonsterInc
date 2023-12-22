package tiposlistos.concurrente.vestuario;

import java.util.HashMap;
import java.util.Map;

import tiposlistos.concurrente.monstruo.Monstruo;

public class Vestidor {
	
	//El vestidor sera un singleton, solo habra un vestidor en toda la simulación.
    private static final Vestidor instance = new Vestidor();
    private final Map<Integer, Casillero> casilleros = new HashMap<>();
    //private final Lock lock = new ReentrantLock();
    private final Integer noCasilleros = 100;


    private Vestidor() {
        // Inicializa el vestidor con 50 casilleros para todos los monstruos
        for (int i = 50; i < noCasilleros; i++) {
            casilleros.put(i, new Casillero(i));
        }
    }
    
    public static Vestidor getInstance() {
        return instance;
    }
    
    public Casillero obtenerCasillero(int idMonstruo) {
    	for (Casillero casillero : casilleros.values()) {
            if (casillero.tieneMonstruo(idMonstruo)) {
            	System.out.println("YA sirve el obtenerCas");
                return casillero;
            }
        }
        System.out.println("No se encontró el casillero para el monstruo con ID: " + idMonstruo);
        return null;
    	
        //return casilleros.get(idMonstruo);
    }

    
    // metodo que asigna-permite a un monstrio tener un casiillero
    // y regresa un casillero de acuerdo al id dado.
    public Casillero asignarCasillero(int id_hilo) {
        //lock.lock();
        try {
            for (Casillero casillero : casilleros.values()) {
            	// primero asignamos un casillero
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
    
    public boolean tieneCasilleroAsignado(int idMonstruo) {
        for (Casillero casillero : casilleros.values()) {
            if (casillero.tieneMonstruo(idMonstruo)) {
                return true; // El monstruo ya tiene un casillero asignado
            }
        }
        return false; // El monstruo no tiene ningún casillero asignado
    }
    
    /*
     * Metodo que simula la entrada y salida a un vestidor
     * */
    public void usarVestidor(Monstruo monstruo){
        //usarSanitarioEspecial(monstruo);
    	Casillero cas = new Casillero(0);
    	// monstruo.getId_hilo()
    	
    	System.out.println("El monstruo " + monstruo.getNombre() +
    						" con el id: " + monstruo.getId_hilo()+" a entrado al vestidor");
    	//verificamos si tiene un casillero asignado
    	if (this.tieneCasilleroAsignado(monstruo.getId_hilo())) {
    		cas= this.obtenerCasillero(monstruo.getId_hilo());
    	} else {
    		// si no le asignamos uno 
    		cas= this.asignarCasillero(monstruo.getId_hilo());
    	}
    	// hasta aqui ya tenemos un casillero asignado, por lo que si no es null
    	if (cas != null) {
            // Realizar acciones en el vestuario
    		System.out.println( monstruo.getNombre()+ " está en su casillero: "+cas.getNumero());
            // Es la manera más simple que encontré de simular que algo está tomando tiempo
    		// PERO COMO OBTENGO que EL HILO CON EL ID_HILO se duerma? 
            
    		//Thread.sleep(1000); // Simulación de tiempo en el vestidor
    		
    		System.out.println( monstruo.getNombre() + " dejara sus cosas personales...\n");
    		cas.agregarElemento("Cosas Personales");
    		//Thread.sleep(1000); // Simulación de tiempo en el vestidor
    		
    		System.out.println(monstruo.getNombre() + " toma del casillero y se pone olorante y su casco\n");
    		cas.retirarElemento("Casco");
    		cas.retirarElemento("Olorante");
    		System.out.println(monstruo.getNombre() + " vuelve a guardar el olorante en su casillero\n");
    		//cas.agregarElemento("Casco");
    		cas.agregarElemento("Olorante");
            
    		// Al salir del vestuario, tiene que salir del casillero. 
            //cas.salirCasillero();
    		System.out.println( monstruo.getNombre()+ " cerro su casillero y salio del vestuario.");
    		
        }
    }
    
    /*
     * Metodo que simula la entrada y salida a un vestidor
     * */
    public void usarVestidorSalida(Monstruo monstruo){
        //usarSanitarioEspecial(monstruo);
    	Casillero cas = new Casillero(0);
    	// monstruo.getId_hilo()
    	
    	System.out.println("El monstruo " + monstruo.getNombre() +
    						" con el id:" + monstruo.getId_hilo()+" a entrado al vestidor despues de una larga jornada de trabajo.");
    	if (this.tieneCasilleroAsignado(monstruo.getId_hilo())) {
    		System.out.println("True in tiene Casillero asignado");
    		cas= this.obtenerCasillero(monstruo.getId_hilo());
    	} else {
    		System.out.println("False in tiene Casillero asignado");
    		cas= this.asignarCasillero(monstruo.getId_hilo());
    	}
    	System.out.println(cas);
    	// hasta aqui ya tenemos un casillero asignado, por lo que si no es null
    	if (cas != null) {
            // Realizar acciones en el vestuario
    		System.out.println( monstruo.getNombre()+ " está en su casillero: "+cas.getNumero());
            // Es la manera más simple que encontré de simular que algo está tomando tiempo
    		// PERO COMO OBTENGO que EL HILO CON EL ID_HILO se duerma? 
    		// Simulación de tiempo en el vestidor
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    		
    		System.out.println(monstruo.getNombre() + " guarda en el casillero y deja su casco.\n");
    		cas.agregarElemento("Casco");
    		
    		System.out.println( monstruo.getNombre() + " tomara sus cosas personales...\n");
    		cas.retirarElemento("Cosas Personales");
    		//Thread.sleep(1000); // Simulación de tiempo en el vestidor
            
    		// Al salir del vestuario, tiene que salir del casillero. 
            //cas.salirCasillero();
    		System.out.println( monstruo.getNombre()+ " cerro su casillero y salio del vestuario listo para salir de Monster Inc.");
    		
        }
    }
    
    
}
