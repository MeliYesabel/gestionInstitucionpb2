package ar.edu.unlam.gestionInstitucion;


/**
 * Clase que representa a un docente, extendiendo la clase Persona.
 * Incluye el expediente académico que detalla su experiencia.
 */
public class Docente extends Persona {

    private ExpedienteAcademico experiencia;

    /**
     * Constructor de la clase Docente.
     *
     * @param nombre   El nombre del docente.
     * @param apellido El apellido del docente.
     * @param edad     La edad del docente.
     * @param dni      El DNI del docente.
     */
    public Docente(String nombre, String apellido, Integer edad, Integer dni) {
        super(nombre, apellido, edad, dni);
        this.experiencia = new ExpedienteAcademico();
    }

    /**
     * Obtiene el expediente académico del docente.
     *
     * @return El expediente académico.
     */
    public ExpedienteAcademico getExpediente() {
        return experiencia;
    }

    /**
     * Establece si el docente tiene experiencia en el nivel de jardín.
     *
     * @param esMaestro true si el docente es maestro de jardín, false en caso contrario.
     */
    public void esMaestroDeJardin(Boolean esMaestro) {
        this.experiencia.setJardin(esMaestro);
    }

    /**
     * Agrega experiencia del docente en un grado específico de primaria.
     *
     * @param grado El grado de primaria en el que tiene experiencia.
     */
    public void agregarExperienciaPrimaria(Grado grado) {
        this.experiencia.agregarGrado(grado);
    }

    /**
     * Agrega una materia en la que el docente tiene experiencia.
     *
     * @param materia La materia en la que tiene experiencia.
     */
    public void adoptarExperienciaEnMateria(Materia materia) {
        this.experiencia.agregarMateria(materia);
    }

    /**
     * Evalúa a un alumno de primaria si el alumno pertenece al curso y el docente tiene experiencia en el grado.
     *
     * @param alumno     El alumno a evaluar.
     * @param evaluacion La evaluación a realizar.
     * @throws RequisitoNoCumplidoException Si el alumno no pertenece al grado o el docente no tiene experiencia en el grado.
     */
    public void evaluarAlumnoDePrimari(Alumno alumno, Evaluacion evaluacion) throws RequisitoNoCumplidoException {
        if (!evaluacion.getCurso().getAlumnos().contains(alumno)) {
            throw new RequisitoNoCumplidoException("El alumno no se encuentra en este grado");
        } else if (!this.experiencia.getGrados().contains(evaluacion.getCurso())) {
            throw new RequisitoNoCumplidoException("El docente no se encuentra en condiciones para evaluar un alumno de este grado");
        }
        alumno.cargarNota(evaluacion);
    }

    /**
     * Evalúa a un alumno por una materia específica, si el alumno está inscrito y el docente tiene experiencia en la materia.
     *
     * @param alumno     El alumno a evaluar.
     * @param evaluacion La evaluación a realizar.
     * @throws RequisitoNoCumplidoException Si el alumno no está inscrito en la materia o el docente no tiene experiencia en ella.
     */
    public void evaluarAlumnoPorMateria(Alumno alumno, Evaluacion evaluacion) throws RequisitoNoCumplidoException {
        if (!evaluacion.getCurso().getAlumnos().contains(alumno)) {
            throw new RequisitoNoCumplidoException("El alumno no se encuentra en esta división");
        } else if (!this.experiencia.getMaterias().contains(evaluacion.getMateria())) {
            throw new RequisitoNoCumplidoException("El docente no se encuentra en condiciones para evaluar un alumno de este grado");
        }
        alumno.cargarNota(evaluacion);
    }
}

