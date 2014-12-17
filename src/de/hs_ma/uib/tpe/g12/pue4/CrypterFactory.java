package de.hs_ma.uib.tpe.g12.pue4;

import Exceptions.CrypterException;
import Exceptions.IllegalKeyException;
import Verschlüsselungsverfahren.*;

/**
 *
 * @author 1331770
 * @author 1320733
 * @author 1312740
 * 
 */
public class CrypterFactory {

	/**
	 *
	 * @param schluessel
	 *            ,crypterAuswahl
	 * @return Objekt eines Verschluesselungsverfahrens
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	public static Crypter createCrypter(String schluessel,
			CrypterEnum crypterAuswahl) throws IllegalKeyException {

		schluessel = schluessel.toUpperCase();

		checkSchluessel(schluessel);

		switch (crypterAuswahl) {
		case CAESAR:
			return new CrypterCaesar(schluessel);
		case NULL:
			return new CrypterNull();
		case REVERSE:
			return new CrypterReverse();
		case SUBSTITUTION:
			return new CrypterSubstitution(schluessel);
		case XOR:
			return new CrypterXOR(schluessel);
		default:
			return null;
		}

	}

	/**
	 *
	 * @param schluessel
	 * @return Exception wenn Fehler auftritt, sonst nichts
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	public static void checkSchluessel(String schluessel)
			throws IllegalKeyException {
		for (int i = 0; i < schluessel.length(); i++) {
			if (schluessel.charAt(i) < '@' || schluessel.charAt(i) > '_') {
				throw new IllegalKeyException();
			}

		}
	}
}
