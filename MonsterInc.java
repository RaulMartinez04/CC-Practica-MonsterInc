public class MonsterInc {

    public static void main(String[] args) throws InterruptedException {

        Cafeteria cafeteria = new Cafeteria();
        MonsterInc empresa = new MonsterInc();

        Monstruo cheff = new Peludos(cafeteria, "Tailon", new Chef_profesional(0, "Tailom"), 78, 67);

        Thread cheff_profesional = new Thread(cheff);
        cheff_profesional.start();

        Monstruo recepcionista = new Peludos(cafeteria, "Alberto", new Recepcionista(0, "Alberto"), 33, 70);

        Thread recepcionista_aux = new Thread(recepcionista);
        recepcionista_aux.start();

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
    }

}