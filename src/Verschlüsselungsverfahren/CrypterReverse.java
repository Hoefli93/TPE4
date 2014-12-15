package Verschlüsselungsverfahren;

import java.util.LinkedList;
import java.util.List;

import Exceptions.CrypterException;
import de.hs_ma.uib.tpe.g12.pue4.Crypter;

/**
*
* @author 1331770
* @author 1320733
* @author 1312740
* 
*/
public class CrypterReverse implements Crypter{

	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		String ergebnis = "";
		for(int i = message.length()-1; i > (-1); i--) {
			ergebnis += message.charAt(i);
		}
		return ergebnis;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for(String message : messages){
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	@Override
	public String decrypt(String crypterText) throws CrypterException {
		return encrypt(crypterText);
	}

	@Override
	public List<String> decrypt(List<String> crypterTexte)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for(String message : crypterTexte){
			ergebnis.add(decrypt(message));
		}
		return ergebnis;
	}

}