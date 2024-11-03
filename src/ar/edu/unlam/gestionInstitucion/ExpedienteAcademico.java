package ar.edu.unlam.gestionInstitucion;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa el expediente académico de un alumno,
 * incluyendo información sobre sus niveles educativos y materias cursadas.
 */
public class ExpedienteAcademico {
    private Boolean jardin;
    private Boolean primaria;
    private Set<Grado> grados;
    private Set<Division> divisiones;
    private Set<Materia> materias;

    /**
     * Constructor de la clase ExpedienteAcademico que inicializa el estado del expediente.
     */
    public ExpedienteAcademico() {
        this.jardin = false;
        this.primaria = false;
        this.grados = new HashSet<>();
        this.divisiones = new HashSet<>();
        this.materias = new HashSet<>();
    }

    /**
     * Obtiene el estado de la educación inicial (jardín).
     *
     * @return true si el alumno ha completado el jardín; false en caso contrario.
     */
    public Boolean getJardin() {
        return jardin;
    }

    /**
     * Agrega un grado al expediente académico.
     *
     * @param grado El grado a agregar.
     */
    public void agregarGrado(Grado grado) {
        grados.add(grado);
    }

    /**
     * Obtiene el conjunto de grados del expediente académico.
     *
     * @return Un conjunto de grados asociados al expediente.
     */
    public Set<Grado> getGrados() {
        return grados;
    }

    /**
     * Establece el conjunto de grados del expediente académico.
     *
     * @param grados El conjunto de grados a asignar.
     */
    public void setGrados(Set<Grado> grados) {
        this.grados = grados;
    }

    /**
     * Obtiene el conjunto de divisiones del expediente académico.
     *
     * @return Un conjunto de divisiones asociadas al expediente.
     */
    public Set<Division> getDivisiones() {
        return divisiones;
    }

    /**
     * Establece el conjunto de divisiones del expediente académico.
     *
     * @param divisiones El conjunto de divisiones a asignar.
     */
    public void setDivisiones(Set<Division> divisiones) {
        this.divisiones = divisiones;
    }

    /**
     * Obtiene el conjunto de materias del expediente académico.
     *
     * @return Un conjunto de materias asociadas al expediente.
     */
    public Set<Materia> getMaterias() {
        return materias;
    }

    /**
     * Establece el conjunto de materias del expediente académico.
     *
     * @param materias El conjunto de materias a asignar.
     */
    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    /**
     * Establece el estado de la educación inicial (jardín).
     *
     * @param jardin true si el alumno ha completado el jardín; false en caso contrario.
     */
    public void setJardin(Boolean jardin) {
        this.jardin = jardin;
    }

    /**
     * Obtiene el estado de la educación primaria.
     *
     * @return true si el alumno ha completado la primaria; false en caso contrario.
     */
    public Boolean getPrimaria() {
        return primaria;
    }

    /**
     * Establece el estado de la educación primaria.
     *
     * @param primaria true si el alumno ha completado la primaria; false en caso contrario.
     */
    public void setPrimaria(Boolean primaria) {
        this.primaria = primaria;
    }

    /**
     * Agrega una materia al expediente académico.
     *
     * @param materia La materia a agregar.
     */
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }
}

