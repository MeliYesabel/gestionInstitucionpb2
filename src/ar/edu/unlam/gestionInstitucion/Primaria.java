package ar.edu.unlam.gestionInstitucion;

/**
 * Clase que representa el nivel educativo de Primaria.
 * Esta clase extiende la clase NivelEducativo y define las divisiones correspondientes a los grados de Primaria.
 */
public class Primaria extends NivelEducativo {

    /**
     * Constructor de la clase Primaria.
     * Inicializa las divisiones con los grados correspondientes y sus respectivas edades mínimas.
     */
    public Primaria() {
        getDivisiones().put("Primero", new Grado("Primero", 6));
        getDivisiones().put("Segundo", new Grado("Segundo", 7));
        getDivisiones().put("Tercero", new Grado("Tercero", 8));
        getDivisiones().put("Cuarto", new Grado("Cuarto", 9));
        getDivisiones().put("Quinto", new Grado("Quinto", 10));
        getDivisiones().put("Sexto", new Grado("Sexto", 11));
    }
}

