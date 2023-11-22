package com.monstersinc.vestuario;

import com.monstersinc.monstruo.Peludos;
import com.monstersinc.oficio.Ayudante_cocina;
import com.monstersinc.oficio.Chef_profesional;

public class VestidorTest {

    public static void main(String[] args) {
        Vestidor vestidor = Vestidor.getInstance();

        // Crear monstruos de prueba
        Peludos monstruo1 = new Peludos(null, "Monstruo1", new Chef_profesional(0), 78, 67);
        Peludos monstruo2 = new Peludos(null, "Monstruo2", new Ayudante_cocina(1), 65, 75);

        // Simular la entrada al vestuario
        vestidor.usarVestidor(monstruo1);
        vestidor.usarVestidor(monstruo2);

        // Obtener información sobre los elementos en los casilleros
        for (int i = 0; i < 100; i++) {
            Casillero casillero = vestidor.obtenerCasillero(i);
            System.out.println("Casillero " + i + ": " + casillero.obtenerElementos());
        }

        // Simular la salida del vestuario
        vestidor.usarVestidorSalida(monstruo1);
        vestidor.usarVestidorSalida(monstruo2);

        // Obtener información sobre los elementos en los casilleros después de la salida
        for (int i = 0; i < 100; i++) {
            Casillero casillero = vestidor.obtenerCasillero(i);
            System.out.println("Casillero " + i + ": " + casillero.obtenerElementos());
        }
    }
}
