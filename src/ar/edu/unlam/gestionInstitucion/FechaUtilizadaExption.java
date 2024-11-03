package ar.edu.unlam.gestionInstitucion;

/**
 * Excepción que se lanza cuando se intenta registrar la asistencia de un alumno
 * en una fecha que ya se uso.
 */
public class FechaUtilizadaExption extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor que inicializa la excepción con un mensaje específico.
     *
     * @param mensaje El mensaje que describe el motivo de la excepción.
     */
    public FechaUtilizadaExption(String mensaje) {
        super(mensaje);
    }
}
