import java.util.LinkedList;
import java.util.Queue;

public class Sanitario {

	protected int tipo;

	protected int retretesDisponibles;

	protected Queue<Monstruo> fila;

	/**
	 * @param tipo 
	 */
	public Sanitario (int tipo) {
		this.tipo = tipo;
		this.retretesDisponibles = 5;
		this.fila = new LinkedList<>();
	}

	public void formarMonstruo(Monstruo monstruo){
		this.fila.add(monstruo);
	}

	public void usarRetrete(Monstruo monstruo){
		if (this.retretesDisponibles > 0){
			this.retretesDisponibles--;
			System.out.println("Monstruo " + monstruo.getId_hilo() + " está usando el retrete.");

			// Simular el tiempo que tarda un monstruo en usar el retrete
            try {
                Thread.sleep(60000); // Simulación de 1 minuto
				this.retretesDisponibles++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		System.out.println("Sanitario lleno, tienes que hacer fila.");
		formarMonstruo(monstruo);
	}

	public int getRetretesDisponibles() {
		return retretesDisponibles;
	}

	public void setRetretesDisponibles(int retretesDisponibles) {
		this.retretesDisponibles = retretesDisponibles;
	}

	public Queue<Monstruo> getFila() {
		return fila;
	}

	public void setFila(Queue<Monstruo> fila) {
		this.fila = fila;
	}
	
}