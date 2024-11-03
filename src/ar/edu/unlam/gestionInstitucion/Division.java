package ar.edu.unlam.gestionInstitucion;

import java.util.Set;
import java.util.HashSet;

/**
 * Clase que representa una división específica dentro de un curso. Extiende la
 * clase Curso e incluye una carga académica anual con un conjunto de materias.
 */
public class Division extends Curso {

    private Set<Materia> cargaAcademicaAnual;

    /**
     * Constructor de la clase Division.
     *
     * @param nombre     El nombre de la división.
     * @param edadMinima La edad mínima requerida para los alumnos de la división.
     */
    public Division(String nombre, Integer edadMinima) {
        super(nombre, edadMinima);
        this.cargaAcademicaAnual = new HashSet<>();
    }

    /**
     * Agrega un docente a la división basado en las materias de la carga académica
     * anual.
     *
     * @param docente El docente a agregar.
     * @return true si el docente se ha agregado exitosamente.
     * @throws RequisitoNoCumplidoException Si el docente no cumple con los
     *                                      requisitos necesarios.
     */
    @Override
    public Boolean agregarDocente(Docente docente) throws RequisitoNoCumplidoException {
        for (Materia m : cargaAcademicaAnual) {
            docentes.add(m.getDocente());
        }
        return true;
    }

    /**
     * Agrega un alumno a la división verificando los requisitos previos, como la
     * educación inicial y la edad mínima.
     *
     * @param alumno El alumno a agregar.
     * @throws RequisitoNoCumplidoException Si el alumno no cumple con los
     *                                      requisitos académicos o de edad para la
     *                                      división.
     */
    @Override
    public void agregarAlumno(Alumno alumno) throws RequisitoNoCumplidoException {
        if (!alumno.getExpediente().getJardin()) {
            throw new RequisitoNoCumplidoException("El alumno no ha completado la educación inicial.");
        } else if (nombre.equals("Primero")) {
            if (!alumno.getExpediente().getPrimaria()) {
                throw new RequisitoNoCumplidoException("El alumno no ha completado la educación primaria.");
            }
            if (alumno.getEdad() < this.edadMinima) {
                throw new RequisitoNoCumplidoException("El alumno no cumple con la edad mínima.");
            }
        } else if (alumno.getEdad() < this.edadMinima) {
            throw new RequisitoNoCumplidoException("El alumno no cumple con la edad mínima.");
        } else if (!alumno.aproboDivisionPrevio(this)) {
            throw new RequisitoNoCumplidoException("El alumno no cumple con los requisitos de aprobar división anterior");
        }
        alumnos.add(alumno);
    }

    /**
     * Obtiene el conjunto de materias de la carga académica anual de la división.
     *
     * @return Un conjunto de materias.
     */
    public Set<Materia> getCargaAcademicaAnual() {
        return cargaAcademicaAnual;
    }

    /**
     * Establece el conjunto de materias de la carga académica anual de la división.
     *
     * @param cargaAcademicaAnual El conjunto de materias a establecer.
     */
    public void setCargaAcademicaAnual(Set<Materia> cargaAcademicaAnual) {
        this.cargaAcademicaAnual = cargaAcademicaAnual;
    }
}
