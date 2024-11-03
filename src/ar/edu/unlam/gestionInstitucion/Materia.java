package ar.edu.unlam.gestionInstitucion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa una materia que puede ser dictada por un docente.
 */
public class Materia {
    private Docente docente;
    private String nombre;
    private List<String> contenido;

    /**
     * Constructor para crear una instancia de Materia.
     *
     * @param nombre el nombre de la materia
     */
    public Materia(String nombre) {
        this.contenido = new ArrayList<>();
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la materia.
     *
     * @return el nombre de la materia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la materia.
     *
     * @param nombre el nuevo nombre de la materia
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de contenido de la materia.
     *
     * @return la lista de contenido de la materia
     */
    public List<String> getContenido() {
        return contenido;
    }

    /**
     * Establece la lista de contenido de la materia.
     *
     * @param contenido la nueva lista de contenido de la materia
     */
    public void setContenido(List<String> contenido) {
        this.contenido = contenido;
    }

    /**
     * Asigna un docente a la materia si cumple con los requisitos necesarios.
     *
     * @param docente el docente a asignar
     * @throws RequisitoNoCumplidoException si el docente no tiene experiencia en la materia
     */
    public void agregarDocente(Docente docente) throws RequisitoNoCumplidoException {
        if (!docente.getExpediente().getMaterias().contains(this)) {
            throw new RequisitoNoCumplidoException("El docente no cuenta con experiencia para dictar esta materia");
        }
        setDocente(docente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Materia other = (Materia) obj;
        return Objects.equals(nombre, other.nombre);
    }

    /**
     * Obtiene el docente asignado a la materia.
     *
     * @return el docente asignado a la materia
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * Establece el docente asignado a la materia.
     *
     * @param docente el docente a asignar
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
