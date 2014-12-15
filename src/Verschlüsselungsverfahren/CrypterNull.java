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
public class CrypterNull implements Crypter {

   
    public CrypterNull(){
        super();
    }
    
    @Override
    public String encrypt(String message) throws CrypterException {
        return message;
    }

    @Override
    public List<String> encrypt(List<String> messages) throws CrypterException {
        for(String thisString : messages){
            thisString = encrypt(thisString);
        }
        return messages;
    }

    @Override
    public String decrypt(String crypterText) throws CrypterException {
        return encrypt(crypterText);
    }

    @Override
    public List<String> decrypt(List<String> crypterTexte) throws CrypterException {
        return encrypt(crypterTexte);
    }

}