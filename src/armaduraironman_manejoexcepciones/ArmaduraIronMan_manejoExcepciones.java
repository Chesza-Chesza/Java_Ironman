/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaduraironman_manejoexcepciones;

import Entities.Armadura;
import Entities.Botas;
import Entities.Consola;
import Entities.Dispositivo;

/**
 *
 * @author administrador
 */
public class ArmaduraIronMan_manejoExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     // Crear una instancia de la Armadura y realizar pruebas
        Armadura ironManArmadura = new Armadura("Rojo", "Oro");
        //Consola consola = new Consola();

        Consola consola = ironManArmadura.getConsola();

        // Mostrar el estado inicial de la armadura
        ironManArmadura.mostrarEstado();
        ironManArmadura.mostrarEstadoBateria();
        ironManArmadura.mostrarInformacionReactor();
        
         try {
             // Realizar algunas acciones
            ironManArmadura.caminar(10); // Caminar durante 10 minutos
            ironManArmadura.correr(5);  // Correr durante 5 minutos
            ironManArmadura.volar(15);  // Volar durante 15 minutos

             // Mostrar el estado después de las acciones
            ironManArmadura.mostrarEstado();
            ironManArmadura.mostrarEstadoBateria();

            // Agregar objetos al radar
            ironManArmadura.agregarObjetosAlRadar();

            // Destruir enemigos
            ironManArmadura.destruirEnemigos();

            // Mostrar el estado del sintetizador
            ironManArmadura.getSintetizador().mostrarEstado();

            // Realizar acciones evasivas
            ironManArmadura.accionesEvasivas();

            // Mostrar el estado final de la armadura
            ironManArmadura.mostrarEstado();
            ironManArmadura.mostrarEstadoBateria();
            ironManArmadura.mostrarInformacionReactor();
        
            // Escribir mensajes en la consola
            consola.escribirMensaje("¡Hola, Jarvis!");
            consola.escribirMensaje("Estoy probando la consola.");

            // Mostrar los mensajes de la consola
            consola.mostrarMensajes();
            

            // Revisar y reparar dispositivos
            ironManArmadura.revisarDispositivos();
            ironManArmadura.repararDispositivo(consola);


            // Simular la detección de enemigos en el radar
           ironManArmadura.getRadar().detectarEnemigos(1);

            // Destruir enemigos
            ironManArmadura.destruirEnemigos();


        } catch (IllegalArgumentException e) {
           System.err.println("Error: " + e.getMessage());
        }
    }
}
