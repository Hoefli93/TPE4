package Verschluesselungsverfahren;

import java.util.List;

import Crypterzeug.Crypter;
import Crypterzeug.CrypterException;

public class CrypterSubstitution implements Crypter {

	String key;

	public CrypterSubstitution(String key) {
		this.key = key;

	}

	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		String result = null; //String buffer vllt mit append
		for (int i = 0; i < message.length(); i++) {
			result += key.charAt((int) (message.charAt(i) - 65));
		}
		return result.toString();
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}
}
