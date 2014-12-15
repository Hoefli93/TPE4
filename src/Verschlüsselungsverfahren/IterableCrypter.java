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
public class IterableCrypter implements Iterable<String> {

	private  Iterable<String> messages;
	private  Crypter crypter;

	public IterableCrypter(Iterable<String> messages, Crypter crypter) {
		this.messages = messages;
		this.crypter = crypter;
	}

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
					return crypter.encrypt(messagesIterator.next());
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
