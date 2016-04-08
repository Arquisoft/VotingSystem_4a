package es.uniovi.asw.util;

/**
 * @author ivan
 *
 */
public class ParametersException extends Exception {

	private static final long serialVersionUID = -408694249125638961L;

	public ParametersException() {}

	public ParametersException(String message) {
		super(message);
	}

	public ParametersException(Throwable cause) {
		super(cause);
	}

	public ParametersException(String message, Throwable cause) {
		super(message, cause);
	}
}
