package Entities;

/**
 *
 * @shir
 */

// Clase para representar las botas
public class Botas extends Dispositivo {
    private double consumoPorSegundo;
    
    public Botas() {
        estaDanado = false;
        consumoEnergia = 5.0;
        consumoPorSegundo = consumoEnergia / 3600.0; // Consumo por segundo
    }

    @Override
    public double usar(int nivelIntensidad, int tiempo) {
        if (nivelIntensidad < 1 || tiempo <= 0) {
            throw new IllegalArgumentException("Nivel de intensidad y tiempo inválidos.");
        }
        double consumo = consumoPorSegundo * nivelIntensidad * tiempo;
        if (seDana()) {
            estaDanado = true;
            System.out.println("¡Las botas se han dañado durante la acción!");
        }
        return consumo;
    }

    @Override
    public void reparar() {
        estaDanado = false;
    }
    
    @Override
    public void mostrarEstado() {
        System.out.println(getClass().getSimpleName() + ":");
        System.out.println("Estado: " + (estaDanado ? "Dañado" : "Funcionando"));
    }
}
