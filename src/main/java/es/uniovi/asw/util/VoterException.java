package es.uniovi.asw.util;

/**
 * @author Ricardo
 *
 */
public class VoterException extends Exception {

	private static final long serialVersionUID = -408694249125638961L;

	public VoterException() {}

	public VoterException(String message) {
		super(message);
	}

	public VoterException(Throwable cause) {
		super(cause);
	}

	public VoterException(String message, Throwable cause) {
		super(message, cause);
	}
}
