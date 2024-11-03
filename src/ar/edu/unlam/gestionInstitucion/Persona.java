package ar.edu.unlam.gestionInstitucion;

import java.util.Objects;

/**
 * Representa una persona con nombre, apellido, edad y DNI.
 * Implementa la interfaz Comparable para ordenar por nombre.
 */
public class Persona implements Comparable<Persona> {
    private String nombre;
    private String apellido;
    private Integer edad;
    protected Integer dni;

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre   El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @param edad     La edad de la persona.
     * @param dni      El número de DNI de la persona.
     */
    public Persona(String nombre, String apellido, Integer edad, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     *
     * @return El apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona.
     *
     * @param apellido El apellido de la persona.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad La edad de la persona.
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el DNI de la persona.
     *
     * @return El DNI de la persona.
     */
    public Integer getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param dni El DNI de la persona.
     */
    public void setDni(Integer dni) {
        this.dni = dni;
    }

    /**
     * Genera el código hash para esta persona.
     *
     * @return Código hash basado en el DNI de la persona.
     */
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    /**
     * Compara si dos personas son iguales en función de su DNI.
     *
     * @param obj El objeto a comparar.
     * @return true si ambas personas tienen el mismo DNI; false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return Objects.equals(dni, other.dni);
    }

    /**
     * Compara esta persona con otra persona en orden alfabético por nombre.
     *
     * @param otro La persona a comparar.
     * @return Un valor negativo, cero o positivo si el nombre de esta persona es menor, igual o mayor al nombre de la otra persona.
     */
    public int compareTo(Persona otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    /**
     * Devuelve una representación en forma de cadena de esta persona.
     *
     * @return Una cadena que describe el nombre, apellido, edad y DNI de la persona.
     */
    @Override
    public String toString() {
        return "Persona [Nombre = " + nombre + ", Apellido = " + apellido + ", edad=" + edad + ", dni=" + dni + "]";
    }
}

