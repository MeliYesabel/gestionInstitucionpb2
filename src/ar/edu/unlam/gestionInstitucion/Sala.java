package ar.edu.unlam.gestionInstitucion;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Clase que representa una sala de clases en un jardín de infantes.
 * Extiende la clase Curso y define límites en la cantidad de alumnos.
 */
public class Sala extends Curso {
    private final Integer LIMITE_CANTIDAD_ALUMNOS = 10;

    /**
     * Constructor para la clase Sala.
     *
     * @param nombre      el nombre de la sala
     * @param edadMinima  la edad mínima de los alumnos en la sala
     */
    public Sala(String nombre, Integer edadMinima) {
        super(nombre, edadMinima);
        this.setDocentes(new LinkedList<>());
        this.alumnos = new HashSet<>();
    }

    /**
     * Obtiene el límite de cantidad de alumnos permitido en la sala.
     *
     * @return el límite de cantidad de alumnos
     */
    public Integer getLIMITE_CANTIDAD_ALUMNOS() {
        return LIMITE_CANTIDAD_ALUMNOS;
    }

    /**
     * Agrega un docente a la sala, cumpliendo con los requisitos establecidos.
     *
     * @param maestra el docente a agregar
     * @return true si el docente fue agregado correctamente, false en caso contrario
     */
    @Override
    public Boolean agregarDocente(Docente maestra) {
        if (maestra.getExpediente().getJardin() && getDocentes().size() < 2
                && buscarDocenteDNI(maestra.getDni()) == null) {
            getDocentes().add(maestra);
            return true;
        }
        return false;
    }

    /**
     * Agrega un alumno a la sala, siempre que no se supere el límite de alumnos.
     *
     * @param alumno el alumno a agregar
     */
    @Override
    public void agregarAlumno(Alumno alumno) {
        if (alumnos.size() < LIMITE_CANTIDAD_ALUMNOS) {
            alumnos.add(alumno);
        }
    }
}

