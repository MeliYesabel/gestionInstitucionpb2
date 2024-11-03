package ar.edu.unlam.gestionInstitucion;

import java.util.Date;
import java.util.Objects;

/**
 * Representa la asistencia de un alumno en una fecha específica.
 */

public class Asistencia {
    private Boolean asistio;
    private Date fecha;    
    
    /**
     * Constructor de la clase Asistencia.
     *
     * @param fecha La fecha de la asistencia.
     * @param asistencia Indica si el alumno asistió (true) o no (false).
     */
    public Asistencia(Date fecha, Boolean asistencia) {
        this.asistio = asistencia;
        this.fecha = fecha;
    }

    /**
     * Obtiene el estado de asistencia.
     *
     * @return true si el alumno asistió, false si no asistió.
     */
    public Boolean getAsistio() {
        return asistio;
    }

    /**
     * Establece el estado de asistencia.
     *
     * @param asistio true si el alumno asistió, false si no asistió.
     */
    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }

    /**
     * Obtiene la fecha de la asistencia.
     *
     * @return La fecha en la que se registró la asistencia.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la asistencia.
     *
     * @param fecha La fecha en la que se registrará la asistencia.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Genera el código hash para esta instancia de Asistencia.
     *
     * @return Código hash basado en la fecha de la asistencia.
     */
    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }

    /**
     * Compara si dos objetos Asistencia son iguales en función de su fecha.
     *
     * @param obj El objeto a comparar.
     * @return true si ambos objetos tienen la misma fecha; false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Asistencia other = (Asistencia) obj;
        return Objects.equals(fecha, other.fecha);
    }

    /**
     * Devuelve una representación en forma de cadena de esta instancia de Asistencia.
     *
     * @return Una cadena que describe la asistencia y la fecha.
     */
    @Override
    public String toString() {
        return "Asistencia [asistio=" + asistio + ", fecha=" + fecha + "]";
    }
}


