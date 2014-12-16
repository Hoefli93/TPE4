package Verschlüsselungsverfahren;

import java.math.BigInteger;
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

	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		schluessel = schluessel.toUpperCase();
		StringBuffer ergebnis = new StringBuffer();
		for(int i = 0; i < message.length(); i++) {
			ergebnis.append(add(message.charAt(i), schluessel.charAt((i % schluessel.length()))));
		}
		return ergebnis.toString();
	}

	private char add(char message, char schluessel) {
		int a = charToValue(message);
		int b = charToValue(schluessel);

		String aBin = Integer.toBinaryString(a);
		String bBin = Integer.toBinaryString(b);
		while(aBin.length() < 5) {
			aBin = "0" + aBin;
		}
		
		while(bBin.length() < 5) {
			bBin = "0" + bBin;
		}

		StringBuffer ergebnis = new StringBuffer();
		for(int i = 0; i < 5; i++) {
			if(aBin.charAt(i) == bBin.charAt(i)) {
				ergebnis.append("0");
				
			}
			else{
				ergebnis.append("1");
			}
		}
		int dezWert = Integer.parseInt(ergebnis.toString(), 2);
		char[] zeichen = {'@', 'A','B','C','D','E','F','G','H','I','J','K','L',
				'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', 
				'[', '\\',']','^','_'};
		return zeichen[dezWert];
	}

	private int charToValue(char a) {

		String alphabet = ("@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_");
		for(int i = 0; i < alphabet.length(); i++) {
			if(a == alphabet.charAt(i)) {
				return (i);
			}
		}
		return 0;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for(String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	@Override
	public String decrypt(String crypterText) throws CrypterException {
		return encrypt(crypterText);
	}

	@Override
	public List<String> decrypt(List<String> crypterTexte)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for(String messages : crypterTexte) {
			ergebnis.add(decrypt(messages));
		}
		return ergebnis;
	}

}