package Exceptions;

import java.lang.Throwable;

/**
 *
 * @author 1331770
 * @author 1320733
 * @author 1312740
 * 
 */
public class CrypterException extends Exception {

	private static final long serialVersionUID = 1L;

	public CrypterException() {
		super();
	}

	/**
	 *
	 * @param message
	 *
	 */
	public CrypterException(String message) {
		super(message);
	}

	/**
	 *
	 * @param message
	 *            ,cause
	 *
	 */
	public CrypterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 *
	 * @param cause
	 *
	 */
	public CrypterException(Throwable cause) {
		super(cause);
	}
}
