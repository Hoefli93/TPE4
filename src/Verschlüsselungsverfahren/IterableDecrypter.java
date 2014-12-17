package Verschlüsselungsverfahren;

import java.util.Iterator;

import Exceptions.CrypterException;
import de.hs_ma.uib.tpe.g12.pue4.Crypter;

/**
 *
 * @author 1331770
 * @author 1320733
 * @author 1312740
 * 
 */
public class IterableDecrypter implements Iterable<String> {

	private Iterable<String> messages;

	private final Crypter crypter;

	public IterableDecrypter(Iterable<String> messages, Crypter crypter) {
		this.messages = messages;
		this.crypter = crypter;
	}

	/**
	 * Returns an iterator over a set of elements of type String.
	 * 
	 * @return iterator
	 */
	@Override
	public Iterator<String> iterator() {

		return new Iterator<String>() {

			Iterator<String> messagesIterator = messages.iterator();

			@Override
			public boolean hasNext() {

				return messagesIterator.hasNext();
			}

			@Override
			public String next() {
				try {
					return crypter.decrypt(messagesIterator.next());
				} catch (CrypterException e) {

					return "";
				}
			}

			@Override
			public void remove() {

			}

		};
	}

}
