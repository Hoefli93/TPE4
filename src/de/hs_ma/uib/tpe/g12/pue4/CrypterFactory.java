package de.hs_ma.uib.tpe.g12.pue4;

import Verschl�sselungsverfahren.*;

/**
*
* @author 1331770
* @author 1320733
* @author 1312740
* 
*/
public class CrypterFactory {

	public Crypter createCrypter(String schluessel, CrypterEnum selectedCrypter) {

		switch (selectedCrypter) {
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
}
