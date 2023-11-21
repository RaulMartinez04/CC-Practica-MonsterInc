import java.util.LinkedList;
import java.util.Queue;

public class Sanitario {

	protected int tipo;

	protected volatile int retretesDisponibles;

	protected Queue<Monstruo> fila;

	/**
	 * @param tipo 
	 */
	public Sanitario (int tipo) {
		this.tipo = tipo;
		this.retretesDisponibles = 5;
		this.fila = new LinkedList<>();
	}

	// Método que verifica si hay retretes disponibles.
	public boolean hayRetretesDisponibles(){
		return retretesDisponibles > 0;
	}


	/**
	 * @param monstruo Objeto de clase Monstruo, el cual es el monstruo a formar.
	 */
	public void formarMonstruo(Monstruo monstruo){
		// Si no hay retretes disponibles, el monstruo se tiene que formar.
		if (!hayRetretesDisponibles()) {
			this.fila.add(monstruo);
		} else {
			// Si hay retretes disponibles, el primer monstruo de la fila puede utilizar un retrete.
			Monstruo monstruoEnFila = this.fila.poll(); // Obtener el primer monstruo de la fila
			if (monstruoEnFila != null) {
				// El primer monstruo de la fila utiliza un retrete
				this.usarRetrete(monstruoEnFila);
			}
		}
	}

	
	/**
	 * @param monstruo Objeto de clase Monstruo, el cual es el monstruo a formar.
	 */
	public void usarRetrete(Monstruo monstruo){
		if (hayRetretesDisponibles()){
			this.retretesDisponibles--;
			System.out.println("Monstruo " + monstruo.getId_hilo() + " está usando uno de los retretes.");

			// Simular el tiempo que tarda un monstruo en usar el retrete.
            try {
                Thread.sleep(60000); // Simulación de 1 minuto.
				this.retretesDisponibles++;
				System.out.println("Monstruo " + monstruo.getId_hilo() + " dejó de usar uno de los retretes.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}else {
			// Si no hay retretes disponibles el monstruo procede a formarse.
			System.out.println("Sanitario lleno, el Monstruo " + monstruo.getId_hilo() + " procede a formarse.");
			formarMonstruo(monstruo);
		}
	}
}