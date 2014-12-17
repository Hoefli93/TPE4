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
public class CrypterCaesar implements Crypter {

	private String schluessel;

	public CrypterCaesar(String schluessel) {
		this.schluessel = schluessel;

	}

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param message
	 *            Nachricht, die Verschluesselt werden soll.
	 *
	 * @return verschluesselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		int verschiebung = (int) this.schluessel.charAt(0) - 64;
		return encrypt(message, verschiebung);
	}

	private String encrypt(String message, int verschiebung) {
		message = message.toUpperCase();
		String ergebnis = "";

		for (int i = 0; i < message.length(); i++) {
			ergebnis = ergebnis
					+ (char) ((message.charAt(i) - 65 + verschiebung) % 26 + 65);
		}
		return ergebnis;
	}

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param messages
	 *            Nachrichten, die Verschluesselt werden soll.
	 *
	 * @return verschluesselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param crypterText
	 *            Nachricht, die entschluesselt werden soll.
	 *
	 * @return entschluesselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	@Override
	public String decrypt(String crypterText) throws CrypterException {
		int verschiebung = ((int) this.schluessel.charAt(0)) - 64;
		return decrypt(crypterText, -verschiebung);
	}

	private String decrypt(String message, int verschiebung) {
		return encrypt(message, verschiebung);

	}

	/**
	 * Entschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param crypterTexte
	 *            Nachrichten, die entschluesselt werden soll.
	 *
	 * @return entschluesselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	@Override
	public List<String> decrypt(List<String> crypterTexte)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String text : crypterTexte) {
			ergebnis.add(decrypt(text));
		}
		return ergebnis;
	}

}