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
		
		String ergebnis = "";
		for(int i = 0; i < message.length(); i++) {

			ergebnis= ergebnis+(schluessel.charAt((int)(message.charAt(i)-65))); 
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
		List<String> result = new LinkedList<String>();
		for(String text : messages) {
			result.add(encrypt(text));
		}
		return result;
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
		crypterText = crypterText.toUpperCase();
		
		String ergebnis = "";
		
		for(int i = 0; i < crypterText.length(); i++) {
			char a = (crypterText.charAt(i));
			ergebnis = ergebnis +(char)(suche(a)+65);		
		}
		return ergebnis.toString();
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
		for(String message : crypterTexte) {
			ergebnis.add(decrypt(message));
		}
		return ergebnis;
	}
	
	/**
	 * Entschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param gesuchterChar, ein char der mithilfe dieser Funktion gesucht wird.
	 *            
	 *
	 * @return position des chars im schluessel.
	 *           
	 */
	private int suche(char gesuchterChar) {
		for(int i = 0; i < schluessel.length(); i++) {
			if(gesuchterChar == schluessel.charAt(i)) {
				return i;
			}
		}
		return 0;

}
}