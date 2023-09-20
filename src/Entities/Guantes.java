package Entities;

/**
 *
 * @shir
 */
// Clase para representar los guantes
public class Guantes extends Dispositivo {
    private double consumoPorDisparo;

    public Guantes() {
        estaDanado = false;
        consumoEnergia = 10.0;
        consumoPorDisparo = consumoEnergia;
    }

    @Override
    public double usar(int nivelIntensidad, int tiempo) {
        if (nivelIntensidad != 3 || tiempo != 1) {
            throw new IllegalArgumentException("Nivel de intensidad y tiempo inválidos para disparo.");
        }
        double consumo = consumoPorDisparo;
        if (seDana()) {
            estaDanado = true;
            System.out.println("¡Los guantes se han dañado durante el disparo!");
        }
        return consumo;
    }

    @Override
    public void reparar() {
        estaDanado = false;
    }

    // Otros métodos y funcionalidades de los Guantes
    @Override
    public void mostrarEstado() {
        System.out.println(getClass().getSimpleName() + ":");
        System.out.println("Estado: " + (estaDanado ? "Dañado" : "Funcionando"));
    }
}