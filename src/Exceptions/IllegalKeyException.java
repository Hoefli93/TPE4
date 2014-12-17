package Exceptions;

import java.lang.Throwable;

/**
 *
 * @author 1331770
 * @author 1320733
 * @author 1312740
 * 
 */
public class IllegalKeyException extends CrypterException {

	private static final long serialVersionUID = 1L;

	public IllegalKeyException() {
		super("Ungültig");

	}

	/**
	 *
	 * @param message
	 *
	 */
	public IllegalKeyException(String message) {
		super(message);

	}

	/**
	 *
	 * @param message
	 *            ,cause
	 * 
	 */
	public IllegalKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 *
	 * @param cause
	 * 
	 */
	public IllegalKeyException(Throwable cause) {
		super(cause);
	}

}
