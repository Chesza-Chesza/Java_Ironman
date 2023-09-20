package Entities;

import java.util.List;
import java.util.Random;

/**
 *
 * @shir
 */
// Clase principal para la armadura
public class Armadura {
    protected String colorPrimario;
    protected String colorSecundario;
    protected Botas botas;
    protected Guantes guantes;
    protected Consola consola;
    protected Sintetizador sintetizador;
    protected int nivelResistencia;
    protected int nivelSalud;
    protected Reactor reactor;
    protected Radar radar;
    protected Dispositivo dispositivo;

    public Armadura(String colorPrimario, String colorSecundario) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.botas = new Botas();
        this.guantes = new Guantes();
        this.consola = new Consola();
        this.sintetizador = new Sintetizador();
        this.nivelResistencia = 0;
        this.nivelSalud = 100;
        this.reactor = new Reactor();
        this.radar = new Radar();
        this.dispositivo = new Dispositivo();
    }

    public String getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Botas getBotas() {
        return botas;
    }

    public void setBotas(Botas botas) {
        this.botas = botas;
    }

    public Guantes getGuantes() {
        return guantes;
    }

    public void setGuantes(Guantes guantes) {
        this.guantes = guantes;
    }

    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    public Sintetizador getSintetizador() {
        return sintetizador;
    }

    public void setSintetizador(Sintetizador sintetizador) {
        this.sintetizador = sintetizador;
    }

    public int getNivelResistencia() {
        return nivelResistencia;
    }

    public void setNivelResistencia(int nivelResistencia) {
        this.nivelResistencia = nivelResistencia;
    }

    public int getNivelSalud() {
        return nivelSalud;
    }

    public void setNivelSalud(int nivelSalud) {
        this.nivelSalud = nivelSalud;
    }

    public Reactor getReactor() {
        return reactor;
    }

    public void setReactor(Reactor reactor) {
        this.reactor = reactor;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }
    public Dispositivo getDispositivo() {
        return dispositivo;
    }
    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public double caminar(int tiempo) {
        double consumo = botas.usar(1, tiempo);
        reactor.consumirEnergia(consumo);
        return consumo;
    }

    public double correr(int tiempo) {
        double consumo = botas.usar(2, tiempo);
        reactor.consumirEnergia(consumo);
        return consumo;
    }

    public double volar(int tiempo) {
        double consumoBotas = botas.usar(3, tiempo);
        double consumoGuantes = guantes.usar(2, tiempo);
        double consumoTotal = consumoBotas + consumoGuantes;
        reactor.consumirEnergia(consumoTotal);
        return consumoTotal;
    }

    public void dispararGuantes() {
        if (!guantes.estaDanado) {
            double consumo = guantes.usar(3, 1); // Disparo
            reactor.consumirEnergia(consumo);
        } else {
            System.out.println("Los guantes están dañados y no se pueden usar como armas.");
        }
    }

    public void mostrarEstado() {
        // Implementa la lógica para mostrar el estado de la armadura aquí
        System.out.println("Estado de la Armadura:");
        System.out.println("Color Primario: " + colorPrimario);
        System.out.println("Color Secundario: " + colorSecundario);
        System.out.println("Nivel de Resistencia: " + nivelResistencia);
        System.out.println("Nivel de Salud: " + nivelSalud);
        // Mostrar información de otros dispositivos
        botas.mostrarEstado();
        guantes.mostrarEstado();
        consola.mostrarEstado();
        sintetizador.mostrarEstado();
        dispositivo.mostrarEstado();
    }

    public void mostrarEstadoBateria() {
        // Implementa la lógica para mostrar el estado de la batería aquí
        double porcentajeCarga = (reactor.getCargaActual() / reactor.getCargaMaxima()) * 100;
        System.out.println("Estado de la Batería: " + porcentajeCarga + "%");
    }

    public void mostrarInformacionReactor() {
        // Implementa la lógica para mostrar la información del reactor aquí
        double cargaActual = reactor.getCargaActual();
        System.out.println("Carga del Reactor: " + cargaActual + " unidades");
        // Otras unidades de medida según la tabla de transformaciones
    }

    // Método para verificar si un dispositivo se daña
    private boolean seDana() {
        Random rand = new Random();
        double probabilidad = rand.nextDouble(); // Número aleatorio entre 0 y 1
        return probabilidad <= 0.3; // 30% de probabilidad de daño
    }

    // Método para reparar un dispositivo
    public void repararDispositivo(Dispositivo dispositivo) {
        Random rand = new Random();
        double probabilidad = rand.nextDouble(); // Número aleatorio entre 0 y 1
        if (probabilidad <= 0.4) { // 40% de probabilidad de reparación
            dispositivo.reparar();
        }
    }
    

    // Método para revisar y reparar dispositivos
    public void revisarDispositivos() {
        Dispositivo[] dispositivos = { botas, guantes, consola, sintetizador };
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.estaDanado) {
                System.out.println("Revisando y reparando " + dispositivo.getClass().getSimpleName() + "...");
                int intentos = 0;
                do {
                    repararDispositivo(dispositivo);
                    intentos++;
                } while (dispositivo.estaDanado && intentos < 10); // Intentar hasta 10 veces
                if (dispositivo.estaDanado) {
                    System.out.println(dispositivo.getClass().getSimpleName() + " no se pudo reparar y queda destruido.");
                } else {
                    System.out.println(dispositivo.getClass().getSimpleName() + " ha sido reparado.");
                }
            }
        }
    }

    // Método para agregar objetos al radar
    public void agregarObjetosAlRadar() {
        // Generar hasta 10 objetos aleatorios en el radar
        Random rand = new Random();
        int numObjetos = rand.nextInt(11); // Número aleatorio entre 0 y 10
        for (int i = 0; i < numObjetos; i++) {
            double resistencia = rand.nextDouble() * 100; // Resistencia entre 0 y 100
            double x = rand.nextDouble() * 10000; // Coordenada X entre 0 y 10000 metros
            double y = rand.nextDouble() * 10000; // Coordenada Y entre 0 y 10000 metros
            double z = rand.nextDouble() * 10000; // Coordenada Z entre 0 y 10000 metros
            boolean hostil = rand.nextBoolean(); // Aleatorio si es hostil o no
            
        // Crear un nuevo objeto Enemigo y agregarlo al radar
        Enemigo objetoRadar = new Enemigo(resistencia, x, y, z, hostil);
        radar.agregarEnemigo(objetoRadar);
        }
    }

    // Método para destruir enemigos
    public void destruirEnemigos() {
        
// Implementación de la lógica para destruir enemigos
        // Suponiendo que tenemos una lista de enemigos en el radar
        List<Enemigo> enemigos = radar.getEnemigos();
        for (Enemigo enemigo : enemigos) {
            if (enemigo.getDistancia() <= 5000) { // Rango de ataque de los guantes (5000 metros)
                if (!guantes.estaDanado && reactor.getCargaActual() > 0) {
                    // Calcular el daño en función de la distancia
                    double distancia = enemigo.getDistancia();
                    double potenciaDisparo = 5000 / distancia; // A mayor distancia, menor potencia
                    enemigo.recibirAtaque(potenciaDisparo);
                    reactor.consumirEnergia(guantes.usar(3, 1)); // Disparar guantes
                    if (enemigo.estaDestruido()) {
                        System.out.println("Enemigo destruido.");
                    } else {
                        System.out.println("Atacando enemigo a " + distancia + " metros. Resistencia restante: " + enemigo.getResistencia());
                    }
                } else {
                    System.out.println("No es posible disparar con los guantes en este momento.");
                }
            } else {
                System.out.println("Enemigo fuera de alcance de los guantes.");
            }
        }
    }

    // Método para acciones evasivas
    public void accionesEvasivas() {
        // Implementa la lógica para acciones evasivas aquí
        double nivelBateria = (reactor.getCargaActual() / reactor.getCargaMaxima()) * 100;
        if (nivelBateria < 10) {
            System.out.println("Nivel de batería bajo. Realizando acción evasiva...");
            double distanciaEvasion = 10000; // Distancia mínima de evasión en metros
            double tiempoEvasion = distanciaEvasion / (300.0 / 3600.0); // Tiempo en segundos
            double consumoEvasion = botas.usar(1, (int) tiempoEvasion); // Caminar a 300 km/h
            reactor.consumirEnergia(consumoEvasion);
        }
    }


}