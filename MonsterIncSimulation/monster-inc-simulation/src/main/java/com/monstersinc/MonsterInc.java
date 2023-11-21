package com.monstersinc;

import com.monstersinc.cafeteria.Cafeteria;
import com.monstersinc.monstruo.Monstruo;
import com.monstersinc.monstruo.Peludos;
import com.monstersinc.oficio.Ayudante_cocina;
import com.monstersinc.oficio.Camarero;
import com.monstersinc.oficio.Chef_profesional;
import com.monstersinc.oficio.Recepcionista;

public class MonsterInc {

    public static void main(String[] args) throws InterruptedException {

        Cafeteria cafeteria = new Cafeteria();

        // Cheff profesional
        Monstruo cheff = new Peludos(cafeteria, "Tailon", new Chef_profesional(0), 78, 67);
        Thread cheff_profesional = new Thread(cheff);
        cheff_profesional.start();

        // Recepcionista
        Monstruo recepcionista = new Peludos(cafeteria, "Alberto", new Recepcionista(0), 33, 70);
        Thread recepcionista_aux = new Thread(recepcionista);
        recepcionista_aux.start();

        // Ayudantes de cocina.
        Thread[] ayudantes_de_cocina = new Thread[5];
        for (int i = 0; i < ayudantes_de_cocina.length; i++) {
            Peludos ayudante_aux = new Peludos(cafeteria, "Monstruo" + i, new Ayudante_cocina(i),
                    i * 10, (i * 20) + 100);
            ayudantes_de_cocina[i] = new Thread(ayudante_aux);
            ayudantes_de_cocina[i].start();
        }

        // Clientes
        Thread[] clientes = new Thread[5];
        for (int i = 0; i < clientes.length; i++) {
            Peludos cliente = new Peludos(cafeteria, "Monstruo" + i, new Camarero(i),
                    i * 10, (i * 20) + 100);
            clientes[i] = new Thread(cliente);
            clientes[i].start();
        }

        // Thread.sleep(10000);

        for (int i = 0; i < clientes.length; i++) {
            clientes[i].join();
        }

        for (int i = 0; i < ayudantes_de_cocina.length; i++) {
            ayudantes_de_cocina[i].join();
        }

        cheff_profesional.join();
        cheff_profesional.join();

    }

}
