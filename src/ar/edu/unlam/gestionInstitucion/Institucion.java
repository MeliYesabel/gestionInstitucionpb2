package ar.edu.unlam.gestionInstitucion;

import java.util.HashSet;
import java.util.Set;


/**
 * Representa una institución educativa que puede contener varios niveles educativos.
 */
public class Institucion {
    private String nombre;
    private Set<NivelEducativo> nivelesEducativos;

    /**
     * Constructor para crear una nueva institución educativa.
     *
     * @param nombre El nombre de la institución.
     */
    public Institucion(String nombre) {
        this.nombre = nombre;
        this.nivelesEducativos = new HashSet<>();
    }

    /**
     * Agrega un nivel educativo a la institución.
     *
     * @param nivel El nivel educativo a agregar.
     */
    public void agregarNivelEducativo(NivelEducativo nivel) {
        nivelesEducativos.add(nivel);
    }

    /**
     * Obtiene el nombre de la institución.
     *
     * @return El nombre de la institución.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la institución.
     *
     * @param nombre El nuevo nombre de la institución.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los niveles educativos de la institución.
     *
     * @return Un conjunto de niveles educativos.
     */
    public Set<NivelEducativo> getNivelesEducativos() {
        return nivelesEducativos;
    }

    /**
     * Establece los niveles educativos de la institución.
     *
     * @param nivelesEducativos Un conjunto de niveles educativos.
     */
    public void setNivelesEducativos(Set<NivelEducativo> nivelesEducativos) {
        this.nivelesEducativos = nivelesEducativos;
    }
}
