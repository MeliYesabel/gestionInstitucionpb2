package ar.edu.unlam.gestionInstitucion;

/**
 * Representa el nivel educativo de Jardín, que incluye diferentes salas.
 */
public class Jardin extends NivelEducativo {

    /**
     * Constructor para crear una instancia de Jardín.
     * Inicializa las divisiones (salas) del nivel educativo.
     */
    public Jardin() {
        getDivisiones().put("Celeste", new Sala("Celeste", 2));
        getDivisiones().put("Verde", new Sala("Verde", 3));
        getDivisiones().put("Azul", new Sala("Azul", 4));
        getDivisiones().put("Roja", new Sala("Roja", 5));
    }
}
