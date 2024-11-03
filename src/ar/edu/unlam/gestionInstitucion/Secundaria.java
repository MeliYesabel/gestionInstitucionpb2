package ar.edu.unlam.gestionInstitucion;

/**
 * Clase que representa el nivel educativo de secundaria.
 * Extiende la clase NivelEducativo y define las divisiones correspondientes.
 */
public class Secundaria extends NivelEducativo {

    /**
     * Constructor para la clase Secundaria.
     * Inicializa las divisiones de la secundaria con los nombres y las edades mínimas correspondientes.
     */
    public Secundaria() {
        getDivisiones().put("Primero", new Division("Primero", 12));
        getDivisiones().put("Segundo", new Division("Segundo", 13));
        getDivisiones().put("Tercero", new Division("Tercero", 14));
        getDivisiones().put("Cuarto", new Division("Cuarto", 15));
        getDivisiones().put("Quinto", new Division("Quinto", 16));
        getDivisiones().put("Sexto", new Division("Sexto", 17));
    }
}
