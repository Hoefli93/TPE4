package Verschlüsselungsverfahren;

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
public class CrypterNull implements Crypter {

   
    /**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param message
	 *            Nachricht, die Verschluesselt werden soll.
	 *
	 * @return verschluesselter Text, in diesem Fall selber Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
    @Override
    public String encrypt(String message) throws CrypterException {
        return message;
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
        for(String thisString : messages){
            thisString = encrypt(thisString);
        }
        return messages;
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
    public List<String> decrypt(List<String> crypterTexte) throws CrypterException {
        return encrypt(crypterTexte);
    }

}