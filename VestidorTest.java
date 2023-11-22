public class VestidorTest {

    public static void main(String[] args) throws InterruptedException {
        Vestidor vestidor = Vestidor.getInstance();

        // Crear monstruos de prueba
        
        //Monstruo cheff = new Peludos(cafeteria, "Tailon", new Chef_profesional(0), 78, 67);
        //Thread cheff_profesional = new Thread(cheff);
        //cheff_profesional.start();
        Peludos monstruo1 = new Peludos(null, "Monstruo1", new Chef_profesional(1), 78, 67);
        Thread cheff_profesional = new Thread(monstruo1);
       
        
        Peludos monstruo2 = new Peludos(null, "Monstruo2", new Ayudante_cocina(2), 65, 75);
        Thread ayudante= new Thread(monstruo2);
        ayudante.start();
        cheff_profesional.start();
        
        System.out.println("Monstruo1 con id_hilo: " +monstruo1.getId_hilo() + " esta presente");
        System.out.println("Monstruo2 con id_hilo: " +monstruo2.getId_hilo() + " esta presente");
        
        // Simular la entrada al vestuario
        System.out.println("Monstruo1 con id_hilo: " +monstruo1.getId_hilo() + ": USARVESTIDOR");
        vestidor.usarVestidor(monstruo1);
        Thread.sleep(1000);
        
        System.out.println("Monstruo2 con id_hilo: " +monstruo2.getId_hilo() + ": USARVESTIDOR");
        vestidor.usarVestidor(monstruo2);
        Thread.sleep(1000);
        //Obtener información sobre los elementos en los casilleros
        for (int i = 0; i < 2; i++) {
            Casillero casillero = vestidor.obtenerCasillero(i);
            System.out.println("Casillero " + i + ": " + casillero.obtenerElementos());
        }

        // Simular la salida del vestuario
        vestidor.usarVestidorSalida(monstruo1);
        vestidor.usarVestidorSalida(monstruo2);

        // Obtener información sobre los elementos en los casilleros después de la salida
        //for (int i = 0; i < 1; i++) {
          //  Casillero casillero = vestidor.obtenerCasillero(i);
            //System.out.println("Casillero " + i + ": " + casillero.obtenerElementos());
        //}
    }
}
