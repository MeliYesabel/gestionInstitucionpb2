package ar.edu.unlam.gestionInstitucion;

/**
 * Excepción que se lanza cuando un requisito no se cumple en el contexto educativo.
 * Esta clase extiende de la clase Exception.
 */
public class RequisitoNoCumplidoException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor que inicializa la excepción con un mensaje específico.
     *
     * @param mensaje el mensaje que describe el motivo de la excepción
     */
    public RequisitoNoCumplidoException(String mensaje) {
        super(mensaje);
    }
}

