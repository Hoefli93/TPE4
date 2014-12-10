package Verschluesselungsverfahren;

import java.util.LinkedList;
import java.util.List;

import Crypterzeug.CrypterException;
import Crypterzeug.Crypter;

/**
 *
 * @author 1331770
 * 
 */
public class CaesarVerschlüsselung implements Crypter {

	private String schluessel;

	public CaesarVerschlüsselung(String schluessel) {
		this.schluessel = schluessel;

	}

	@Override
	public String encrypt(String text) throws CrypterException {
		int verschiebung = ((int) this.schluessel.charAt(0)) - 64;
		return encrypt(text, verschiebung);
	}

	private String encrypt(String text, int verschiebung) {
		text = text.toUpperCase();
		String ergebnis = "";
		for (int i = 0; i < text.length(); i++) {
			ergebnis += (char) ((text.charAt(i) - 'A' + verschiebung) % 26 + 'A');
		}
		return ergebnis;
	}

	@Override
	public List<String> encrypt(List<String> textKomplett) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String text : textKomplett) {
			ergebnis.add(encrypt(text));
		}
		return ergebnis;
	}

	@Override
	public String decrypt(String crypterText) throws CrypterException {
		int verschiebung = ((int) this.schluessel.charAt(0)) - 64;
		return decrypt(crypterText, -verschiebung);
	}

	private String decrypt(String text, int verschiebung) {
		String ergebnis = "";
		for (int i = 0; i < text.length(); i++) {

			char a = (char) ((text.charAt(i) - 'A' + verschiebung) % 26 + 'A');
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