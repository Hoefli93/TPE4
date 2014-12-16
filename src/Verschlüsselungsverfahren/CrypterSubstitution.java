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
public class CrypterSubstitution implements Crypter {

	private String schluessel;

	public CrypterSubstitution(String schluessel) {
		this.schluessel = schluessel;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < message.length(); i++) {

			result.append(schluessel.charAt((int)(message.charAt(i)-65))); 
		}
		return result.toString();
	}


	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new LinkedList<String>();
		for(String text : messages) {
			result.add(encrypt(text));
		}
		return result;
	}

	@Override
	public String decrypt(String crypterText) throws CrypterException {
		crypterText = crypterText.toUpperCase();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer ergebnis = new StringBuffer();
		for(int i = 0; i < crypterText.length(); i++) {
			char s = (crypterText.charAt(i));
			ergebnis.append(alphabet.charAt(entschluesseln(s)));		
		}
		return ergebnis.toString();
	}

	private int entschluesseln(char gesucht) {
		for(int j = 0; j < schluessel.length(); j++) {
			if(gesucht == schluessel.charAt(j)) {
				return j;
			}
		}
		return 0;
	}

	@Override
	public List<String> decrypt(List<String> crypterTexte)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for(String message : crypterTexte) {
			ergebnis.add(decrypt(message));
		}
		return ergebnis;
	}

}