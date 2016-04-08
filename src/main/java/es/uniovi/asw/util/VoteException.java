package es.uniovi.asw.util;

/**
 * @author ivan
 *
 */
public class VoteException extends Exception {

	private static final long serialVersionUID = -408694249125638961L;

	public VoteException() {}

	public VoteException(String message) {
		super(message);
	}

	public VoteException(Throwable cause) {
		super(cause);
	}

	public VoteException(String message, Throwable cause) {
		super(message, cause);
	}
}
