package Entities;

/**
 *
 * @shir
 */
// Clase para representar la consola
public class Consola extends Dispositivo {
    protected double consumoPorMensaje;
    protected StringBuilder mensajes;

    public Consola() {
        estaDanado = false;
        consumoEnergia = 2.0;
        consumoPorMensaje = consumoEnergia;
        mensajes = new StringBuilder();
    }
    @Override
    public double usar(int nivelIntensidad, int tiempo) {
        if (nivelIntensidad != 1 || tiempo <= 0) {
            throw new IllegalArgumentException("Nivel de intensidad y tiempo inválidos.");
        }
        double consumo = consumoPorMensaje;
        if (seDana()) {
            estaDanado = true;
            System.out.println("¡La consola se ha dañado durante la acción!");
        }
        return consumo;
    }

    @Override
    public void reparar() {
        estaDanado = false;
    }

    // Otros métodos y funcionalidades de la Consola
    @Override
    public void mostrarEstado() {
        System.out.println(getClass().getSimpleName() + ":");
        System.out.println("Estado: " + (estaDanado ? "Dañado" : "Funcionando"));
    }
    
     // Método para escribir un mensaje en la consola
    public void escribirMensaje(String mensaje) {
        if (!estaDanado) {
            mensajes.append(mensaje).append("\n");
            System.out.println("Mensaje escrito en la consola: " + mensaje);
            
            // Consumir energía por escribir mensaje
            double consumo = usar(1, 1);
            System.out.println("Consumo de energía: " + consumo);
        } else {
            System.out.println("La consola está dañada y no se puede escribir.");
        }
    }

    public void mostrarMensajes() {
        if (!estaDanado) {
            System.out.println("Mensajes en la consola:");
            System.out.println(mensajes.toString());
        } else {
            System.out.println("La consola está dañada y no se pueden mostrar los mensajes.");
        }
    }
    
    
}