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
		Crypter c2 = CrypterFactory.createCrypter("C", CrypterEnum.CAESAR);
	
		

		try {
		
			assertEquals("BGGF",c1.encrypt("AFFE"));
			assertEquals("FDHVDU",c2.encrypt("CAESAR"));

			
			assertEquals("AFFE",c1.decrypt("BGGF"));
			assertEquals("CAESAR",c2.decrypt("FDHVDU"));


		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}
	} 

	@Test
	public void crypterSubSchiff() throws CrypterException {

		Crypter s1 = CrypterFactory.createCrypter("UFLPWDRASJMCONQYBVTEXHZKGI",
				CrypterEnum.SUBSTITUTION);
		Crypter s2 = CrypterFactory.createCrypter("QWERTZUIOPASDFGHJKLYXCVBNM",
				CrypterEnum.SUBSTITUTION);
	
		try {

			assertEquals("ZSMSYWPSUSTESNDQVOUESH",s1.encrypt("WIKIPEDIAISTINFORMATIV"));
			assertEquals("QWERTZUIOPASDFGHJKLYXCVBNM",s2.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		
			assertEquals("WIKIPEDIAISTINFORMATIV",s1.decrypt("ZSMSYWPSUSTESNDQVOUESH"));
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",s2.decrypt("QWERTZUIOPASDFGHJKLYXCVBNM"));
		

		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testCrypterXOR() throws CrypterException {

		Crypter x1 = CrypterFactory.createCrypter("TPERULES", CrypterEnum.XOR);


		try {

			assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ",x1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",x1.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
			
		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testCrypterReverse() throws CrypterException {


		Crypter rev1 = CrypterFactory.createCrypter("", CrypterEnum.REVERSE);
		Crypter rev2 = CrypterFactory.createCrypter("A", CrypterEnum.REVERSE);


		try {

			assertEquals("ZYXWVUTSRQPONMLKJIHGFEDCBA",rev1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
			assertEquals("OMIT", rev2.encrypt("TIMO"));
			assertEquals("NANIS", rev1.encrypt("SINAN"));

			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",rev1.encrypt("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
			assertEquals("TIMO", rev2.encrypt("OMIT"));


		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testCrypterNull() throws CrypterException {

		Crypter null1 = CrypterFactory.createCrypter("A", CrypterEnum.NULL);
		Crypter null2 = CrypterFactory.createCrypter("B", CrypterEnum.NULL);

		try {

			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",null1.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",null2.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

			assertEquals("NULL", null1.encrypt("NULL"));
			assertEquals("NULL", null2.decrypt("NULL"));

		} catch (CrypterException e) {
			System.out.println(e.getMessage());
		}

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

