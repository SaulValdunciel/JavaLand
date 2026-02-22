/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import static java.lang.Math.clamp;
import java.util.Random;

/**
 *
 * @author cuent
 */
public class Valiente implements PersonajesInterface {
    //Atributos
    protected String clase; // Guerrero, Paladin, Mago, Picaro
    protected int vida; //0-100
    protected int fuerza; //0-20
    protected int defensa; //0-20
    protected int habilidad; //0-20
    protected int velocidad; //0-20
    protected int nivel = 1;
    
    private Arma arma = null;
    private Escudo escudo = null;
    
    //El monstruo objetivo 
    private Monstruo objetivo;
    
    //El cooldown para habilidad especial
    private int cooldownTurnos = 0;
    private static final int cooldown_max = 2;

    //Habilidades
    // Guerrero: si tiene objeto equipado, siguiente ataque hace 3x fuerza
    private boolean guerreroTriplePendiente = false;
    // Paladín: si el enemigo falla, ataque gratis; sigue activo hasta que el enemigo acierte
    private boolean paladinActivo = false;
    // Mago: duplica habilidad durante 2 turnos
    private int magoTurnos = 0;
    // Pícaro: duplica velocidad (buff activo); si duplica la del enemigo, puede atacar 2 veces
    private boolean picaroVelocidadDuplicada = false;
    
    //El random
    private Random random = new Random();
    
    //Constructores
    public Valiente() {

    }

    public Valiente(String clase, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        this.clase = clase;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.velocidad = velocidad;
        this.nivel = 1;
    }

    //Metodos:
    @Override
    public <T> int atacar(T Personaje) {
        Monstruo monstruo = (Monstruo) Personaje;
        this.objetivo = monstruo;

        // Tirada 0..100
        int tirada = random.nextInt(101);

        // Si eres mago y buff activo -> habilidad x2
        int habEfectiva = habilidad;
        if (magoTurnos > 0) habEfectiva = habilidad * 2;

        // Fórmula de acierto: tirada < 4*habilidad - defensaEnemigo
        int umbral = 4 * habEfectiva - monstruo.getDefensa();

        if (tirada >= umbral) {
            return 0; // fallo
        }

        int bonusArma = 0;
        if (arma != null) bonusArma = arma.getAtaque();

        int daño;

        // Guerrero: si estaba pendiente el triple, se consume en este ataque
        if (guerreroTriplePendiente) {
            daño = (fuerza * 3) + bonusArma;
            guerreroTriplePendiente = false;
        } else {
            daño = fuerza + bonusArma;
        }

        // Devolvemos el daño
        return daño;
    }

    //Metodo recibir daño sobrescrito de la interfaz
    @Override
    public int recibirDaño(int cantidad) {
        if (cantidad < 0) cantidad = 0;
        vida -= cantidad;
        if (vida < 0) vida = 0;
        return vida;
    }

    @Override
    public boolean ValienteUsarHabilidadEspecial() {
        // GUERRERO
        // Si tiene objeto equipado, siguiente ataque mete 3x fuerza
        if (clase.equalsIgnoreCase("GUERRERO")) {
            if (arma != null || escudo != null) {
                guerreroTriplePendiente = true;
                return true;
            }
            return false;
        }

        // PALADIN
        // Si el enemigo falla, ataque gratis; se mantiene hasta que acierte
        if (clase.equalsIgnoreCase("PALADIN")) {
            paladinActivo = true;
            return true;
        }

        // MAGO
        // Duplica habilidad durante 2 turnos
        if (clase.equalsIgnoreCase("MAGO")) {
            magoTurnos = 2;
            return true;
        }

        // PICARO
        // Duplica velocidad. Si velocidad duplicada >= 2x velocidad enemigo => 2 ataques
        if (clase.equalsIgnoreCase("PICARO")) {
            picaroVelocidadDuplicada = true;
            return true;
        }

        return false;
    }
    
    @Override
    public int ValienteSubirNivel() {
        nivel ++; //Aumenta el nivel 
        vida += 10; //Aumenta la vida
        fuerza ++; //Aumenta la fuerza
        defensa ++; //Aumenta la defensa
        habilidad ++; //Aumenta la habilidad
        velocidad ++; //Aumenta la velocidad
        return nivel;
    }
    
    //llamar cada turno desde combate para bajar turnos del mago y quitar buff del picaro 
    public void tickCooldown(){
        if (cooldownTurnos > 0) cooldownTurnos--;
        // El buff del pícaro lo dejamos solo 1 turno.
        if (picaroVelocidadDuplicada) {
            picaroVelocidadDuplicada = false;
        }
    }
       
    // Defensa total (defensa + escudo)
    public int getDefensaTotal() {
        int bonus = 0;
        if (escudo != null) bonus = escudo.getDefensa();
        return defensa + bonus;
    }

    // Velocidad efectiva (si pícaro duplicó velocidad este turno)
    public int getVelocidadEfectiva() {
        if (picaroVelocidadDuplicada) return velocidad * 2;
        return velocidad;
    }

    // Paladín: Combate debe llamar esto cuando el monstruo FALLA su ataque
    public boolean paladinDebeAtacarGratisSiEnemigoFalla() {
        return paladinActivo;
    }

    // Paladín: Combate debe llamar esto cuando el monstruo ACIERTA (para apagar la habilidad)
    public void paladinDesactivarSiEnemigoAcierta() {
        paladinActivo = false;
    }

    // Pícaro: si con velocidad duplicada supera condición
    public boolean picaroPuedeAtacarDosVeces() {
        if (objetivo == null) return false;
        int velEfectiva = getVelocidadEfectiva();
        return velEfectiva >= (objetivo.getVelocidad() * 2);
    }

    public int getVida() {
        return vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getFuerza(){
        return defensa;
    }
    
    public int getHabilidad() {
        return habilidad;
    }
    
    public int getDefensa() {
        return defensa;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public Arma getArma() {
        return arma;
    }
    
    public Escudo getEscudo() {
        return escudo;
    }
    
    public void setArma(Arma arma) { 
        this.arma = arma; 
    }
    public void setEscudo(Escudo escudo) { 
        this.escudo = escudo; 
    }

    public Monstruo getObjetivo() {
        return objetivo;
    }
}

