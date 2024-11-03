package ar.edu.unlam.gestionInstitucion;

/**
 * Representa un grado académico en una institución educativa.
 * Extiende la clase Curso y contiene la lógica para agregar docentes y alumnos
 * en función de requisitos específicos.
 */
public class Grado extends Curso {

    /**
     * Constructor para crear un nuevo grado.
     *
     * @param nombre      El nombre del grado.
     * @param edadMinima  La edad mínima requerida para este grado.
     */
    public Grado(String nombre, Integer edadMinima) {
        super(nombre, edadMinima);
    }

    /**
     * Agrega un docente a este grado, verificando que el docente tenga
     * experiencia en el grado y que no haya otro docente asignado.
     *
     * @param docente El docente a agregar.
     * @return true si el docente fue agregado exitosamente.
     * @throws RequisitoNoCumplidoException si el docente no tiene experiencia
     *                                       en este grado o si ya hay un docente asignado.
     */
    @Override
    public Boolean agregarDocente(Docente docente) throws RequisitoNoCumplidoException {
        if (!docente.getExpediente().getGrados().contains(this)) {
            throw new RequisitoNoCumplidoException("El docente no cuenta con experiencia en este grado");
        } else {
            if (docentes.size() != 0) {
                throw new RequisitoNoCumplidoException("Este grado ya tiene asignado docente.");
            }
        }
        docentes.add(docente);
        return true;
    }

    /**
     * Agrega un alumno a este grado, verificando que cumpla con los requisitos
     * de edad y que haya aprobado el grado previo, si es necesario.
     *
     * @param alumno El alumno a agregar.
     * @throws RequisitoNoCumplidoException si el alumno no ha cumplido con los
     *                                       requisitos necesarios.
     */
    @Override
    public void agregarAlumno(Alumno alumno) throws RequisitoNoCumplidoException {
        if (getNombre().equals("Primero")) {
            if (!alumno.getExpediente().getJardin()) {
                throw new RequisitoNoCumplidoException("El alumno no ha completado la educación inicial.");
            }
            if (alumno.getEdad() < this.getEdadMinima()) {
                throw new RequisitoNoCumplidoException("El alumno no cumple con la edad mínima de este curso.");
            }
        } else {
            if (!alumno.aproboGradoPrevio(this)) {
                throw new RequisitoNoCumplidoException(
                        "El alumno no cumple con los requisitos de aprobar grado anterior");
            }
            if (alumno.getEdad() < this.getEdadMinima()) {
                throw new RequisitoNoCumplidoException("El alumno no cumple con la edad mínima de este curso.");
            }
        }
        alumnos.add(alumno);
    }
}

