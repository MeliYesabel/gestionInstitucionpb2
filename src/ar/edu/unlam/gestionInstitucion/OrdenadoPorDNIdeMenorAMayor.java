package ar.edu.unlam.gestionInstitucion;

import java.util.Comparator;

/**
 * Clase que implementa el comparador para ordenar objetos de tipo Alumno 
 * por su DNI en orden ascendente (de menor a mayor).
 */
public class OrdenadoPorDNIdeMenorAMayor implements Comparator<Alumno> {

    /**
     * Compara dos objetos Alumno basándose en su DNI.
     *
     * @param o1 el primer Alumno a comparar
     * @param o2 el segundo Alumno a comparar
     * @return un valor negativo si o1 tiene un DNI menor que o2,
     *         cero si son iguales, o un valor positivo si o1 tiene un DNI mayor que o2
     */
    @Override
    public int compare(Alumno o1, Alumno o2) {
        return Integer.compare(o1.getDni(), o2.getDni());
    }
}

