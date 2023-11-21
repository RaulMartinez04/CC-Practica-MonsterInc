package com.monstersinc.bannos;

import com.monstersinc.monstruo.Monstruo;

public class SanitarioEspecial extends Sanitario {

    private int tipoActual;

    public SanitarioEspecial(int tipo) {
        super(tipo);
    }

    /* Getters y Setters necesarios. */

    /**
     * @return El tipo actual del sanitario.
     */
    public int getTipoActual() {
        return tipoActual;
    }
 
    @Override
    public void usarRetrete(Monstruo monstruo) {
        int tipo_Monstruo = monstruo.getTipo();
        if (retretesDisponibles == 5){
            this.tipoActual = tipo_Monstruo;
        }
        super.usarRetrete(monstruo);
    }
}