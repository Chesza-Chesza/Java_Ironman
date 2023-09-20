package Entities;
import java.util.Random;

// Clase para representar a un enemigo
public class Enemigo {
    private double distancia;
    private double resistencia;
    private boolean estaDestruido;

    public Enemigo() {
        Random rand = new Random();
        distancia = rand.nextDouble() * 10000; // Distancia aleatoria entre 0 y 10000 metros
        resistencia = rand.nextDouble() * 100; // Resistencia aleatoria entre 0 y 100
        estaDestruido = false;
    }

    Enemigo(double resistencia, double x, double y, double z, boolean hostil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getDistancia() {
        return distancia;
    }

    public double getResistencia() {
        return resistencia;
    }

    public boolean estaDestruido() {
        return estaDestruido;
    }

    public void recibirAtaque(double potencia) {
        resistencia -= potencia;
        if (resistencia <= 0) {
            resistencia = 0;
            estaDestruido = true;
        }
    }
}