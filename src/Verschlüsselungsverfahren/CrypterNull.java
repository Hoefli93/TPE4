package Verschlüsselungsverfahren;

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
