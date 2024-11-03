package ar.edu.unlam.gestionInstitucion;

import java.util.Date;

/**
 * Clase que representa una evaluación de un alumno en un curso o materia.
 */
public class Evaluacion {

    private Integer nota;
    private Date fecha;
    private Curso curso;
    private Materia materia;

    /**
     * Constructor de la clase Evaluacion que asigna una nota y fecha en un curso específico.
     *
     * @param fecha La fecha de la evaluación.
     * @param curso El curso al que pertenece la evaluación.
     * @param nota  La nota obtenida en la evaluación.
     */
    public Evaluacion(Date fecha, Curso curso, Integer nota) {
        this.nota = nota;
        this.fecha = fecha;
        this.curso = curso;
    }

    /**
     * Constructor de la clase Evaluacion que asigna una nota, fecha en una materia específica.
     *
     * @param fecha   La fecha de la evaluación.
     * @param curso   El curso al que pertenece la evaluación.
     * @param materia La materia evaluada.
     * @param nota    La nota obtenida en la evaluación.
     */
    public Evaluacion(Date fecha, Curso curso, Materia materia, Integer nota) {
        this.nota = nota;
        this.fecha = fecha;
        this.curso = curso;
        this.materia = materia;
    }

    /**
     * Obtiene la nota de la evaluación.
     *
     * @return La nota obtenida.
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * Establece la nota de la evaluación.
     *
     * @param nota La nota a asignar.
     */
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    /**
     * Obtiene la fecha de la evaluación.
     *
     * @return La fecha de la evaluación.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la evaluación.
     *
     * @param fecha La fecha a asignar.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el curso en el que se realizó la evaluación.
     *
     * @return El curso de la evaluación.
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * Establece el curso de la evaluación.
     *
     * @param curso El curso a asignar.
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * Obtiene la materia evaluada, si corresponde.
     *
     * @return La materia evaluada.
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Establece la materia evaluada.
     *
     * @param materia La materia a asignar.
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
