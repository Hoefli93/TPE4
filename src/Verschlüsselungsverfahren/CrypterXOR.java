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
public class CrypterXOR implements Crypter {

	private String schluessel;

	public CrypterXOR(String schluessel) {
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
		message = message.toUpperCase();
		schluessel = schluessel.toUpperCase();
		String ergebnis = "";
		for (int i = 0; i < message.length(); i++) {
			ergebnis = ergebnis
					+ anhaengen(message.charAt(i),
							schluessel.charAt((i % schluessel.length())));
		}
		return ergebnis.toString();
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
		return encrypt(crypterText);
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
		for (String messages : crypterTexte) {
			ergebnis.add(decrypt(messages));
		}
		return ergebnis;
	}

	/**
	 * Hilfsmethode zur Verschluesselung der Buchstaben eines Wortes
	 *
	 * @param message
	 *            , schluessel
	 * 
	 *
	 * @return verschluesselter Buchstabe
	 * 
	 */

	private char anhaengen(char message, char schluessel) {

		String binaerEins = Integer.toBinaryString(message - 64);
		String binaerZwei = Integer.toBinaryString(schluessel - 64);

		while (binaerEins.length() < 5) {
			binaerEins = "0" + binaerEins;
		}

		while (binaerZwei.length() < 5) {
			binaerZwei = "0" + binaerZwei;
		}

		String ergebnis = "";
		for (int i = 0; i < 5; i++) {
			if (binaerEins.charAt(i) == binaerZwei.charAt(i)) {
				ergebnis = ergebnis + "0";
			} else {
				ergebnis = ergebnis + "1";
			}
		}
		int dezWert = Integer.parseInt(ergebnis.toString(), 2);

		return (char) (dezWert + 64);
	}

}