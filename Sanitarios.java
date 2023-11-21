public class Sanitarios {

    private Sanitario[] sanitarios;
    private SanitarioEspecial sanitarioEspecial;

    Sanitarios(){
        sanitarios = new Sanitario[4];
        for (int i = 0; i < sanitarios.length; i++) {
            sanitarios[i] = new Sanitario(i);
        }
        sanitarioEspecial = new SanitarioEspecial(0);
    }

    private boolean verificarTipo(Monstruo monstruo){
        int tipo_Monstruo = monstruo.getTipo();
        if (sanitarioEspecial.getTipoActual() == tipo_Monstruo){
            return true;
        }
        return false;
    }

    public void buscarSanitario(Monstruo monstruo) {
        int tipo = monstruo.getTipo();
        sanitarios[tipo].usarRetrete(monstruo);
    }

    public void usarSanitarioEspecial(Monstruo monstruo){
        if (sanitarioEspecial.hayRetretesDisponibles()){ // Si no hay retretes disponibles.
            if (verificarTipo(monstruo)){ // Se verifica si el monstruo puede usar el sanitario.
                sanitarioEspecial.usarRetrete(monstruo); // Usa el retrete.
            } else { // Si el monstruo no puede usar el sanitario.
                this.buscarSanitario(monstruo);
            }
        } else {
            if (verificarTipo(monstruo)){ // Se verifica si el monstruo puede formarse para usar el sanitario.
                sanitarioEspecial.formarMonstruo(monstruo); // Usa el retrete.
            } else { // Si el monstruo no puede formarse para usar el sanitario.
                this.buscarSanitario(monstruo);
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
