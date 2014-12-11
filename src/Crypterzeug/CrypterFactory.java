package Crypterzeug;

import Verschluesselungsverfahren.*;

public class CrypterFactory {

	public Crypter createCrypter(String schluessel, Enum selectedCrypter) {

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
