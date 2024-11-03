package ar.edu.unlam.gestionInstitucion;

import java.util.*;

/**
 * Clase abstracta que representa un curso. Incluye detalles como el nombre,
 * la edad mínima requerida, los alumnos y los docentes asignados.
 */
public abstract class Curso {
    public String nombre;
    protected Integer edadMinima;
    protected Set<Alumno> alumnos = new TreeSet<>();
    protected List<Docente> docentes = new ArrayList<>();

    /**
     * Constructor de la clase Curso.
     *
     * @param nombre     El nombre del curso.
     * @param edadMinima La edad mínima requerida para inscribirse en el curso.
     */
    public Curso(String nombre, Integer edadMinima) {
        this.nombre = nombre;
        this.edadMinima = edadMinima;
    }

    /**
     * Obtiene el nombre del curso.
     *
     * @return El nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del curso.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad mínima requerida para el curso.
     *
     * @return La edad mínima.
     */
    public Integer getEdadMinima() {
        return edadMinima;
    }

    /**
     * Establece la edad mínima requerida para el curso.
     *
     * @param edadMinima La edad mínima a establecer.
     */
    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    /**
     * Obtiene el conjunto de alumnos inscritos en el curso.
     *
     * @return Un conjunto de alumnos.
     */
    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Establece el conjunto de alumnos inscritos en el curso.
     *
     * @param alumnos El conjunto de alumnos a establecer.
     */
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Obtiene la lista de docentes asignados al curso.
     *
     * @return Una lista de docentes.
     */
    public List<Docente> getDocentes() {
        return docentes;
    }

    /**
     * Establece la lista de docentes asignados al curso.
     *
     * @param docentes La lista de docentes a establecer.
     */
    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    /**
     * Obtiene un conjunto de alumnos ordenados por DNI de menor a mayor.
     *
     * @return Un conjunto de alumnos ordenados por DNI.
     */
    public Set<Alumno> getAlumnosPorDNIMenorAMayor() {
        TreeSet<Alumno> alumnosPorDNI = new TreeSet<>(new OrdenadoPorDNIdeMenorAMayor());
        alumnosPorDNI.addAll(alumnos);
        return alumnosPorDNI;
    }

    /**
     * Elimina un docente del curso.
     *
     * @param docente El docente a eliminar.
     */
    public void eliminarDocente(Docente docente) {
        docentes.remove(docente);
    }

    /**
     * Elimina un alumno del curso.
     *
     * @param alumno El alumno a eliminar.
     */
    public void eliminarAlumno(Alumno alumno) {
        alumnos.remove(alumno);
    }

    /**
     * Busca un docente en el curso por su DNI.
     *
     * @param dni El DNI del docente a buscar.
     * @return El docente si se encuentra; null si no.
     */
    public Docente buscarDocenteDNI(Integer dni) {
        for (Docente docente : getDocentes()) {
            if (docente.getDni().equals(dni)) {
                return docente;
            }
        }
        return null;
    }

    /**
     * Obtiene un alumno en el curso por su DNI.
     *
     * @param dni El DNI del alumno a buscar.
     * @return El alumno si se encuentra; null si no.
     */
    public Alumno obtenerAlumno(Integer dni) {
        for (Alumno alumno : alumnos) {
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
        }
        return null;
    }

    /**
     * Registra la asistencia de un alumno en una fecha específica.
     *
     * @param fecha   La fecha de la asistencia.
     * @param alumno  El alumno al que se le registra la asistencia.
     * @param asistio Valor booleano indicando si el alumno asistió.
     * @throws FechaUtilizadaExption Si ya se registró la asistencia en esa fecha.
     */
    public void tomarAsistencia(Date fecha, Alumno alumno, Boolean asistio) throws FechaUtilizadaExption {
        if (alumno.getAsistencias().contains(new Asistencia(fecha, null))) {
            throw new FechaUtilizadaExption("El alumno ya tiene registrada su asistencia en la fecha indicada.");
        }
        alumno.getAsistencias().add(new Asistencia(fecha, asistio));
    }

    /**
     * Agrega un docente al curso. Este método debe ser implementado por las
     * subclases de Curso.
     *
     * @param docente El docente a agregar.
     * @return true si se agrega exitosamente; false en caso contrario.
     * @throws RequisitoNoCumplidoException Si no se cumplen los requisitos para agregar el docente.
     */
    public abstract Boolean agregarDocente(Docente docente) throws RequisitoNoCumplidoException;

    /**
     * Agrega un alumno al curso. Este método debe ser implementado por las
     * subclases de Curso.
     *
     * @param alumno El alumno a agregar.
     * @throws RequisitoNoCumplidoException Si no se cumplen los requisitos para agregar el alumno.
     */
    public abstract void agregarAlumno(Alumno alumno) throws RequisitoNoCumplidoException;

    @Override
    public String toString() {
        return "Nombre " + nombre + ", Edad minima " + edadMinima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Curso division = (Curso) o;
        return edadMinima.equals(division.edadMinima) && Objects.equals(nombre, division.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edadMinima);
    }
}
