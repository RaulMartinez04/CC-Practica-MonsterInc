public class Sanitarios {

    public static void main(String[] args) {
        // Crear instancias de los sanitarios
        Sanitario sanitario1 = new Sanitario(1);
        Sanitario sanitario2 = new Sanitario(2);
        SanitarioEspecial sanitarioEspecial = new SanitarioEspecial(3, 4);

        //Faltan inicializar los monstruos.

        // Crear hilos para simular la concurrencia
        Thread hiloMonstruo1 = new Thread(() -> sanitario1.usarRetrete(monstruo1));
        Thread hiloMonstruo2 = new Thread(() -> sanitario2.usarRetrete(monstruo2));
        Thread hiloMonstruo3 = new Thread(() -> sanitarioEspecial.usarRetrete(monstruo3));
        Thread hiloMonstruo4 = new Thread(() -> sanitarioEspecial.usarRetrete(monstruo4));

        // Iniciar los hilos
        hiloMonstruo1.start();
        hiloMonstruo2.start();
        hiloMonstruo3.start();
        hiloMonstruo4.start();

        // Esperar a que todos los hilos terminen
        try {
            hiloMonstruo1.join();
            hiloMonstruo2.join();
            hiloMonstruo3.join();
            hiloMonstruo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
