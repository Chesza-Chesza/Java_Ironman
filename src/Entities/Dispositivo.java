package Entities;

import java.util.Random;

// Clase base para los dispositivos
public class Dispositivo {
    protected boolean estaDanado;
    protected double consumoEnergia;

    public Dispositivo() {
        estaDanado = false;
        consumoEnergia = 0.0;
    }

    public double usar(int nivelIntensidad, int tiempo) {
        if (nivelIntensidad <= 0 || tiempo <= 0) {
            throw new IllegalArgumentException("Nivel de intensidad y tiempo deben ser mayores que cero.");
        }

        double consumo = nivelIntensidad * tiempo * consumoEnergia;

        if (seDana()) {
            estaDanado = true;
            System.out.println("¡El dispositivo se ha dañado durante la acción!");
        }

        return consumo;
    }

    public void reparar() {
        estaDanado = false;
    }

    public boolean seDana() {
        Random rand = new Random();
        double probabilidad = rand.nextDouble(); // Número aleatorio entre 0 y 1
        return probabilidad <= 0.3; // 30% de probabilidad de daño
    }

    public void mostrarEstado() {
        System.out.println(getClass().getSimpleName() + ":");
        System.out.println("Estado: " + (estaDanado ? "Dañado" : "Funcionando"));
    }
}