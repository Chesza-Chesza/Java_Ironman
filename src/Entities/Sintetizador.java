/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @shir
 */
// Clase para representar el sintetizador
public class Sintetizador extends Dispositivo {
    private double consumoPorMensaje;
    private List<String> mensajes;

    public Sintetizador() {
        estaDanado = false;
        consumoEnergia = 2.0;
        consumoPorMensaje = consumoEnergia;
        this.mensajes = new ArrayList<>();
    }
    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }

    public void susurrar(String mensaje) {
        if (!estaDanado) {
            mensajes.add(mensaje);
        }
    }
    
    @Override
    public double usar(int nivelIntensidad, int tiempo) {
        if (nivelIntensidad != 1 || tiempo <= 0) {
            throw new IllegalArgumentException("Nivel de intensidad y tiempo inválidos.");
        }
        double consumo = consumoPorMensaje;
        if (seDana()) {
            estaDanado = true;
            System.out.println("¡El sintetizador se ha dañado durante la acción!");
        }
        return consumo;
    }
    
    // Método para dañar el sintetizador (para fines de prueba)
    public void danar() {
        estaDanado = true;
    }
    
        @Override
    public void reparar() {
        estaDanado = false;
    }

    @Override
    public void mostrarEstado() {
        if (estaDanado) {
            System.out.println("Sintetizador: Dañado");
        } else {
            System.out.println("Sintetizador: Funcionando");
            if (!mensajes.isEmpty()) {
                System.out.println("Mensajes en cola:");
                for (String mensaje : mensajes) {
                    System.out.println("- " + mensaje);
                }
            } else {
                System.out.println("No hay mensajes en cola.");
            }
        }
    }

}
