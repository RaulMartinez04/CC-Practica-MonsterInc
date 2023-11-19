import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase Cafeteria de Monster Inc.
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Cafeteria {

    // Lista de platillos que puede cocinar el cheff profesional
    private Platillo[] lista_profesional = { new Hamburguesa(), new Agua_Sabor(), new Estofado(), new Sopa_Marucha(),
            new Pozole_humano() };

    // Lista de platillos que puede cocinar los ayudantes de cocina.
    private Platillo[] lista_normal = { new Hamburguesa(), new Agua_Sabor(), new Estofado(), new Sopa_Marucha() };

    // El inventario que maneja la cocina.
    private AtomicInteger inventario[] = { new AtomicInteger(), new AtomicInteger() };

    // Total de clientes que se pueden admitir en la cafeteria (en desuso)
    // private final int TOTAL_CLIENTES = 1000;

    // Clientes actuales en la cafeteria (en desuso)
    private AtomicInteger clientes_actuales = new AtomicInteger(0);

    // Lista de mesas de la cafeteria.
    private volatile List<Mesa> lista_De_Mesas = new ArrayList<>();

    // Bandera que indica si el cheff ya esta listo para iniciar el dia.
    private volatile boolean listo_Cheff_profesional = false;

    // Bandera que indica si el recepcionista ya esta listo para iniciar el dia.
    private volatile boolean listo_recepcionista = false;

    // Semaforo para editar la lista de espera.
    private Semaphore semaforo1 = new Semaphore(1);

    // Lista de clientes en espera para ser atendidos en la cafeteria.
    private volatile List<Monstruo> lista_de_espera = new ArrayList<>();

    /**
     * Constructor de la clase cafeteria.
     */
    public Cafeteria() {
        clientes_actuales.set(0);
    }

    /**
     * Metodo que genera un platillo al azar de la lista de platillos pasada.
     * 
     * @param lista de platillos
     * @return platillo que se puede generar de la lista
     */
    private Platillo genera_Comida(Platillo[] lista) {
        Random random = new Random();
        int posicion = random.nextInt(lista.length);
        return lista[posicion];
    }

    private void ayudante_comportamiento(Monstruo monstruo, long tiempoInicio, long minutos)
            throws InterruptedException {

        // Indicas que llegaste a la cafeteria.
        System.out.println(ColorsAthena.rojo("El cocinero ayudante " + monstruo.nombre + " llega a la cafeteria"));
        Ayudante_cocina ayudante = new Ayudante_cocina(monstruo.id_hilo);
        ayudante.set_lista_platillos(lista_normal);

        // Si llegas temprano esperas a que este listo tu jefe y el recepcionista.
        while (!listo_recepcionista && !listo_Cheff_profesional) {
        }

        // Atiendes a los clientes que van llegando.

        while (Tiempo.tiempo_transcurrido(tiempoInicio) < Tiempo.tiempo_en_minutos(minutos)) {

            // Para simulacion
            Thread.sleep(3000);
            semaforo1.acquire();
            for (int g = 0; g < lista_De_Mesas.size(); g++) {
                if (lista_De_Mesas.get(g).lugares_ocupados() != 0) {
                    for (int j = 0; j <= lista_De_Mesas.get(g).lugares_ocupados(); j++) {
                        Platillo platillo = genera_Comida(lista_normal);
                        System.out.println(ColorsAthena.rojo("El camarero " + ayudante.get_id_hilo() + " atiende a " +
                                lista_De_Mesas.get(g).obtener_lugar(j).nombre + " y recoge su pedido."));
                        ayudante.preparar_comida(platillo.identificador_platillo, inventario, monstruo.nombre);
                        System.out.println(ColorsAthena.rojo(
                                "El monstruo " + lista_De_Mesas.get(g).obtener_lugar(j).nombre +
                                        " fue atendido por el camarero " + ayudante.get_id_hilo()));
                        lista_De_Mesas.get(g).desocupar_lugar(j);
                    }
                }
            }
            semaforo1.release();
            // Para simulacion.
        }
    }

    /**
     * Metodo que simula el comportamiento de un cheff profesional.
     * 
     * @param monstruo     cheff profesional
     * @param tiempoInicio del dia.
     * @param minutos      a trabajar durante el dia.
     * @throws InterruptedException
     */
    private void cheff_comportamiento(Monstruo monstruo, long tiempoInicio, long minutos) throws InterruptedException {
        // Prepara lo necesario antes de abrir la cafeteria.
        System.out.println(ColorsAthena.rojo("El cheff profesional " + monstruo.nombre + " abre la cafeteria"));
        Chef_profesional aux = new Chef_profesional(monstruo.id_hilo);
        aux.set_lista_platillos(lista_profesional);
        aux.llenar_Inventario(this.inventario, 0);
        aux.llenar_Inventario(this.inventario, 1);
        System.out.println(ColorsAthena.rojo("El cheff profesional " + monstruo.nombre
                + " llena de alimentos el Inventario, con 1000 de carne y 1000 de vegetales"));

        // Indicas que estas listo para empezar con el dia.
        listo_Cheff_profesional = true;

        // Esperas a que el recepcionista este listo.
        while (!listo_recepcionista) {
        }

        // Atiendes a los clientes que van llegando.

        while (Tiempo.tiempo_transcurrido(tiempoInicio) < Tiempo.tiempo_en_minutos(minutos)) {

            // Para simulacion.
            Thread.sleep(3000);
            semaforo1.acquire();
            for (int g = 0; g < lista_De_Mesas.size(); g++) {
                if (lista_De_Mesas.get(g).lugares_ocupados() != 0) {
                    for (int j = 0; j <= lista_De_Mesas.get(g).lugares_ocupados(); j++) {
                        Platillo platillo = genera_Comida(lista_normal);
                        System.out.println(ColorsAthena.rojo("El camarero " + aux.get_id_hilo() + " atiende a " +
                                lista_De_Mesas.get(g).obtener_lugar(j).nombre + " y recoge su pedido."));
                        aux.preparar_comida(platillo.identificador_platillo, inventario, monstruo.nombre);
                        System.out.println(ColorsAthena.rojo(
                                "El monstruo " + lista_De_Mesas.get(g).obtener_lugar(j).nombre +
                                        " fue atendido por el camarero " + aux.get_id_hilo()));
                        lista_De_Mesas.get(g).desocupar_lugar(j);
                    }
                }
            }
            semaforo1.release();
        }
    }

    /**
     * Metodo que simula el comportamiento de un recepcionista.
     * 
     * @param monstruo     recepcionista
     * @param tiempoInicio del dia.
     * @param minutos      a trabajar durante el dia.
     * @throws InterruptedException
     */
    private void recepcionista_comportamiento(Monstruo monstruo, long tiempoInicio, long minutos)
            throws InterruptedException {
        // Llegas y preparas lo necesario para iniciar el dia.
        Recepcionista recepcionista = new Recepcionista(monstruo.id_hilo);
        System.out.println(ColorsAthena.rojo("El recepcionista " + monstruo.nombre
                + " llega a la cafeteria y asigna las siguientes mesas: "));
        for (int j = 0; j < 5; j++) {
            Mesa mesa_aux = new Mesa(j);
            System.out.println(ColorsAthena.rojo("Mesa " + j + " con capacidad de " + mesa_aux.lugares_desocupados()));
            lista_De_Mesas.add(mesa_aux);
        }

        // Indicas que ya estas listo para iniciar el dia.
        listo_recepcionista = true;

        // Esperas a que el cheff profesional este listo tambien.
        while (!listo_Cheff_profesional) {
        }

        // Atiendes a los clientes que estan en espera para asignarles un lugar de la
        // cafeteria.
        while (Tiempo.tiempo_transcurrido(tiempoInicio) < Tiempo.tiempo_en_minutos(minutos)) {

            semaforo1.acquire();

            for (int j = 0; j < lista_de_espera.size(); j++) {
                if (recepcionista.asignar_lugar(lista_de_espera.get(j), lista_De_Mesas)) {
                    lista_de_espera.remove(j);
                    break;
                } else {
                    System.out.println(ColorsAthena.rojo("Ya no hay lugares en la cafeteria, regresa pronto monstruo "
                            + lista_de_espera.get(j).nombre));
                }
            }
            semaforo1.release();

            // Para simulacion.
            Thread.sleep(1000);
        }
    }

    /**
     * Metodo que simula el comportamiento de un cliente
     * 
     * @param monstruo cliente.
     * @throws InterruptedException
     */
    private void cliente_comportamiento(Monstruo monstruo) throws InterruptedException {
        // Te metes a la fila de espera.
        System.out.println(ColorsAthena.rojo("El monstruo " + monstruo.nombre
                + " llega a la cafeteria a comer"));

        // Para simulacion.
        Thread.sleep(100);

        semaforo1.acquire();
        lista_de_espera.add(monstruo);
        semaforo1.release();
    }

    /**
     * Simulacion del comportamiento de la cafeteria, que pasa si entra un monstruo
     * x?
     * 
     * @param monstruo a entrar a la cafeteria.
     * @throws InterruptedException
     */
    public void entrar_cafeteria(Monstruo monstruo) throws InterruptedException {

        // Tiempo inicial desde que se ejecuto la cafeteria
        long tiempoInicio = Tiempo.tiempo_actual();

        // Division del comportamiento del monstruo.
        switch (monstruo.trabajo.get_ID_Oficio()) {

            // Si es cheff profesional hara esto:
            case 3:
                cheff_comportamiento(monstruo, tiempoInicio, 2);
                break;

            // Si es ayudante hara esto:
            case 0:
                ayudante_comportamiento(monstruo, tiempoInicio, 2);
                break;

            // Si es recepcionista hara esto:
            case 1:
                recepcionista_comportamiento(monstruo, tiempoInicio, 2);
                break;

            // Si es cualquier otro monstruo distinto al persnal.
            default:
                cliente_comportamiento(monstruo);
                break;
        }
    }

}