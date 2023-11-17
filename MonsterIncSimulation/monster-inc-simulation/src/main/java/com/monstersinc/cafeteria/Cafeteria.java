package com.monstersinc.cafeteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import com.monstersinc.monstruo.Monstruo;

/**
 * Clase Cafeteria de Monster Inc.
 * 
 * @author Villanueva Garcia Israel. No. 317052147
 * @since Computo Concurrente.
 */
public class Cafeteria {

    private Platillo[] lista_profesional = { new Hamburguesa(), new Agua_Sabor(), new Estofado(), new Sopa_Marucha(),
            new Pozole_humano() };
    private Platillo[] lista_normal = { new Hamburguesa(), new Agua_Sabor(), new Estofado(), new Sopa_Marucha() };
    private AtomicInteger inventario[] = { new AtomicInteger(), new AtomicInteger() };
    private final int TOTAL_CLIENTES = 1000;
    private AtomicInteger clientes_actuales = new AtomicInteger(0);
    private volatile List<Mesa> lista_De_Mesas = new ArrayList<>();
    private volatile boolean listo_Cheff_profesional = false;
    private volatile boolean listo_recepcionista = false;
    private Semaphore semaforo1 = new Semaphore(1);
    private Semaphore semaforo2 = new Semaphore(1);
    private volatile List<Monstruo> lista_de_espera;

    public Cafeteria() {
        clientes_actuales.set(0);
    }

    private Platillo genera_Comida(Platillo[] lista) {
        Random random = new Random();
        int posicion = random.nextInt(lista.length);
        return lista[posicion];
    }

    public void entrar_cafeteria(Monstruo monstruo) throws InterruptedException {
        switch (monstruo.trabajo.get_ID_Oficio()) {
            // Si es cheff profesional.
            case 3:

                int i = 0;

                System.out.println("El cheff profesional " + monstruo.nombre + " abre la cafeteria");
                Chef_profesional aux = new Chef_profesional(monstruo.id_hilo, monstruo.nombre);
                aux.set_lista_platillos(lista_profesional);
                aux.llenar_Inventario(this.inventario, 0);
                aux.llenar_Inventario(this.inventario, 1);
                System.out.println("El cheff profesional " + monstruo.nombre
                        + " llena de alimentos el Inventario, con 1000 de carne y 1000 de vegetales");

                listo_Cheff_profesional = true;

                while (!listo_recepcionista) {
                }

          /*     while (++i < 1000) {
                    semaforo1.acquire();
                    for (int g = 0; g < lista_De_Mesas.size(); g++) {
                        for (int j = 0; j <= lista_De_Mesas.get(g).lugares_ocupados(); j++) {
                            Platillo platillo = genera_Comida(lista_normal);
                            System.out.println("El camarero " + aux.get_id_hilo() + " atiende a " + lista_De_Mesas.get(g).obtener_lugar(j).nombre + " y recoge su pedido.");
                            aux.preparar_comida(platillo.identificador_platillo, inventario);
                            System.out.println(
                                    "El monstruo " + lista_De_Mesas.get(g).obtener_lugar(j).nombre + " fue atendido por el camarero " + aux.get_id_hilo());
                            lista_De_Mesas.get(g).desocupar_lugar(j);
                        }
                    }
                    semaforo1.release();
                } */

                break;

            // Si es ayudante.
            case 0:

                int e = 0;
                System.out.println("El cocinero ayudante " + monstruo.nombre + " llega a la cafeteria");
                Ayudante_cocina ayudante = new Ayudante_cocina(monstruo.id_hilo, monstruo.nombre);
                ayudante.set_lista_platillos(lista_normal);

                while (!listo_recepcionista || !listo_Cheff_profesional) {
                }

          /*       while (++e < 1000) {
                    semaforo1.acquire();
                    for (int g = 0; g < lista_De_Mesas.size(); g++) {
                        for (int j = 0; j <= lista_De_Mesas.get(g).lugares_ocupados(); j++) {
                            Platillo platillo = genera_Comida(lista_normal);
                            System.out.println("El camarero " + ayudante.get_id_hilo() + " atiende a " + lista_De_Mesas.get(g).obtener_lugar(j).nombre + " y recoge su pedido.");
                            ayudante.preparar_comida(platillo.identificador_platillo, inventario);
                            System.out.println(
                                    "El monstruo " + lista_De_Mesas.get(g).obtener_lugar(j).nombre + " fue atendido por el camarero " + ayudante.get_id_hilo());
                            lista_De_Mesas.get(g).desocupar_lugar(j);
                        }
                    }
                    semaforo1.release();
                } */

                break;

            // Si es camarero
            case 2:

                break;

            // Recepcionista
            case 1:

                int h = 0;
                Recepcionista recepcionista = new Recepcionista(monstruo.id_hilo, ".");

                System.out.println("El recepcionista " + monstruo.nombre
                        + " llega a la cafeteria y asigna las siguientes mesas: ");
                for (int j = 0; j < 5; j++) {
                    Mesa mesa_aux = new Mesa(j);
                    System.out.println("Mesa " + j + " con capacidad de " + mesa_aux.lugares_desocupados());
                    lista_De_Mesas.add(mesa_aux);
                }

                listo_recepcionista = true;

                while (!listo_Cheff_profesional) {
                }

          /*       while (++h < 1000) {
                    semaforo2.acquire();
                    for (int j = 0; j < lista_de_espera.size(); j++) {
                        if (recepcionista.asignar_lugar(monstruo, lista_De_Mesas)) {
                            lista_de_espera.remove(j);
                            break;
                        }
                    }
                    semaforo2.release();
                } */

                // Una vez termina el dia debemos ver que ya no haya nadie en la lista de
                // espera.

                break;

            // Cualquier otro.
            default:
                System.out.println("El monstruo " + monstruo.nombre
                        + " llega a la cafeteria a comer");

                semaforo2.acquire();
                lista_de_espera.add(monstruo);
                semaforo2.release();

                break;
        }
    }

}