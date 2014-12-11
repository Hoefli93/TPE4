package Verschluesselungsverfahren;

import java.util.LinkedList;
import java.util.List;
import Crypterzeug.CrypterException;
import Crypterzeug.Crypter;

/**
 *
 * @author 1331770
 * @author 1320733
 * 
 */
public class CrypterCaesar implements Crypter {

	private String schluessel;

	public CrypterCaesar(String schluessel) {
		this.schluessel = schluessel;

	}

	@Override
	public String encrypt(String message) throws CrypterException {
		int verschiebung = (int) this.schluessel.charAt(0) - 64;
		return encrypt(message, verschiebung);
	}

	private String encrypt(String message, int verschiebung) {
		message = message.toUpperCase();
		String ergebnis = "";
		for (int i = 0; i < message.length(); i++) {
			ergebnis += (char) ((message.charAt(i) - 'A' + verschiebung) % 26 + 'A');
		}
		return ergebnis;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	@Override
	public String decrypt(String crypterText) throws CrypterException {
		int verschiebung = ((int) this.schluessel.charAt(0)) - 64;
		return decrypt(crypterText, -verschiebung);
	}

	private String decrypt(String message, int verschiebung) {
		String ergebnis = "";
		for (int i = 0; i < message.length(); i++) {

			char a = (char) ((message.charAt(i) - 'A' + verschiebung) % 26 + 'A');
			if (a < 65) {
				ergebnis += (char) (a + 26);
			} else {
				ergebnis += (char) a;
			}
		}
		return ergebnis;

	}

	@Override
	public List<String> decrypt(List<String> crypterTextKomplett)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String text : crypterTextKomplett) {
			ergebnis.add(decrypt(text));
		}
		return ergebnis;
	}

}