package Verschluesselungsverfahren;

import java.util.List;

import Crypterzeug.Crypter;
import Crypterzeug.CrypterException;
/**
*
* @author 1331770
* @author 1320733
*/
public class CrypterNull implements Crypter{

	@Override
	public String encrypt(String message) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
