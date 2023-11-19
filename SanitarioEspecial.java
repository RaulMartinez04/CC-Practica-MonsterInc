public class SanitarioEspecial extends Sanitario {

    private int tipoEspecial;

    public SanitarioEspecial(int tipo, int tipoEspecial) {
        super(tipo);
        this.tipoEspecial = tipoEspecial;
    }

    @Override
    public void usarRetrete(Monstruo monstruo) {
        if (monstruo.getTipo() == tipoEspecial) {
            // Monstruo del tipo especial, puede usar el sanitario
            if (this.retretesDisponibles > 0) {
                this.retretesDisponibles--;
                System.out.println("Monstruo " + monstruo.getId_hilo() + " del tipo " + monstruo.getTipo() + " está usando el retrete.");

                // Simular el tiempo que tarda un monstruo en usar el retrete
                try {
                    Thread.sleep(60000); // Simulación de 1 minuto
                    this.retretesDisponibles++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Sanitario lleno para Monstruo " + monstruo.getId_hilo() + " del tipo " + monstruo.getTipo() + ". Haciendo fila.");
                formarMonstruo(monstruo);
            }
        } else {
            // Monstruo de otro tipo, hacer fila normalmente
            System.out.println("Monstruo " + monstruo.getId_hilo() + " del tipo " + monstruo.getTipo() + " haciendo fila.");
            formarMonstruo(monstruo);
        }
    }
}