package de.hs_ma.uib.tpe.g12.pue4;

import java.util.List;

import Exceptions.CrypterException;

/**
 * Grundlegendes Interface, um Verschlusselung durchzufuhren. Mit Hilfe dieses
 * Interfaces kann man Nachrichten verschlusseln (uber die
 * {@link #encrypt(String)} Methode) und wieder entschlusseln (uber die
 * {@link #decrypt(String)} Methode).
 *
 * Der Eingabetext ({@literal message}) darf nur aus den Gro-Buchstaben A-Z
 * bestehen. Kleinbuchstaben werden in Grobuchstaben umgewandelt, alle anderen
 * Zeichen werden ohne Ruckmeldung entfernt (einschlielich der Leerzeichen).
 *
 * Zwischen den beiden Methoden muss bei gleichem Schlussel {@code key}
 * folgendes gelten: {@code text.equals(decrypt(encrypt(text)) == true}.
 *
 * /**
 *
 * @author 1331770
 * @author 1320733
 * @author 1312740
 * 
 */

public interface Crypter {
	/**
	 * Verschlusselt den gegebenen Text mit dem angegebenen Schlussel.
	 *
	 * @param message
	 *            Nachricht, die Verschlusselt werden soll.
	 *
	 * @return verschlusselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlusselung
	 *             auftreten.
	 */
	public String encrypt(String message) throws CrypterException;

	/**
	 * Verschlusselt den gegebenen Text mit dem angegebenen Schlussel.
	 *
	 * @param messages
	 *            Nachrichten, die Verschluesselt werden soll.
	 *
	 * @return verschlusselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	public List<String> encrypt(List<String> messages) throws CrypterException;

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schlussel.
	 *
	 * @param cypherText
	 *            Nachricht, die entschlusselt werden soll.
	 *
	 * @return entschlusselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschluesselung
	 *             auftreten.
	 */
	public String decrypt(String cypherText) throws CrypterException;

	/**
	 * Entschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 *
	 * @param cypherTexte
	 *            Nachrichten, die entschlusselt werden soll.
	 *
	 * @return entschlusselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlusselung
	 *             auftreten.
	 */
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException;
}
