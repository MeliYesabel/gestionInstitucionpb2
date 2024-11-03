package ar.edu.unlam.gestionInstitucion;

import java.util.HashMap;
import java.util.Map;


/**
 * Representa un nivel educativo que contiene diferentes divisiones (cursos).
 */
public class NivelEducativo {

    private Map<String, Curso> divisiones = new HashMap<>();

    /**
     * Obtiene el mapa de divisiones (cursos) del nivel educativo.
     *
     * @return un mapa donde la clave es el nombre de la división y el valor es el curso correspondiente
     */
    public Map<String, Curso> getDivisiones() {
        return divisiones;
    }

    /**
     * Establece las divisiones (cursos) del nivel educativo.
     *
     * @param divisiones un mapa donde la clave es el nombre de la división y el valor es el curso correspondiente
     */
    public void setDivisiones(Map<String, Curso> divisiones) {
        this.divisiones = divisiones;
    }
}
