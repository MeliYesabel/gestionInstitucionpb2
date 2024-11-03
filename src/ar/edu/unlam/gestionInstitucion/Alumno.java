package ar.edu.unlam.gestionInstitucion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Representa un alumno que extiende de Persona 
 * y tiene propiedades propias
 * como división actual, expediente académico, notas y asistencias.
 */
public class Alumno extends Persona {

    private Curso divisionActual;
    private ExpedienteAcademico expediente;
    private List<Evaluacion> notas;
    private Set<Asistencia> asistencias;

    /**
     * Constructor de la clase Alumno.
     *
     * @param nombre   El nombre del alumno.
     * @param apellido El apellido del alumno.
     * @param edad     La edad del alumno.
     * @param dni      El número de DNI del alumno.
     */
    public Alumno(String nombre, String apellido, Integer edad, Integer dni) {
        super(nombre, apellido, edad, dni);
        this.expediente = new ExpedienteAcademico();
        this.notas = new ArrayList<>();
        this.asistencias = new HashSet<>();
    }

    /**
     * Obtiene las asistencias del alumno.
     *
     * @return Un conjunto de asistencias del alumno.
     */
    public Set<Asistencia> getAsistencias() {
        return asistencias;
    }

    /**
     * Establece las asistencias del alumno.
     *
     * @param asistencias Un conjunto de asistencias a establecer.
     */
    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    /**
     * Establece la división actual en la que el alumno está inscripto.
     *
     * @param divisionActual La división a la que pertenece actualmente.
     */
    public void setDivisionActual(Curso divisionActual) {
        this.divisionActual = divisionActual;
    }

    /**
     * Obtiene la división actual del alumno.
     *
     * @return La división actual en la que está inscrito el alumno.
     */
    public Curso getDivisionActual() {
        return divisionActual;
    }

    /**
     * Obtiene el expediente académico del alumno.
     *
     * @return El expediente académico del alumno.
     */
    public ExpedienteAcademico getExpediente() {
        return expediente;
    }

    /**
     * Establece el expediente académico del alumno.
     *
     * @param expediente El expediente académico a establecer.
     */
    public void setExpediente(ExpedienteAcademico expediente) {
        this.expediente = expediente;
    }

    /**
     * Verifica si el alumno ha aprobado un grado previo.
     *
     * @param grado El grado a verificar.
     * @return true si ha aprobado el grado previo; false en caso contrario.
     */
    public Boolean aproboGradoPrevio(Grado grado) {
        Integer edadMinimaDelGradoPrevio = grado.getEdadMinima() - 1;

        for (Grado e : expediente.getGrados()) {
            if (e.getEdadMinima().equals(edadMinimaDelGradoPrevio)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si el alumno ha aprobado una división previa.
     *
     * @param division La división a verificar.
     * @return true si ha aprobado la división previa; false en caso contrario.
     */
    public Boolean aproboDivisionPrevio(Division division) {
        Integer edadMinimaDelGradoPrevio = division.getEdadMinima() - 1;

        for (Division e : expediente.getDivisiones()) {
            if (e.getEdadMinima().equals(edadMinimaDelGradoPrevio)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega una nota de evaluación al alumno.
     *
     * @param evaluacion La evaluación a agregar a la lista de notas.
     */
    public void cargarNota(Evaluacion evaluacion) {
        notas.add(evaluacion);
    }

    /**
     * Obtiene la lista de notas del alumno.
     *
     * @return Una lista de evaluaciones del alumno.
     */
    public List<Evaluacion> getNotas() {
        return notas;
    }

    /**
     * Establece la lista de notas del alumno.
     *
     * @param notas La lista de evaluaciones a establecer.
     */
    public void setNotas(List<Evaluacion> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Alumno [Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Edad=" + getEdad() + ", DNI=" + getDni() + "]";
    }
}

