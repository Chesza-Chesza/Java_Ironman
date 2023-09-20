package Entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Clase para representar el Radar
public class Radar {
    private List<Enemigo> enemigos;

    public Radar() {
        enemigos = new ArrayList<>();
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    // Método para agregar enemigos al radar
    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(enemigo);
    }

    // Método para simular la detección de enemigos
    public void detectarEnemigos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Enemigo enemigo = new Enemigo();
            agregarEnemigo(enemigo);
        }
    }
}