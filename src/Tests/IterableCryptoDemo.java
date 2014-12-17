package Tests;

import java.util.Arrays;
import java.util.List;

import Verschlüsselungsverfahren.IterableCrypter;
import Verschlüsselungsverfahren.IterableDecrypter;
import de.hs_ma.uib.tpe.g12.pue4.Crypter;
import de.hs_ma.uib.tpe.g12.pue4.CrypterEnum;
import de.hs_ma.uib.tpe.g12.pue4.CrypterFactory;
import Exceptions.IllegalKeyException;

/**
 *
 * @author 1331770
 * @author 1320733
 * @author 1312740
 * 
 */

public class IterableCryptoDemo {

	public static void main(String[] args) throws IllegalKeyException {

		Crypter caesar = CrypterFactory.createCrypter("U", CrypterEnum.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL",
				CrypterEnum.XOR);

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");

		IterableCrypter iterableCrypter = new IterableCrypter(
				new IterableCrypter(liste, caesar), xor);

		for (String crypterText : iterableCrypter) {
			System.out.println(crypterText);
		}

		/*
		 * List<String> a = Arrays.asList("QOZEG]", "A[UXDKZIZLAB\"", "NUQIO",
		 * "^^RXYHADV[", "EFFJ\\", "[\"", "U_]YDVZABDZT\"", "V\"", "SKB@X");
		 * 
		 * Crypter caesarA = CrypterFactory.createCrypter("L",
		 * CrypterEnum.CAESAR); Crypter subchiffre =
		 * CrypterFactory.createCrypter( "MNBVCXYLKJHGFDSAPOIUZTREWQ",
		 * CrypterEnum.SUBSTITUTION); Crypter reverse =
		 * CrypterFactory.createCrypter("", CrypterEnum.REVERSE); Crypter xor1 =
		 * CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CrypterEnum.XOR);
		 * 
		 * IterableDecrypter iterableDeCrypter =
		 * 
		 * new IterableDecrypter(new IterableDecrypter(new IterableDecrypter(
		 * new IterableDecrypter((a), xor1), reverse), caesarA), subchiffre);
		 * for (String crypterText1 : iterableDeCrypter) {
		 * System.out.println(crypterText1);
		 */

	}
}
