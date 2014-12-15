package Tests;

import java.util.Arrays;
import java.util.List;

import Verschlüsselungsverfahren.IterableCrypter;
import de.hs_ma.uib.tpe.g12.pue4.Crypter;
import de.hs_ma.uib.tpe.g12.pue4.CrypterEnum;
import de.hs_ma.uib.tpe.g12.pue4.CrypterFactory;
import Exceptions.IllegalKeyException;

public class IterableCryptoDemo {

	public static void main(String[] args) throws IllegalKeyException {
		
		Crypter caesar = CrypterFactory.createCrypter("U", CrypterEnum.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL",CrypterEnum.XOR);
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		
		IterableCrypter iterableCrypter = new IterableCrypter(new IterableCrypter(liste, caesar), xor);
		
		for (String crypterText : iterableCrypter) {
			System.out.println(crypterText);
		}
	}
}
