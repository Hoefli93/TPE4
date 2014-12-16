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

	String key;
	
	private static final long serialVersionUID = 1L;

	
	public IllegalKeyException(String message,String key) {
		super(message);
		this.key=key;
	}
	
	public String getKey(){
		return key;
	}

	public IllegalKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalKeyException(Throwable cause) {
		super(cause);
	}

}
