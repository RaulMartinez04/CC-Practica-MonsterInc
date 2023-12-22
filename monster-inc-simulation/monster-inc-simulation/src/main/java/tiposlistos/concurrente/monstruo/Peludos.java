package tiposlistos.concurrente.monstruo;

import tiposlistos.concurrente.cafeteria.Cafeteria;
import tiposlistos.concurrente.oficio.Oficio;

public class Peludos extends Monstruo{

    public Peludos(Cafeteria cafeteria, String nombre, Oficio trabajo, int peso, int altura) {
        super(cafeteria, nombre, trabajo);
        this.tipo = 1;
        this.peso = peso + 10;
        this.altura = altura + 100;
    }   
}