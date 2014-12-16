package Tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Exceptions.CrypterException;
import Verschlüsselungsverfahren.IterableCrypter;
import Verschlüsselungsverfahren.IterableDecrypter;
import de.hs_ma.uib.tpe.g12.pue4.Crypter;
import de.hs_ma.uib.tpe.g12.pue4.CrypterFactory;
import de.hs_ma.uib.tpe.g12.pue4.CrypterEnum;

public class JUnit {

	@Test
	public void crypterCeasar() throws CrypterException {

		Crypter c1 = CrypterFactory.createCrypter("A", CrypterEnum.CAESAR);
		Crypter c2 = CrypterFactory.createCrypter("B", CrypterEnum.CAESAR);
		Crypter c3 = CrypterFactory.createCrypter("C", CrypterEnum.CAESAR);
		Crypter c4 = CrypterFactory.createCrypter("d", CrypterEnum.CAESAR);
		Crypter c5 = CrypterFactory.createCrypter(null, CrypterEnum.CAESAR);

		try {

			assertEquals("BCDEFGHIJKLMNOPQRSTUVWXYZA",
					c1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
			assertEquals("CDEFGHIJKLMNOPQRSTUVWXYZAB",
					c2.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
			assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC",
					c3.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					c1.decrypt("BCDEFGHIJKLMNOPQRSTUVWXYZA"));
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					c2.decrypt("CDEFGHIJKLMNOPQRSTUVWXYZAB"));
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					c3.decrypt("DEFGHIJKLMNOPQRSTUVWXYZABC"));
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					c4.decrypt("EFGHIJKLMNOPQRSTUVWXYZABCD"));

			assertEquals("FDHVDU", c5.encrypt("CAESAR"));
			assertEquals("CAESAR", c5.decrypt("FDHVDU"));

		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void crypterSubChiff() throws CrypterException {

		Crypter s1 = CrypterFactory.createCrypter("UFLPWDRASJMCONQYBVTEXHZKGI",
				CrypterEnum.SUBSTITUTION);
		Crypter s2 = CrypterFactory.createCrypter("QWERTZUIOPASDFGHJKLYXCVBNM",
				CrypterEnum.SUBSTITUTION);
		Crypter s3 = CrypterFactory.createCrypter("MNBVCXYASDFGHJKLOPIUZTREWQ",
				CrypterEnum.SUBSTITUTION);
		Crypter s4 = CrypterFactory.createCrypter("uskfmlofpdshwnshfjetidkend",
				CrypterEnum.SUBSTITUTION);

		try {

			// Encrypt-Test
			assertEquals("UFLPWDRASJMCONQYBVTEXHZKGI",
					s1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
			assertEquals("QWERTZUIOPASDFGHJKLYXCVBNM",
					s2.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
			assertEquals("MNBVCXYASDFGHJKLOPIUZTREWQ",
					s3.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

			// Decrypt-Test
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					s1.decrypt("UFLPWDRASJMCONQYBVTEXHZKGI"));
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					s2.decrypt("QWERTZUIOPASDFGHJKLYXCVBNM"));
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					s3.decrypt("MNBVCXYASDFGHJKLOPIUZTREWQ"));

			// Encrypt-Decrypt-Test
			assertEquals("TXFTESEXESQN", s1.encrypt("SUBSTITUTION"));
			assertEquals("SUBSTITUTION", s1.decrypt("TXFTESEXESQN"));

		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testCrypterXOR() throws CrypterException {

		// Crypter-TESTOBJEKTE
		Crypter x1 = null;
		Crypter x2 = null;
		Crypter x3 = null;
		Crypter x4 = null;
		Crypter x5 = null;
		Crypter x6 = null;

		x1 = CrypterFactory.createCrypter("TPERULES", CrypterEnum.XOR);

		try {
			// Encrypt-Test
			assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ",
					x1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

			// Decrypt-Test
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					x1.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
		} catch (CrypterException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCrypterReverse() throws CrypterException {

		// Crypter-TESTOBJEKTE
		Crypter rev1 = null;
		Crypter rev2 = null;
		Crypter rev3 = null;

		rev1 = CrypterFactory.createCrypter(null, CrypterEnum.REVERSE);
		rev2 = CrypterFactory.createCrypter(null, CrypterEnum.REVERSE);
		rev3 = CrypterFactory.createCrypter(null, CrypterEnum.REVERSE);

		try {

			assertEquals("ZYXWVUTSRQPONMLKJIHGFEDCBA",
					rev1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
			assertEquals("OMIT", rev2.encrypt("TIMO"));
			assertEquals("NANIS", rev3.encrypt("SINAN"));

			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					rev1.encrypt("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
			assertEquals("TIMO", rev2.encrypt("NITSUD"));

			assertEquals("ESREVER", rev3.encrypt("REVERSE"));
			assertEquals("REVERSE", rev3.decrypt("ESREVER"));

		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testCrypterNull() throws CrypterException {

		Crypter null1 = null;
		Crypter null2 = null;

		null1 = CrypterFactory.createCrypter(null, CrypterEnum.NULL);

		null2 = CrypterFactory.createCrypter("B", CrypterEnum.NULL);

		try {

			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					null1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
					null1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

			assertEquals("NULL", null1.encrypt("NULL"));
			assertEquals("NULL", null1.decrypt("NULL"));

		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testCrypterDecrypterIterable() throws CrypterException {

		Crypter c1 = null;
		Crypter s2 = null;
		Crypter x3 = null;
		Crypter null4 = null;
		Crypter rev5 = null;

		c1 = CrypterFactory.createCrypter("A", CrypterEnum.CAESAR);
		s2 = CrypterFactory.createCrypter("BCDEFGHIJKLMNOPQRSTUVWXYZA",CrypterEnum.SUBSTITUTION);
		x3 = CrypterFactory.createCrypter("ABCD", CrypterEnum.XOR);
		null4 = CrypterFactory.createCrypter(null, CrypterEnum.NULL);
		rev5 = CrypterFactory.createCrypter(null, CrypterEnum.REVERSE);

		List<String> list = Arrays.asList("ABCD", "EFG", "HIJ", "KLMN");

		IterableCrypter caesarCrypter = new IterableCrypter(list, c1);
		IterableCrypter substitutionCrypter = new IterableCrypter(list, s2);
		IterableCrypter xorCrypter = new IterableCrypter(list, x3);
		IterableCrypter nullCrypter = new IterableCrypter(list, null4);
		IterableCrypter reverseCrypter = new IterableCrypter(list, rev5);

		IterableDecrypter caesarDecrypter = new IterableDecrypter(list, c1);
		IterableDecrypter substitutionDecrypter = new IterableDecrypter(list,
				s2);
		IterableDecrypter xorDecrypter = new IterableDecrypter(list, x3);
		IterableDecrypter nullDecrypter = new IterableDecrypter(list, null4);
		IterableDecrypter reverseDecrypter = new IterableDecrypter(list, rev5);

		for (String crypterText : caesarCrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : substitutionCrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : xorCrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : nullCrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : reverseCrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : caesarDecrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : substitutionDecrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : xorDecrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : nullDecrypter) {
			System.out.println(crypterText);
		}

		for (String crypterText : reverseDecrypter) {
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
		 * CrypterFactory.createCrypter(null, CrypterEnum.REVERSE); Crypter xor1
		 * = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS",
		 * CrypterEnum.XOR);
		 * 
		 * IterableDecrypter iterableDeCrypter =
		 * 
		 * new IterableDecrypter(new IterableDecrypter(new IterableDecrypter(
		 * new IterableDecrypter((a), xor1), reverse), caesarA), subchiffre);
		 * for (String crypterText1 : iterableDeCrypter) {
		 * System.out.println(crypterText1);
		 * 
		 * }
		 */

	}

}