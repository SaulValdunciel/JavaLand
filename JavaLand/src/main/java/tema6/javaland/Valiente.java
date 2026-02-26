/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author PC
 */
import java.util.Random;

public class Valiente implements PersonajesInterface {

    // Atributos
    protected Inventario inventario; // Inventario del valiente
    protected String clase;          // Guerrero, Paladin, Mago, Picaro

    protected int vida;        // vida 0-100
    protected int vidaMaxima;  // vida max

    protected int fuerza;     // 0-20
    protected int defensa;    // 0-20
    protected int habilidad;  // 0-20
    protected int velocidad;  // 0-20
    protected int nivel = 1;

    private Arma arma = null;
    private Escudo escudo = null;

    private final Random random = new Random();

    // Habilidades
    // Guerrero: si tiene objeto equipado, siguiente ataque hace 3x fuerza
    private boolean guerreroTriplePendiente = false;

    // Mago: duplica habilidad durante 2 "turnos" se consume al atacar
    private int magoTurnos = 0;

    // Pícaro: duplica velocidad para el siguiente ataque
    private boolean picaroVelocidadDuplicada = false;

    // Constructores
    public Valiente() {
    }

    public Valiente(String clase, int vida, int fuerza, int defensa, int habilidad, int velocidad) {
        this.inventario = new Inventario();
        this.clase = clase;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.velocidad = velocidad;
    }

    // Metodos
    @Override
    public <T> int atacar(T Personaje) {

        Monstruo monstruo = (Monstruo) Personaje;

        // Tirada 0..100
        int tirada = random.nextInt(101);

        // MAGO: habilidad efectiva
        int habEfectiva = habilidad;
        if (magoTurnos > 0) {
            habEfectiva = habilidad * 2;
        }

        // Fórmula acierto: tirada < 4*habilidad - defensaEnemigo
        int umbral = 4 * habEfectiva - monstruo.getDefensa();

        // Si falla:
        if (tirada >= umbral) {
            // Consumimos turnos del mago porque ha pasado "su acción"
            if (magoTurnos > 0) {
                magoTurnos--;
            }

            // El pícaro solo dura este ataque, falle o acierte
            if (picaroVelocidadDuplicada) {
                picaroVelocidadDuplicada = false;
            }

            return 0;
        }

        int bonusArma = 0;
        if (arma != null) {
            bonusArma = arma.getAtaque();
        }

        int danio;

        // GUERRERO: siguiente ataque 3x fuerza
        if (guerreroTriplePendiente) {
            danio = (fuerza * 3) + bonusArma;
            guerreroTriplePendiente = false;
        } else {
            danio = fuerza + bonusArma;
        }

        // PÍCARO: velocidad x2 para el siguiente ataque; si duplica al enemigo -> 2 golpes (daño x2)
        if (clase.equalsIgnoreCase("PICARO") && picaroVelocidadDuplicada) {
            int velEf = velocidad * 2;
            if (velEf >= monstruo.getVelocidad() * 2) {
                danio = danio * 2; // simulamos dos ataques
            }
            picaroVelocidadDuplicada = false; // se consume
        }

        // Consumimos turno del mago al atacar (acierte o falle)
        if (magoTurnos > 0) {
            magoTurnos--;
        }

        return danio;
    }

    @Override
    public int recibirDaño(int cantidad) {
        if (cantidad < 0) {
            cantidad = 0;
        }
        vida -= cantidad;
        if (vida < 0) {
            vida = 0;
        }
        return vida;
    }

    @Override
    public boolean ValienteUsarHabilidadEspecial() {

        // GUERRERO: si tiene arma o escudo, prepara el siguiente ataque triple
        if (clase.equalsIgnoreCase("GUERRERO")) {
            if (arma != null || escudo != null) {
                guerreroTriplePendiente = true;
                return true;
            }
            return false;
        }

        // PALADIN: se cura un 50% de la vida max
        if (clase.equalsIgnoreCase("PALADIN")) {
            int cura = vidaMaxima / 2;
            vida += cura;
            if (vida > vidaMaxima) {
                vida = vidaMaxima;
            }
            return true;
        }

        // MAGO: duplica habilidad durante 2 "turnos", se consumen en 2 acciones de atacar
        if (clase.equalsIgnoreCase("MAGO")) {
            magoTurnos = 2;
            return true;
        }

        // PICARO: duplica velocidad para el siguiente ataque
        if (clase.equalsIgnoreCase("PICARO")) {
            picaroVelocidadDuplicada = true;
            return true;
        }

        return false;
    }

    @Override
    public void ValienteSubirNivel() {
        nivel++;

        // Subimos vida máxima y también aumentamos vida, sin superar el máximo
        vidaMaxima += 10;
        vida += 10;
        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }

        fuerza += 1;
        defensa += 1;
        habilidad += 1;
        velocidad += 1;
    }

    // metodos utiles
    public int getDefensaTotal() {
        int bonus = 0;
        if (escudo != null) {
            bonus = escudo.getDefensa();
        }
        return defensa + bonus;
    }

    @Override
    public String toString() {
        return "Clase: " + clase
                + "\nNivel: " + nivel
                + "\nVida: " + vida + "/" + vidaMaxima
                + "\nFuerza: " + fuerza
                + "\nDefensa: " + defensa
                + "\nHabilidad: " + habilidad
                + "\nVelocidad: " + velocidad;
    }

    // getters y setters
    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }
}
