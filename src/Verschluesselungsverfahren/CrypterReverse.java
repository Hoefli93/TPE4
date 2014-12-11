package Verschluesselungsverfahren;

import java.util.LinkedList;
import java.util.List;

import Crypterzeug.Crypter;
import Crypterzeug.CrypterException;
/**
*
* @author 1331770
* @author 1320733
*/
public class CrypterReverse implements Crypter{

	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		String result = "";
		for(int i = message.length()-1; i > (-1); i--) {
			result += message.charAt(i);
		}
		return result;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new LinkedList<String>();
		for(String text : messages){
			result.add(encrypt(text));
		}
		return result;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return encrypt(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> result = new LinkedList<String>();
		for(String text : cypherTexte){
			result.add(decrypt(text));
		}
		return result;
	}

}