/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @shir
 */
// Clase para representar el reactor
public class Reactor {
    private double cargaMaxima;
    private double cargaActual;

    public Reactor() {
        cargaMaxima = Double.MAX_VALUE;
        cargaActual = cargaMaxima;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void consumirEnergia(double energia) {
        if (energia < 0) {
            throw new IllegalArgumentException("La energía no puede ser negativa.");
        }
        cargaActual -= energia;
        if (cargaActual < 0) {
            cargaActual = 0;
        }
    }


}
