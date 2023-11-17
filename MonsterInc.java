public class MonsterInc {

    public static void main(String[] args) throws InterruptedException {

        Cafeteria cafeteria = new Cafeteria();
        MonsterInc empresa = new MonsterInc();

        // Cheff profesional
        Monstruo cheff = new Peludos(cafeteria, "Tailon", new Chef_profesional(0, "Tailom"), 78, 67);
        Thread cheff_profesional = new Thread(cheff);
        cheff_profesional.start();

        // Recepcionista
        Monstruo recepcionista = new Peludos(cafeteria, "Alberto", new Recepcionista(0, "Alberto"), 33, 70);
        Thread recepcionista_aux = new Thread(recepcionista);
        recepcionista_aux.start();

        //Ayudantes de cocina.
        Thread[] ayudantes_de_cocina = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Peludos ayudante_aux = new Peludos(cafeteria, "Monstruo" + i, new Ayudante_cocina(i, "Monstruo" + i),
                    i * 10, (i * 20) + 100);
            ayudantes_de_cocina[i] = new Thread(ayudante_aux);
            ayudantes_de_cocina[i].start();
        }

        cheff_profesional.join();
        cheff_profesional.join();

        for (int i = 0; i < 5; i++) {
            ayudantes_de_cocina[i].join();
        }

      //  Thread.sleep(2000);

        // Clientes
        Thread[] clientes = new Thread[6];
        for (int i = 0; i < 6; i++) {
            Peludos cliente = new Peludos(cafeteria, "Monstruo" + i, new Camarero(i),
                    i * 10, (i * 20) + 100);
            clientes[i] = new Thread(cliente);
            clientes[i].start();
        }

        for (int i = 0; i < 6; i++) {
            clientes[i].join();
        }

    }

}